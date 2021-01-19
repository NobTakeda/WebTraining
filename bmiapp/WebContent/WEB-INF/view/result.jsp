<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>健康診断結果</title>
</head>
<body>
<p>身長:${health.height}<br>
<p>体重:${health.weight}<br>
<p>BMI:${health.bmi}<br>
<p>体型:${health.bodyType}<br>
<p>
<a href="/bmiapp/Main">戻る</a>
</p>
</body>
</html>