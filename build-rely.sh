
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
echo "---------------------------------------------------------------------------------" &&
echo "SDL build" &&
echo "---------------------------------------------------------------------------------" &&
cp -rf $submodules/SDL2-2.0.8 $work/SDL2-2.0.8 &&
cd $work/SDL2-2.0.8 &&
./autogen.sh &&
./configure --prefix=$output --enable-gpl --enable-nonfree &&
make -j &&
make install &&

#ffmpeg
echo "---------------------------------------------------------------------------------" &&
echo "ffmpeg build" &&
echo "---------------------------------------------------------------------------------" &&
cp -rf $submodules/ffmpeg-2.8.14 $work/ffmpeg-2.8.14 &&
cd $work/ffmpeg-2.8.14 &&
./configure --prefix=$output --enable-gpl --enable-nonfree --enable-shared &&
make -j &&
make install &&

#bazel
#'''
echo "---------------------------------------------------------------------------------" &&
echo "bazel build" &&
echo "---------------------------------------------------------------------------------" &&
#cp -rf $submodules/bazel-0.5.4-dist $work/bazel-0.5.4-dist &&
mkdir $work/bazel-0.5.4-dist && 
cp $submodules/bazel-0.5.4-dist.zip $work/bazel-0.5.4-dist &&
cd $work/bazel-0.5.4-dist &&
unzip bazel-0.5.4-dist.zip &&
./compile.sh &&
sudo cp ./output/bazel /usr/local/bin/ &&
#'''

#tensorflow
#'''
echo "---------------------------------------------------------------------------------" &&
echo "tensorflow build" &&
echo "---------------------------------------------------------------------------------" &&
cp -rf $submodules/tensorflow-r1.4 $work/tensorflow-r1.4 &&
cd $work/tensorflow-r1.4 &&
./configure &&
bazel build -c opt //tensorflow/tools/pip_package:build_pip_package &&
bazel-bin/tensorflow/tools/pip_package/build_pip_package $output/tensorflow_pkg &&
sudo pip install $output/tensorflow_pkg/tensorflow-* &&
#'''


build_ok=true
#print use time
end=$(date +%s)
time=$(( $end - $start ))
if $build_ok; then
	echo "OK! $time s"
else
	echo "Fail! $time s"
fi
