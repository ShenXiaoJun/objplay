
start=$(date +%s)

build_ok=false

objplay_path=~+/
submodules=$objplay_path/submodules
output=$objplay_path/output
work=$objplay_path/work

rm -rf $output
rm -rf $work
mkdir $output &&
mkdir $work &&

#SDL
echo "SDL build---------------------------------------------------------------------" &&
cp -rf $submodules/SDL2-2.0.8 $work/SDL2-2.0.8 &&
cd $work/SDL2-2.0.8 &&
./autogen.sh &&
./configure --prefix=$output --enable-gpl --enable-nonfree &&
make -j &&
make install &&

#ffmpeg
echo "ffmpeg build---------------------------------------------------------------------" &&
cp -rf $submodules/ffmpeg-2.8.14 $work/ffmpeg-2.8.14 &&
cd $work/ffmpeg-2.8.14 &&
./configure --prefix=$output --enable-gpl --enable-nonfree --enable-shared &&
make -j &&
make install &&

build_ok=true
#print use time
end=$(date +%s)
time=$(( $end - $start ))
if $build_ok; then
	echo "OK! $time s"
else
	echo "Fail! $time s"
fi
