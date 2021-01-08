<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    List<Product> list=(List<Product>)session.getAttribute("list");
    String err=(String)request.getAttribute("err");
    String msg=(String)request.getAttribute("msg");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8"/>
<meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">
<!-- Bootstrap CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css" integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M" crossorigin="anonymous">
<title>Joytas7(Applicationスコープ)</title>
</head>
<body>
<div class="container" style="margin-top:20px;">
<p>商品を入れてください</p>
<% if(err !=null){%>
<div class="alert alert-danger" role="alert">
<%= err %>
</div>
<% } %>
<% if(msg !=null){%>
<div class="alert alert-success" role="alert">
<%= msg %>
</div>
<% } %>
<form action="/vegecart/Main" method="post">
商品名:<br>
<input type="text" name="name" class="form-control" style="width:200px;"><br>
価格:<br>
<input type="number" name="price" step="1" min="0" class="form-control" style="width:200px;"><br>
<button type="submit" name="accept" value="" class="btn btn-primary">カートに追加</button>
</form>
<% if(list != null) {%>
<p>合計:<%= list.get(0).getSum() %></p>
<table class="table table-striped mt-4">
	<tr>
		<td>商品名</td><td>価格</td>
	</tr>
	<% for(Product n:list){ %>
		<tr>
		<td><%= n.getName() %></td><td><%= n.getPrice() %></td>
		</tr>
	<% } %>
<% } %>
</table>
</div>
</body>
</html>