<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Num num=(Num)request.getAttribute("num");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>変換結果</title>
</head>
<body>
<p><%= num.getInch() %>inchは<%= num.getCm() %>cmです。</p>
<a href="Main">戻る</a>
</body>
</html>