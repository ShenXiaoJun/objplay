objplay_path=~+/
objplay_lib_path=$objplay_path/output/lib
string="export LD_LIBRARY_PATH="'$LD_LIBRARY_PATH'":$objplay_lib_path"
echo $string

objplay_bin_path=$objplay_path/output/bin
string="export PATH="'$PATH'":$objplay_bin_path"
echo $string
