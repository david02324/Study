<?php
# associative array, hash, dictionary.. in PHP
$grades = array('david'=>123,'jang'=>6827,'kim'=>80);

# or

$grade = [];
$grade['egoing'] = 10;
$grade['k8805'] = 6;
$grade['sorialgi'] = 80;

var_dump($grades);
echo '<br />'.$grades['david'].'<br />';

foreach($grades as $key => $value){
	echo "Key : {$key} value : {$value}<br />";
}

?>