<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%
    String userid=(String)request.getAttribute("userid");
    String userpass=(String)request.getAttribute("userpass");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>新規ユーザー登録</title>
</head>
<body>
	<p>新規ユーザー登録</p>
	<form action="/calapp/MakeUser" method="post">
		<table>
			<tr><th>ID</th><td><input type="text" value="<%= userid %>" name="userid" required></td></tr>
			<tr><th>パスワード</th><td><input type="text" value="<%= userpass %>" name="userpass" required></td></tr>
		</table>
		<button type="submit">登録</button>
	</form>
</body>
</html>