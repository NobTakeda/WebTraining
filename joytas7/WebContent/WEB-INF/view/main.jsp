<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
<%
List<Product> list=(List<Product>)application.getAttribute("list");
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
<p>商品を登録してください。</p>
<% if(err !=null){%>
<div class="alert alert-danger" role="alert">
<%=err %>
</div>
<%} %>
<% if(msg !=null){%>
<div class="alert alert-success" role="alert">
<%=msg %>
</div>
<%} %>
<form action="/joytas7/main" method="post" >
  <div class="form-group">
    <label for="name">製品名:</label>
    <input type="text" id="name" name="name" class="form-control" style="width:200px;">
  </div>
  <div class="form-group">
    <label for="price">価格:</label>
    <input type="number" id="price" name="price" class="form-control" style="width:200px;">
  </div>
  <button type="submit" class="btn btn-primary">登録</button>
</form>
<%if(list.size()>0){%>
<table class="table table-striped mt-4">
<tr><th>製品名</th><th>価格</th><th>登録日</th></tr>
<%for(Product p:list) {%>
<tr><th><%=p.getName() %></th><td><%=String.format("%,3d円",Integer.parseInt(p.getPrice())) %></td><td><%=p.getUpdated() %></td></tr>
<%} %>
</table>
<%} %>
</div>
<script>
var forms=document.getElementsByClassName("form-control");
var alerts=document.getElementsByClassName("alert");
for(var i=0;i<forms.length;i++){
	forms[i].addEventListener("focus",function(){
		for(var j=0;j<alerts.length;j++){
			alerts[j].style.display="none";
		}
	});
}
</script>
</body>
</html>