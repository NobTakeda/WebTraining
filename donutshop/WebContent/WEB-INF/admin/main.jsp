<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*,model.*"%>
    <%
    List<Donut> list=(List<Donut>)request.getAttribute("list");
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<form action="/donutshop/Admin" method="post" enctype="multipart/form-data">
商品名:<input type="text" name="name" required><br>
価格:<input type="number" name="price" step="10" required><br>
商品画像:<input type="file" name="imgname"><br>
<button type="submit">登録</button>
</form>

<% if(list != null && list.size()>0){ %>
<table border="1">
<%for(Donut d:list){ %>
<tr>
<td><img src="upload/<%=d.getImgname() %>"></td>
<td><%=d.getId() %></td>
<td><%=d.getName() %></td>
<td><%=d.getPrice() %></td>
</tr>
<%} %>
</table>
<%} %>
</body>
</html>