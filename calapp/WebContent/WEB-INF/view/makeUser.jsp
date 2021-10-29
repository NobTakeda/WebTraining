<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*" %>
    <%
    String userid=(String)request.getAttribute("userid");
    String userpass=(String)request.getAttribute("userpass");
    String errorMsg=(String)request.getAttribute("errorMsg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>
<body>
	<p>新規ユーザー登録</p>
	<% if(errorMsg == null){ %>
		<p>こちらの内容でよろしければ登録ボタンを押してください。</p>
	<% }else if(errorMsg=="sameID"){ %>
		<p>このIDは既に使われています。</p>
	<% } %>
	<form action="/calapp/MakeUser" method="post">
		<table>
			<tr><th>ID</th><td><input type="text" value="<%= userid %>" name="userid" required></td></tr>
			<tr><th>パスワード</th><td><input type="text" value="<%= userpass %>" name="userpass" required></td></tr>
		</table>
		<button type="submit">登録</button>
	</form>
</body>
</html>