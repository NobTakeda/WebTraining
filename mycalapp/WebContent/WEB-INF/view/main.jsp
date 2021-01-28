<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Health health=(Health)session.getAttribute("loginUser");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カロリー管理</title>
</head>
<body>
<% if(health!=null){ %>
<p>あなたの情報を登録してください</p>
<form action="/mycalapp/Main" method="get">
	身長(cm):<input type="number" name="heightCm" min="0" step="0.1" required><br>
	体重(kg):<input type="number" name="weightKg" min="0" step="0.1" required><br>
	性別:男性<input type="radio" name="gender" value="1">
		女性<input type="radio" name="gender" value="2"><br>
	<button type="submit">OK</button>
</form>
<% }else{ %>
<p>ログインしてください</p>
<a href="/mycalapp/Entry">戻る</a>
<% } %>
</body>
</html>