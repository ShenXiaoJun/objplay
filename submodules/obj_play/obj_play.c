/** 
 * 最简单的基于FFmpeg的视频播放器2(SDL升级版) 
 * Simplest FFmpeg Player 2(SDL Update) 
 * 
 * 雷霄骅 Lei Xiaohua 
 * leixiaohua1020@126.com 
 * 中国传媒大学/数字电视技术 
 * Communication University of China / Digital TV Technology 
 * http://blog.csdn.net/leixiaohua1020 
 * 
 * 第2版使用SDL2.0取代了第一版中的SDL1.2 
 * Version 2 use SDL 2.0 instead of SDL 1.2 in version 1. 
 * 
 * 本程序实现了视频文件的解码和显示(支持HEVC，H.264，MPEG2等)。 
 * 是最简单的FFmpeg视频解码方面的教程。 
 * 通过学习本例子可以了解FFmpeg的解码流程。 
 * 本版本中使用SDL消息机制刷新视频画面。 
 * This software is a simplest video player based on FFmpeg. 
 * Suitable for beginner of FFmpeg. 
 * 
 * 备注: 
 * 标准版在播放视频的时候，画面显示使用延时40ms的方式。这么做有两个后果： 
 * （1）SDL弹出的窗口无法移动，一直显示是忙碌状态 
 * （2）画面显示并不是严格的40ms一帧，因为还没有考虑解码的时间。 
 * SU（SDL Update）版在视频解码的过程中，不再使用延时40ms的方式，而是创建了 
 * 一个线程，每隔40ms发送一个自定义的消息，告知主函数进行解码显示。这样做之后： 
 * （1）SDL弹出的窗口可以移动了 
 * （2）画面显示是严格的40ms一帧 
 * Remark: 
 * Standard Version use's SDL_Delay() to control video's frame rate, it has 2 
 * disadvantages: 
 * (1)SDL's Screen can't be moved and always "Busy". 
 * (2)Frame rate can't be accurate because it doesn't consider the time consumed  
 * by avcodec_decode_video2() 
 * SU（SDL Update）Version solved 2 problems above. It create a thread to send SDL  
 * Event every 40ms to tell the main loop to decode and show video frames. 
 *----------------------------------------------------------------------------------
 *shenxj fix
 */  
  
#include <stdio.h>  
  
#define __STDC_CONSTANT_MACROS  
  
#ifdef _WIN32  
//Windows  
extern "C"  
{  
#include "libavcodec/avcodec.h"  
#include "libavformat/avformat.h"  
#include "libswscale/swscale.h"  
#include "libavutil/imgutils.h"  
#include "SDL2/SDL.h"  
};  
#else  
//Linux...  
#ifdef __cplusplus  
extern "C"  
{  
#endif  
#include <libavcodec/avcodec.h>  
#include <libavformat/avformat.h>  
#include <libswscale/swscale.h>  
#include <libavutil/imgutils.h>  
#include <SDL2/SDL.h>  
#ifdef __cplusplus  
};  
#endif  
#endif  
  
//Refresh Event  
#define SFM_REFRESH_EVENT  (SDL_USEREVENT + 1)  
  
#define SFM_BREAK_EVENT  (SDL_USEREVENT + 2)  
  
int thread_exit=0;  
int thread_pause=0;  
  
int sfp_refresh_thread(void *opaque){  
    thread_exit=0;  
    thread_pause=0;  
  
    while (!thread_exit) {  
        if(!thread_pause){  
            SDL_Event event;  
            event.type = SFM_REFRESH_EVENT;  
            SDL_PushEvent(&event);  
        }  
        SDL_Delay(40);  
    }  
    thread_exit=0;  
    thread_pause=0;  
    //Break  
    SDL_Event event;  
    event.type = SFM_BREAK_EVENT;  
    SDL_PushEvent(&event);  
  
    return 0;  
}  

