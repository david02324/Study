<?php
$a = 100;
# gettype() -> ���� �� ��ȯ
echo gettype($a);
# settype() -> ���� �� ��ȯ
settype($a,'double');
echo '<br />';
echo gettype($a);
?>