<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/bmiapp/Main" method="post">
身長(cm)<input type="number" name="height" step="0.1" required><br>
体重(kg)<input type="number" name="weight" step="0.1" required><br>
<button type="submit">計算</button>
</form>
</body>
</html>