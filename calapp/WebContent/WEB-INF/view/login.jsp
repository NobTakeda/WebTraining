<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
    <%
    	String registerMassage=(String)request.getAttribute("result");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カロリー管理アプリログイン画面</title>
</head>
<body>
<div id="maincontaner">
	<h1>ログイン画面</h1>
	<form action="/calapp/Login" method="post">
		<% if(registerMassage == null){ %>
			<p>ID,パスワードは半角英数字を入力してください</p>
		<% }else if(registerMassage.equals("noUser")){ %>
			<p>ユーザー登録がされていません。<br>
			   ID,パスワードを入力して登録ボタンを押してください</p>
		<% }else if(registerMassage.equals("diffPass")){ %>
			<p>パスワードが違います</p>
		<% }else if(registerMassage.equals("noOneByte")){ %>
			<p>ID,パスワードは共に半角で入力してください</p>
		<% } %>
		<table class="userdata">
			<tr><th>ID</th><td><input type="text" name="userid" required><td></tr>
			<tr><th>パスワード</th><td><input type="password" name="userpass" required><td></tr>
		</table>
		<button type="submit">送信</button>
		<button type="submit" name="registerButton" value="1">登録</button>
	</form>
</div>

</body>
</html>