struct __obj_av
{
    AVFormatContext *pFormatCtx;  
    int             videoindex;  
    AVCodecContext  *pCodecCtx;  
    AVCodec         *pCodec;  
    AVFrame         *pFrame;
    AVFrame         *pFrameYUV;
    unsigned char   *out_buffer;  
    AVPacket        *packet;
};
typedef struct __obj_av _obj_av;

struct __obj_sdl
{
    SDL_Window   *screen;   
    SDL_Renderer *sdlRenderer;  
    SDL_Texture  *sdlTexture_1;  
    SDL_Texture  *sdlTexture_2;  
    SDL_Texture  *sdlTexture_3;  
    SDL_Texture  *sdlTexture_4;  
    SDL_Rect     sdlRect_1;  
    SDL_Rect     sdlRect_2;
    SDL_Rect     sdlRect_3;
    SDL_Rect     sdlRect_4;
    SDL_Thread   *video_tid;  
    SDL_Event    event;  
};
typedef struct __obj_sdl _obj_sdl;



static void *obj_av_free(_obj_av *obj_av){
    return NULL;
}
static int obj_av_get_videoindex(_obj_av *obj_av){
    AVFormatContext *pFormatCtx=obj_av->pFormatCtx;
    int i=0,videoindex=-1;
    for(i=0; i<pFormatCtx->nb_streams; i++)   
        if(pFormatCtx->streams[i]->codec->codec_type==AVMEDIA_TYPE_VIDEO){  
            videoindex=i;  
            break;  
        }
    return videoindex;
}

static _obj_av *obj_av_init(const char *filepath){
    _obj_av *obj_av=calloc(1,sizeof(_obj_av));
    av_register_all();  
    avformat_network_init();  
    obj_av->pFormatCtx = avformat_alloc_context();  
    if(avformat_open_input(&obj_av->pFormatCtx,filepath,NULL,NULL)!=0){  
        printf("Couldn't open input stream.\n");  
        goto error;  
    }  
    if(avformat_find_stream_info(obj_av->pFormatCtx,NULL)<0){  
        printf("Couldn't find stream information.\n");  
        goto error;  
    }        
    obj_av->videoindex=obj_av_get_videoindex(obj_av);
    if(obj_av->videoindex==-1){  
        printf("Didn't find a video stream.\n");  
        goto error;  
    }  
    obj_av->pCodecCtx=obj_av->pFormatCtx->streams[obj_av->videoindex]->codec;  
    obj_av->pCodec=avcodec_find_decoder(obj_av->pCodecCtx->codec_id);  
    if(obj_av->pCodec==NULL){  
        printf("Codec not found.\n");  
        goto error;  
    }  
    if(avcodec_open2(obj_av->pCodecCtx, obj_av->pCodec,NULL)<0){  
        printf("Could not open codec.\n");  
        goto error;  
    }  
    obj_av->pFrame=av_frame_alloc();  
    obj_av->pFrameYUV=av_frame_alloc();  
  
    obj_av->out_buffer=(unsigned char *)av_malloc(av_image_get_buffer_size(
        AV_PIX_FMT_YUV420P, obj_av->pCodecCtx->width, obj_av->pCodecCtx->height,1));  
    av_image_fill_arrays(obj_av->pFrameYUV->data, obj_av->pFrameYUV->linesize,obj_av->out_buffer,  
        AV_PIX_FMT_YUV420P,obj_av->pCodecCtx->width, obj_av->pCodecCtx->height,1);  
  
    //Output Info-----------------------------  
    printf("---------------- File Information ---------------\n");  
    av_dump_format(obj_av->pFormatCtx,0,filepath,0);  
    printf("-------------------------------------------------\n");
    return obj_av;
error:
    return NULL;
}

