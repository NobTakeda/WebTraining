<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="ja">
<head>
  <meta charset="utf-8">
  <meta name="viewport" content="width=device-width, initial-scale=1">
  <title>Donut Menu</title>
  <link rel="stylesheet" href="http://yui.yahooapis.com/3.18.1/build/cssreset/cssreset-min.css">
  <link rel="stylesheet" href="css/main.css"/>
</head>
<body>
  <div id="wrapper">
    <h1>Donut Menu</h1>
    <div id="menu">
    <c:forEach var="d" items="${list }">
      <div>
        <img src="upload/${d.imgname}">
        <p>${d.name}</p>
        <p>${d.price}円</p>
      </div>
    </c:forEach>
    </div>
  </div>
</body>
</html>