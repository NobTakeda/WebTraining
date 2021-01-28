<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    User user=(User)session.getAttribute("user");
	List<FoodOfDay> fodlist=(List<FoodOfDay>)session.getAttribute("fodlist");
	String date=(String)request.getAttribute("date");
    %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>摂取カロリー表</title>
</head>
<body>
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
<% for(int i=0;i<fodlist.size();i++){ %>
	<div class="date">
		<h3><%= fodlist.get(i).getDate() %>日</h3>
		<div class="graph">
			<div class="breakfast">朝:<%= fodlist.get(i).getBreakfastCal() %></div>
			<div class="lunch">昼:<%= fodlist.get(i).getLunchCal() %></div>
			<div class="supper">晩:<%= fodlist.get(i).getSupperCal() %></div>
			<div class="total">合計:<%= fodlist.get(i).getTotalCal() %>kcal</div>
		</div>
	</div>
</div>
<% } %>
<button type="button" name="date" value="<%= date %>" onclick="location.href='/calorieManage/Manage'">戻る</button>
</body>
<script>
	'use strict'
	const graph=document.getElementsByClassName("graph");
	const graph=document.getElementsByClassName("breakfast");
	const graph=document.getElementsByClassName("lunch");
	const graph=document.getElementsByClassName("supper");
	const graph=document.getElementsByClassName("total");


</script>
</html>