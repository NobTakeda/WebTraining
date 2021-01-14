<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Gladiator player=(Gladiator)session.getAttribute("player");
    Gladiator enemy=(Gladiator)session.getAttribute("enemy");
	GladiatorLogic gl=(GladiatorLogic)session.getAttribute("gl");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/colosseo/css/fight.css">
<title>闘技場</title>
</head>
<body>
<div id="container">
	<div class="player">
		<table>
		<tr><th><%= player.getName() %></th></tr>
		<tr><td>体力</td><td><%= player.getHp() %></td></tr>
		<tr><td>ちから</td><td><%= player.getPow() %></td></tr>
		<tr><td>すばやさ</td><td><%= player.getSpeed() %></td></tr>
		</table>
	</div>
	<div class="log">
		<% if(gl==null){ %>
			<p><%= enemy.getName() %><br>対<br><%= player.getName() %><br></p>
		<% }else{ %>
			<% for(int i=0;i<4;i++){ %>
				<p class="slowly"><%= gl.getMsgs().get(i) %><br></p>
			<% } %>
		<% } %>
	</div>
	<div class="enemy">
		<table>
		<tr><th><%= enemy.getName() %></th></tr>
		<tr><td>体力</td><td><%= enemy.getHp() %></td></tr>
		<tr><td>ちから</td><td><%= enemy.getPow() %></td></tr>
		<tr><td>すばやさ</td><td><%= enemy.getSpeed() %></td></tr>
		</table>
	</div>
</div>
<div class="command">
	<% if(gl==null){ %>
		<p>どうする！？</p>
		<form action="/colosseo/Fight" method="post">
			攻撃:<input type="radio" name="action" value="1">
			弾く:<input type="radio" name="action" value="2">
			かわす:<input type="radio" name="action" value="3">
			<br>
			<button type="submit">決定</button>
		</form>
	<% }else if(gl.getMsgs().get(3).contains("Cong") || gl.getMsgs().get(3).contains("Over")){ %>
		<p>ゲーム終了</p>
		<a href="/colosseo/Main">戻る</a>
		<% session.invalidate(); %>
	<% }else if(player.getHp()==0 || enemy.getHp()==0){ %>
		<form action="/colosseo/Fight" method="post">
			<button type="submit" class="btn btn-primary">決着！</button>
		</form>
	<% }else{ %>
		<p>どうする！？</p>
		<form action="/colosseo/Fight" method="post">
			攻撃:<input type="radio" name="action" value="1">
			弾く:<input type="radio" name="action" value="2">
			かわす:<input type="radio" name="action" value="3">
			<br>
			<button type="submit" class="btn btn-success">決定</button>
		</form>
	<% } %>
</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>