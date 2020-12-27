<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>キャラクター作成</title>
</head>
<body>
名前を入力してください
<form action="/selfIntro/SelfIntroServlet" method="post">
<input type="text" name="name" value="">
<input type="submit" value="送信">
</form>
</body>
</html>