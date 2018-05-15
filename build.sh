output=/home/shenxj/Documents/ffmpeg-3.2.4/output
gcc simplest_ffmpeg_player.c -I$output/include -L$output/lib -Wno-error -fPIC -o player.x86
