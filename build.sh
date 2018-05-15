output=/home/shenxj/Documents/output
gcc simplest_ffmpeg_player.c -I$output/include -L$output/lib -lSDL2 -Wno-error -fPIC -o player.x86
