<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%
    List<String> lines=(List<String>)request.getAttribute("lines");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Joytas10</title>
</head>
<body>
<a href="/joytas10/FileWrite">書く</a>
<% if(lines != null && lines.size() > 0){ %>
	<ul>
	<% for(String line:lines){ %>
		<li><%= line %></li>
	<% }  %>
	</ul>
<% } %>
</body>
</html>