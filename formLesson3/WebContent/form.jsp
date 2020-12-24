<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>チェックボックス練習</title>
</head>
<body>
<form action="/formLesson3/Result" method="post">
os:<br>
Win:<input type="checkbox" name="os" value="Win">
Mac:<input type="checkbox" name="os" value="Mac">
Linux:<input type="checkbox" name="os" value="Linux">
<input type="submit" value="送信">
</form>
</body>
</html>