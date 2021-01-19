<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理画面</title>
<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
<link rel="stylesheet" href="/donutshop/css/admin/css">
</head>
<body>
<div class="container"><!-- start container -->
<a href="/donutshop/Main" class="btn btn-outline-info btn-sm float-right">公開ページを見る</a>
<c:if test="${not empty msg}">
<div class="alert alert-success" role="alert">
${msg }
</div>
</c:if>
<form class="mt-3" action="/donutshop/Admin" method="post" enctype="multipart/form-data">
<div class="form-group">
<label for="name">商品名</label>
<input type="text" name="name" id="name" class="form-control" required><br>
</div>
<div class="form-group">
<label for="price">価格</label>
<input type="number" name="price" id="price" class="form-control" step="10" required><br>
</div>
<div class="form-group">
<label for="imagname">商品画像</label>
<input type="file" name="imgname" class="form-control"><br>
</div>
<button type="submit" class="btn btn-primary">登録</button>
</form>
<c:if test="${not empty list }">
<table class="table table-bordered">
<c:forEach var="d" items="${list }">
<tr>
<td><img src="/donutshop/upload/${d.imgname}"></td>
<td>${d.id}</td>
<td>${d.name}</td>
<td>${d.price}</td>
<td>
<a href="/donutshop/Admin/Update?id=${d.id}">更新</a><br>
</td>
<td>
<a href="/donutshop/Admin/Delete?id=%${d.id}>" onclick="return confirm('削除してよろしいですか？');">削除</a><br>
</td>
</tr>
</c:forEach>
</table>
</c:if>
</div><!-- end container -->
</body>
</html>