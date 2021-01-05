<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Person person=(Person)session.getAttribute("person");
    String name=person==null? "":person.getName();
    String email=person==null? "":person.getEmail();
    String memo=person==null? "":person.getMemo();
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="/joytas6/css/main.css">
<title>Joytas6(Session)</title>
</head>
<body>
<h1>お問い合わせフォーム</h1>
<form action="/joytas6/contact" method="post">
	<table>
		<tr><th>お名前</th><td><input type="text" name="name" value="<%= name %>"></td></tr>
		<tr><th>メールアドレス</th><td><input type="email" name="email" value="<%= email %>"></td></tr>
		<tr><th>お問い合わせ内容</th><td><textarea name="memo"><%= memo %></textarea> </td></tr>
	</table>
	<input type="submit" value="確認" class="button">
</form>
</body>
</html>