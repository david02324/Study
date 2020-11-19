<?php
if($_POST['id'] == 'david02324'){
    if($_POST['password'] == '123456'){
        echo 'right';
    } else {
        echo 'password wrong';
    }   
} else {
    echo 'id wrong';
}
?>