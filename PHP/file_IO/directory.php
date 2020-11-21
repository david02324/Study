<?php
# getcwd() -> return current directory
echo getcwd().'<br />';
# chdir() -> change current directory
chdir('../');
echo getcwd().'<br />';

$dir    = './';
# scandir() -> scan target directory
$files1 = scandir($dir);
# 1 means -> rsort()
$files2 = scandir($dir, 1);
 
print_r($files1);
echo '<br />';
print_r($files2);
?>