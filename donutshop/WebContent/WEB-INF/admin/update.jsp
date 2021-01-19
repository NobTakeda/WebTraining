<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/donutshop/css/main.css">
</head>
<body>
<div class="container">
<form action="/donutshop/Admin/Update" method="Post" enctype="multipart/form-data">
商品名:<input type="text" name="name" value="${donut.name}" required><br>
価格:<input type="number" name="price" step="10" value="${donut.price}" required><br>
<img src="/donutshop/upload/${donut.imgname}"><br>
<input type="file" name="imgname"><br>
<input type="hidden" name="id" value="${donut.id}">
<input type="hidden" name="orgname" value="${donut.imgname}">
<button type="submit">更新</button>
</form>
</div>
</body>
</html>