static _obj_sdl *obj_sdl_init(_obj_av *obj_av){
    _obj_sdl *obj_sdl=calloc(1,sizeof(_obj_sdl));;
	int screen_w=0,screen_h=0;
	if(SDL_Init(SDL_INIT_VIDEO | SDL_INIT_AUDIO | SDL_INIT_TIMER)) {    
        printf( "Could not initialize SDL - %s\n", SDL_GetError());   
        goto error;  
    }   
    //SDL 2.0 Support for multiple windows  
    screen_w = obj_av->pCodecCtx->width * 2;  
    screen_h = obj_av->pCodecCtx->height * 2;  
    obj_sdl->screen = SDL_CreateWindow("Simplest ffmpeg player's Window", SDL_WINDOWPOS_UNDEFINED, SDL_WINDOWPOS_UNDEFINED,  
        screen_w, screen_h,SDL_WINDOW_OPENGL);  
  
    if(!obj_sdl->screen) {    
        printf("SDL: could not create window - exiting:%s\n",SDL_GetError());    
        goto error;  
    }  
    obj_sdl->sdlRenderer = SDL_CreateRenderer(obj_sdl->screen, -1, 0);    
    //IYUV: Y + U + V  (3 planes)  
    //YV12: Y + V + U  (3 planes)  
    obj_sdl->sdlTexture_1 = SDL_CreateTexture(obj_sdl->sdlRenderer, SDL_PIXELFORMAT_IYUV, SDL_TEXTUREACCESS_STREAMING,
        obj_av->pCodecCtx->width,obj_av->pCodecCtx->height);    
    obj_sdl->sdlTexture_2 = SDL_CreateTexture(obj_sdl->sdlRenderer, SDL_PIXELFORMAT_IYUV, SDL_TEXTUREACCESS_STREAMING,
        obj_av->pCodecCtx->width,obj_av->pCodecCtx->height);    
	obj_sdl->sdlTexture_3 = SDL_CreateTexture(obj_sdl->sdlRenderer, SDL_PIXELFORMAT_IYUV, SDL_TEXTUREACCESS_STREAMING,
        obj_av->pCodecCtx->width,obj_av->pCodecCtx->height);    
	obj_sdl->sdlTexture_4 = SDL_CreateTexture(obj_sdl->sdlRenderer, SDL_PIXELFORMAT_IYUV, SDL_TEXTUREACCESS_STREAMING,
        obj_av->pCodecCtx->width,obj_av->pCodecCtx->height);    
  
    obj_sdl->sdlRect_1.x=0;  
    obj_sdl->sdlRect_1.y=0;  
    obj_sdl->sdlRect_1.w=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_1.h=obj_av->pCodecCtx->height;  

    obj_sdl->sdlRect_2.x=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_2.y=0;  
    obj_sdl->sdlRect_2.w=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_2.h=obj_av->pCodecCtx->height;

	obj_sdl->sdlRect_3.x=0;  
    obj_sdl->sdlRect_3.y=obj_av->pCodecCtx->height;  
    obj_sdl->sdlRect_3.w=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_3.h=obj_av->pCodecCtx->height;

	obj_sdl->sdlRect_4.x=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_4.y=obj_av->pCodecCtx->height;  
    obj_sdl->sdlRect_4.w=obj_av->pCodecCtx->width;  
    obj_sdl->sdlRect_4.h=obj_av->pCodecCtx->height;
  
    obj_av->packet=(AVPacket *)av_malloc(sizeof(AVPacket));  
  
    obj_sdl->video_tid = SDL_CreateThread(sfp_refresh_thread,NULL,NULL); 
	
    return obj_sdl;
error:
    return NULL;
}

