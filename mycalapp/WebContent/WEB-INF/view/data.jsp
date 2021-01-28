<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    //List<Health> list=(List<Health>)session.getAttribute("userData");
    Health health=(Health)session.getAttribute("loginUser");
    String gender=health.getGender()==1? "男性":"女性";
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title><%= health.getName() %>さんのデータ</title>
</head>
<body>
<% if(health.getTargetCal()== 0){ %>
	<p>あなたのBMIは<%= health.getBmi() %>,標準消費カロリーは<%= health.getCal() %>kcalです。<br>
	目標消費カロリーはいくつに設定しますか？</p>
	<form action="/mycalapp/Main" method="post">
	<input type="number" name="targetCal" min="0" step="1" required>
	<button type="submit">送信</button>
	</form>

<% }else{ %>
	<table id="data" border="1">
		<tr>
			<th>名前</th>
			<th>性別</th>
			<th>身長</th>
			<th>体重</th>
			<th>BMI</th>
			<th>標準消費cal</th>
			<th>目標摂取cal</th>
		</tr>
		<tr>
			<td><%= health.getName() %></td>
			<td><%= gender %></td>
			<td><%= health.getHeight() %></td>
			<td><%= health.getWeight() %></td>
			<td><%= health.getBmi() %></td>
			<td><%= health.getCal() %></td>
			<td><%= health.getTargetCal() %></td>
		</tr>
	</table>
	<button onclick="location.href='/mycalapp/Update'" name="id" value="health.getId()">更新</button>
	<div>
		<table>

		</table>
	</div>
	<form action="/mycalapp/Logout">
		<button type="submit">ログアウト</button>
	</form>
<% } %>
</body>
</html>