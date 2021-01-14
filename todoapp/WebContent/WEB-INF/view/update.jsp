<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Todo todo=(Todo)request.getAttribute("todo");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>TodoApp</title>
</head>
<body>
<form action="/todoapp/Update" method="post">
Title:<input type="text" name="title" value="<%= todo.getTitle() %>"><br>
重要度:<!-- <input type="number" name="importance" value="<%= todo.getImportance() %>"><br> -->
<select name="importance">
	<% for(int i=1;i<=5;i++){ %>
	<option value="<%= i %>" <%= todo.getImportance()==i? " selected":"" %>><%= i %></option>
	<% } %>
</select>
<input type="hidden" name="id" value="<%= todo.getId() %>"><br>
<button type="submit">登録</button>
</form>
</body>
</html>