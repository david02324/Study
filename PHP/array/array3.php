<?php
function get_members(){
	return  ['david','6827','jangdawit'];
}

# before php 5.4
$members = get_members();
echo $members[0].'<br />';

# after php 5.4
echo get_members()[1];
?>