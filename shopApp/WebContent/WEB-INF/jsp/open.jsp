<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    ItemShop itemshop=(ItemShop)session.getAttribute("ItemShop");
    %>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="css/main.css">
<link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
<meta charset="UTF-8">
<title>仕入れ</title>
</head>
<body>
	<div id="buying">
		<p>仕入れるアイテムの名前と種類を入力してください<br>
		店の資金:itemshop.getFund() gold</p>
		<form action="/shopApp/OpenShop" method="post">
			<input type="text" name="name">
			武器:500gold<input type="radio" name="type" value="1">
			鎧:1000gold<input type="radio" name="type" value="2">
			薬:200gold<input type="radio" name="type" value="3">
			土産物:100gold<input type="radio" name="type" value="4">
			<input type="hidden" name="count" value="<%= itemshop.getCount()+1 %>">
			<input type="submit" value="決定">
		</form>
	</div>
</body>
</html>