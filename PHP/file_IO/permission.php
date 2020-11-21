<?php
$filename = 'example.txt';
# check if the file is readable
if (is_readable($filename)) {
    echo 'The file is readable';
} else {
    echo 'The file is not readable';
}

echo '<br />';
$filename = 'example.txt';
# check if the file is writable
if (is_writable($filename)) {
    echo 'The file is writable';
} else {
    echo 'The file is not writable';
}

echo '<br />';
$filename = 'example.txt';
# check if there is suck file
if (file_exists($filename)) {
    echo "The file $filename exists";
} else {
    echo "The file $filename is not exists";
}
?>