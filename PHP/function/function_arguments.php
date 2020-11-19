<?php
function get_argument($arg){
    return $arg;
}

function add_arguments($arg1,$arg2){
	return $arg1 + $arg2;
}
 
print get_argument(1);
print get_argument(2);

print '<br />'.add_arguments(get_argument(1),get_argument(2));
 
?>