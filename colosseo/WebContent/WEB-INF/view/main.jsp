<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Gladiator gladiator=(Gladiator)request.getAttribute("gladiator");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">
<link rel="stylesheet" href="/colosseo/css/main.css">
<title>闘技場</title>
</head>
<body>
	<div id="container">
		<div class="intro">
			<h1>剣闘士を作って闘おう！</h1>
			<p class="setumei">作成ボタンを押すと、剣闘士が出てくるぞ！<br>
			気に入った剣闘士が出てきたら闘技場へ入場しよう！</p>
			<% if(gladiator !=null){ %>
				<table class="table table-hover table-dark">
					<tr>
						<th>名前</th><th>体力</th><th>ちから</th><th>すばやさ</th>
					</tr>
					<tr>
						<td><%= gladiator.getName() %></td>
						<td><%= gladiator.getHp() %></td>
						<td><%= gladiator.getPow() %></td>
						<td><%= gladiator.getSpeed() %></td>
					</tr>
				</table>
			<% } %>
		</div>
		<div class="register">
			<form action="/colosseo/Main" method="post">
				あなたの剣闘士名:<input type="text" name="name"
				<% if(gladiator !=null){ %>
					value="<%= gladiator.getName() %>"
				<% } %>
				><br>
				<button type="submit" class="btn btn-primary">作成</button>
			</form>
			<div class="enter">
				<form action="/colosseo/Fight">
					<button type="submit" name="enter" value="1" class="btn btn-success">入場</button>
					<% if(gladiator !=null){ %>
					<input type="hidden" name="name" value="<%= gladiator.getName() %>">
					<input type="hidden" name="hp" value="<%= gladiator.getHp() %>">
					<input type="hidden" name="pow" value="<%= gladiator.getPow() %>">
					<input type="hidden" name="speed" value="<%= gladiator.getSpeed() %>">
					<% } %>
				</form>
			</div>
		</div>
	</div>
<script src="https://code.jquery.com/jquery-3.5.1.slim.min.js" integrity="sha384-DfXdz2htPH0lsSSs5nCTpuj/zy4C+OGpamoFVy38MVBnE+IbbVYUew+OrCXaRkfj" crossorigin="anonymous"></script>
<script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js" integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
<script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/js/bootstrap.min.js" integrity="sha384-OgVRvuATP1z7JjHLkuOU7Xw704+h835Lr+6QL9UvYjZE3Ipu6Tp75j7Bh/kR0JKI" crossorigin="anonymous"></script>
</body>
</html>