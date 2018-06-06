objplay_path=~+/
submodules=$objplay_path/submodules
output=$objplay_path/output
obj_play=$submodules/obj_play

ffpemglibs="$output/lib/libavcodec.so \
$output/lib/libavdevice.so \
$output/lib/libavfilter.so \
$output/lib/libavformat.so \
$output/lib/libavutil.so \
$output/lib/libpostproc.so \
$output/lib/libswresample.so \
$output/lib/libswscale.so"

tflibs="$output/lib/libtensorflow_framework.so \
$output/lib/libtensorflow.so"

start=$(date +%s)
build_ok=false

gcc $obj_play/obj_play.c $ffpemglibs -I$output/include -L$output/lib -lSDL2 -lm -lpthread -lz -Wno-error -o $output/bin/player.x86 &&
#gcc $obj_play/obj_tf.c -ltensorflow -o $output/bin/obj_tf.x86 &&
gcc $obj_play/obj_tf.c $tflibs -I$output/include -L$output/lib $tflibs -o $output/bin/obj_tf.x86 &&

build_ok=true

end=$(date +%s)
time=$(( $end - $start ))
if $build_ok; then
	echo "OK! $time s"
else
	echo "Fail! $time s"
fi
