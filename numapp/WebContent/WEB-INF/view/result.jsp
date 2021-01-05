<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*"%>
    <%
    Numbers numbers=(Numbers)request.getAttribute("numbers");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>結果発表</title>
</head>
<body>
	<p>元の文字列:<%= numbers.getStr() %></p>
	<p>要素数:<%= numbers.getNumsList().size() %></p>
	<p>最大値:<%= numbers.getMax() %></p>
	<p>最小値:<%= numbers.getMin() %></p>
	<p>合計:<%= numbers.getSum() %></p>
		<a href="/numapp/Main?numA=1">戻る</a>
</body>
</html>