objplay_path=~+/
submodules=$objplay_path/submodules
output=$objplay_path/output

ffpemglibs="$output/lib/libavcodec.so \
$output/lib/libavdevice.so \
$output/lib/libavfilter.so \
$output/lib/libavformat.so \
$output/lib/libavutil.so \
$output/lib/libpostproc.so \
$output/lib/libswresample.so \
$output/lib/libswscale.so"

gcc simplest_ffmpeg_player.c $ffpemglibs -I$output/include -L$output/lib -lSDL -lm -lpthread -lz -Wno-error -o $output/bin/player.x86
#gcc simplest_ffmpeg_player.c -lSDL -lm -lpthread -lz -Wno-error -o $output/bin/player.x86
