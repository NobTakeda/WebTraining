<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    	Dice dice=(Dice)session.getAttribute("dice");
        int[] states=dice.getDiceStates();
        Statistics stats=(Statistics)application.getAttribute("stats");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>DiceCompGame</title>
	<link rel="stylesheet" href="css/main.css"/>
	<link rel="preconnect" href="https://fonts.gstatic.com">
	<link href="https://fonts.googleapis.com/css2?family=Audiowide&display=swap" rel="stylesheet">
</head>
<body>
	<div id="dices">
	<% for(int i=0;i<states.length;i++){ %>
		<% if(states[i]<=1){ %>
			<img src="images/dice<%= i+1 %>.png" class="<%= states[i]==1?"diceOut":"" %>">
		<% } %>
	<% } %>
	</div>
	<div id="dice">
	<% if(dice.getNowDice() !=0){ %>
		<img src="images/dice<%= dice.getNowDice() %>.png" class="diceIn">
	<% } %>
	</div>
	<form action="/DiceComp/Main">
		<button type="submit">Dice!<span class="result"><%= dice.getMsg() %></span></button>
	</form>
</body>
</html>