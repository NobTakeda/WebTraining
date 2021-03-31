<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    User user=(User)session.getAttribute("user");
	List<FoodOfDay> fodlist=(List<FoodOfDay>)request.getAttribute("fodlist");
	String date=(String)session.getAttribute("date");
    %>
<!DOCTYPE html>
<html>

<head>
<meta charset="UTF-8">
<title>摂取カロリー表</title>
<link rel="stylesheet" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="css/graph.css"/>
</head>
<body>
<div id="userBox">
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
<div id="graph" >
<% for(int i=0;i<fodlist.size();i++){ %>
	<div class="date" >
		<h3><%= fodlist.get(i).getDate() %>日</h3>
		<% for(int j=0;j<4;j++){ %>
			<% if(j==0){ %>
				<div class="breakfast" style="width:<%= (fodlist.get(i).getBreakfastCal()/user.getTargetCal())*10 %>mm">朝:<%= fodlist.get(i).getBreakfastCal() %></div>
			<% }else if(j==1){ %>
				<div class="lunch" style="width:<%= fodlist.get(i).getLunchCal()/user.getTargetCal()*10 %>mm">昼:<%= fodlist.get(i).getLunchCal() %></div>
			<% }else if(j==2){ %>
				<div class="supper" style="width:<%= fodlist.get(i).getSupperCal()/user.getTargetCal()*10 %>mm">晩:<%= fodlist.get(i).getSupperCal() %></div>
			<% }else{ %>
				<div class="total">合計:<%= fodlist.get(i).getTotalCal() %>kcal</div>
			<% } %>
		<% } %>
	</div>
<% } %>
</div>
<button type="button" name="date" value="<%= fodlist.get(0).getDate() %>" onclick="location.href='/calorieManage/Manage'">戻る</button>
</body>
<script>
/*
'use strict'
const targetCal=user.getTargetCal();
const graph=document.getElementById("graph");
let graphStr="";
for(let j=0;j<7;j++){
	const div=document.createElement('div');
	div.classList.add('');
	for(let i=0;i<4;i++){
		const p=document.createElement('p');
		switch(i){
		//朝グリーン、昼オレンジ、夜ブルー
		case 0:
			p.textcontent=fodlist.get(j).getBreakfastCal();
			p.classList.add('breakfast');
			p.style.width=getWidth(fodlist.get(j).getBreakfastCal());
			p.style.height='20px';
			p.style.color='#fffacd';
			p.style.backgroundColor='green';
			break;
		case 1:
			p.textcontent=fodlist.get(j).getLuchCal();
			p.classList.add('lunch');
			p.style.width=getWidth(fodlist.get(j).getLunchCal());
			p.style.height='20px';
			p.style.color='#333';
			p.style.backgroundColor='orange';
			break;
		case 2:
			p.textcontent=fodlist.get(j).getSupperCal();
			p.classList.add('supper');
			p.style.width=getWidth(fodlist.get(j).getSupperCal());
			p.style.height='20px';
			p.style.color='#fffacd';
			p.style.backgroundColor='blue';
			break;
		case 3:
			p.textcontent=fodlist.get(j).getTotalCal();
			p.classList.add('total');
			p.style.width=getWidth(fodlist.get(j).getTotalCal());
			p.style.height='20px';
			p.style.color='#f5f5f5';
			p.style.backgroundColor='#696969';
			break;
		}
		p.appendChild(div);
	}
}
function getWidth(cal){
	let width=cal/targetCal*100;
	width=width+'vw';
	return width;

}
*/
</script>
</html>