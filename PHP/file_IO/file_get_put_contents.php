<?php
# save data of 'example.txt' in $file
$file = './example.txt';
echo file_get_contents($file);

# also can use this function to URL
$homepage = file_get_contents('http://www.php.net/manual/en/manual.php');
echo $homepage;

# save 'function worked' to $file
file_put_contents($file,'function worked!');
?>