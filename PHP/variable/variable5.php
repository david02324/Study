<?php
$a = 100;
# gettype() -> 변수 형 반환
echo gettype($a);
# settype() -> 변수 형 변환
settype($a,'double');
echo '<br />';
echo gettype($a);
?>