int main(int argc, char* argv[])  
{  
    int decode_ret=0, got_picture=0;  
    _obj_av *obj_av=NULL;
	
    struct SwsContext *img_convert_ctx;    
    //------------SDL---------------- 
	_obj_sdl *obj_sdl=NULL;
	
    char filepath[256]={0};

	if(argc <= 1)
		goto error;
	strcpy(filepath,argv[1]);
	obj_av=obj_av_init(filepath);
	if(obj_av==NULL)
        goto error;
    obj_sdl=obj_sdl_init(obj_av);
	if(obj_sdl==NULL)
		goto error;
    img_convert_ctx = sws_getContext(obj_av->pCodecCtx->width, obj_av->pCodecCtx->height, obj_av->pCodecCtx->pix_fmt,   
        obj_av->pCodecCtx->width, obj_av->pCodecCtx->height, AV_PIX_FMT_YUV420P, SWS_BICUBIC, NULL, NULL, NULL);            
    //------------SDL End------------  
    //Event Loop        
    for (;;) {  
        //Wait  
        SDL_WaitEvent(&obj_sdl->event);  
        if(obj_sdl->event.type==SFM_REFRESH_EVENT){  
            while(1){  
                if(av_read_frame(obj_av->pFormatCtx, obj_av->packet)<0)  
                    thread_exit=1;  
  
                if(obj_av->packet->stream_index==obj_av->videoindex)  
                    break;  
            }  
            decode_ret = avcodec_decode_video2(obj_av->pCodecCtx, obj_av->pFrame, &got_picture, obj_av->packet);  
            if(decode_ret < 0){  
                printf("Decode Error.\n");  
                goto error;  
            }  
            if(got_picture){  
                sws_scale(img_convert_ctx, (const unsigned char* const*)obj_av->pFrame->data, 
					obj_av->pFrame->linesize, 0, obj_av->pCodecCtx->height, obj_av->pFrameYUV->data, obj_av->pFrameYUV->linesize);  
                //SDL---------------------------  
                SDL_UpdateTexture( obj_sdl->sdlTexture_1, NULL, obj_av->pFrameYUV->data[0], obj_av->pFrameYUV->linesize[0] );    
                SDL_UpdateTexture( obj_sdl->sdlTexture_2, NULL, obj_av->pFrameYUV->data[0], obj_av->pFrameYUV->linesize[0] );    
				SDL_UpdateTexture( obj_sdl->sdlTexture_3, NULL, obj_av->pFrameYUV->data[0], obj_av->pFrameYUV->linesize[0] );    
				SDL_UpdateTexture( obj_sdl->sdlTexture_4, NULL, obj_av->pFrameYUV->data[0], obj_av->pFrameYUV->linesize[0] );    
                
                SDL_RenderClear( obj_sdl->sdlRenderer );    
                SDL_RenderCopy( obj_sdl->sdlRenderer, obj_sdl->sdlTexture_1, NULL, &obj_sdl->sdlRect_1 );    
                SDL_RenderCopy( obj_sdl->sdlRenderer, obj_sdl->sdlTexture_2, NULL, &obj_sdl->sdlRect_2 );    
                SDL_RenderCopy( obj_sdl->sdlRenderer, obj_sdl->sdlTexture_3, NULL, &obj_sdl->sdlRect_3 );    
                SDL_RenderCopy( obj_sdl->sdlRenderer, obj_sdl->sdlTexture_4, NULL, &obj_sdl->sdlRect_4 );    
                //SDL_RenderCopy( sdlRenderer, sdlTexture, NULL, NULL);   
                SDL_RenderPresent( obj_sdl->sdlRenderer );    
                //SDL End-----------------------  
            }  
            av_free_packet(obj_av->packet);  
        }
		else if(obj_sdl->event.type==SDL_KEYDOWN){  
            //Pause  
            if(obj_sdl->event.key.keysym.sym==SDLK_SPACE)  
                thread_pause=!thread_pause;  
        }else if(obj_sdl->event.type==SDL_QUIT){  
            thread_exit=1;  
        }else if(obj_sdl->event.type==SFM_BREAK_EVENT){  
            break;  
        }  
  
    }  
  
    sws_freeContext(img_convert_ctx);  
  
    SDL_Quit();  
    //--------------  
    av_frame_free(&obj_av->pFrameYUV);  
    av_frame_free(&obj_av->pFrame);  
    avcodec_close(obj_av->pCodecCtx);  
    avformat_close_input(&obj_av->pFormatCtx);  
  
    return 0;  
error:
	return -1;
}  
