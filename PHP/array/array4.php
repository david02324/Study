<?php
function get_members(){
	return ['david','d6827','jangdawit'];
}

$members = get_members();

# count(array) -> returns the length of the array
# ucfirst(string) -> makes the string's first char to UPPER
for($i = 0; $i <count($members); $i++){
	echo ucfirst($members[$i]).'<br />';
}
?>