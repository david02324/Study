<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8"/>
</head>   
<body>
<?php
ini_set("display_errors", "1");
$uploaddir = 'C:\Bitnami\wampstack-7.4.12-0\apache2\htdocs\file_IO\upload\\';
$uploadfile = $uploaddir . basename($_FILES['userfile']['name']);
echo '<pre>';
if (move_uploaded_file($_FILES['userfile']['tmp_name'], $uploadfile)) {
    echo "������ ��ȿ�ϰ�, ���������� ���ε� �Ǿ����ϴ�.\n";
} else {
    print "���� ���ε� ������ ���ɼ��� �ֽ��ϴ�!\n";
}
echo '�ڼ��� ����� �����Դϴ�:';
print_r($_FILES);
print "</pre>";
?>
</body>
</html>