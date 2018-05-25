# objplay
安装各种依赖 <br>
sudo apt-get install autoconf yasm zlib1g-dev libsdl2-dev python-pip python-dev <br>
直接安装tf c库 <br>
```bash
TF_TYPE="cpu" # Change to "gpu" for GPU support
OS="linux" # Change to "darwin" for macOS
TARGET_DIRECTORY="/usr/local"
curl -L \
   "https://storage.googleapis.com/tensorflow/libtensorflow/libtensorflow-${TF_TYPE}-${OS}-x86_64-1.4.0.tar.gz" |
   sudo tar -C $TARGET_DIRECTORY -xz
sudo ldconfig
```

https://storage.googleapis.com/tensorflow/libtensorflow/libtensorflow-cpu-linux-x86_64-1.4.0.tar.gz
sudo tar -C "" -xz
sudo ldconfig


运行 ./build-rely.sh 编译依赖库(ffmpeg,sdl's api) <br>
运行 ./build-play.sh 编译项目代码 <br>
运行 ./export-lib.sh 添加库到环境变量中 <br>
运行 ./output/bin/*  <br>
