<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="GetRanking" method="post">
		件数:<input type="number" name="count" value="10"><br>
		名前:<input type="text" name="name"><br>
		score:<input type="number" name="score"><br>
		性別:<input type="radio" name="sex" value="0">男
		<input type="radio" name="sex" value="1">女<br>
		<button type="submit">送信</button>
	</form>
</body>
</html>