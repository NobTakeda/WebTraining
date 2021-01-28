<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    User user=(User)session.getAttribute("user");
    List<Food> list=(List<Food>)request.getAttribute("list");
    String isRegister=(String)request.getAttribute("isRegister");
    String isPush=(String)request.getAttribute("isPush");
    String msg=(String)session.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>あなたの情報</title>
</head>
<body>
<h1>あなたの情報</h1>
<div>
	<table border="1">
		<tr>
			<th>名前</th>
			<th>身長</th>
			<th>体重</th>
			<th>BMI</th>
			<th>目標摂取カロリー</th>
		</tr>
		<tr>
			<td><%= user.getName() %></td>
			<td><%= user.getHeight() %></td>
			<td><%= user.getWeight() %></td>
			<td><%= user.getBmi() %></td>
			<td><%= user.getTargetCal() %></td>
		</tr>
	</table>
</div>
<div>
	<p>食べたメニューを追加する</p>
	<form action="/calorieManage/Manage" method="post">
		名前:<input type="text" name="name" required><br>
		カロリー:<input type="number" name="cal" min="0" step="1" required><br>
		食べた日時:<input type="date" name="date" required><br>
		朝<input type="radio" name="time" value="0">
		昼<input type="radio" name="time" value="1">
		晩<input type="radio" name="time" value="2">
		<button type="submit">登録</button>
	</form>
	<form action="/calorieManage/Manage">
		<input type="date" name="showDate" required><br>
		<button type="submit" name="isPush" value="true">この日食べたものを見る</button>
	</form>
</div>
<% if(msg.length()>0){ %>
	<h2><%= msg %></h2>
<%}else if(list!=null ){ %>
<table id="showFoods" border="1">
	<% int sum=0; %>
	<% for(int i=0;i<list.size();i++){ %>
		<tr>
			<th><%= list.get(i).getDate() %></th>
			<td><%= list.get(i).getTimeStr() %></td>
			<td><%= list.get(i).getName() %></td>
			<td><%= list.get(i).getCal() %></td>
			<td><form action="/calorieManage/Delete">
					<button type="submit" name="id" value="<%= list.get(i).getId() %>" onclick="return confirm('削除してよろしいですか？')">削除</button>
					<input type="hidden" name="date" value="<%= list.get(i).getDate() %>">
				</form></td>
		</tr>
		<% sum+=list.get(i).getCal(); %>
	<% } %>
	<tr><th>合計摂取カロリー</th><td><%= sum %></td></tr>
</table>
<form action="/calorieManage/FodUpdate">
	<button type="submit" name="date" value="<%= list.get(0).getDate() %>">献立を登録する</button><br>
	<% if(isRegister!=null){ %>
		<button type="submit" name="update" value="<%= list.get(0).getDate() %>">献立を更新する</button><br>
	<% } %>
</form>
	<% if(isRegister!=null){ %>
		<form action="/calorieManage/ShowGraph">
			<button type="submit" name="date" value="<?php echo date('Y-m-d');?>">グラフで見る</button><br>
		</form>
	<% } %>
<% } %>
</body>
</html>