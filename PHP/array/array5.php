<?php
$li = ['a','b','c','d'];
function array_show($li){
	var_dump($li);
	echo '<br />';
}
#array_push() -> add to last
array_push($li,'f');
array_show($li);

# array_merge() -> add to last (more than 2 members)
$li = array_merge($li,['f','g']);
array_show($li);

# array_unshift() -> add to first
array_unshift($li,'z');
array_show($li);

# array_splice() -> add to between two indexes
array_splice($li,2,0,'B');
array_show($li);

# array_shift() -> delete first member
array_shift($li);
array_show($li);

# array_pop() -> delete last member
array_pop($li);
array_show($li);

# sort() -> sort array
sort($li);
array_show($li);

# rsort() -> reverse sort()
rsort($li);
array_show($li);
?>