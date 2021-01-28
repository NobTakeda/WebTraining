<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>カロリー管理</title>
</head>
<body>
<h1>カロリー管理アプリへようこそ</h1>
<div>
	<p>必要なデータを入力してください。<br>
	なお、目標体重に応じた摂取カロリーは<a href="https://keisan.casio.jp/exec/system/1183427246">こちら</a>のサイトから計算できます。</p>
	<form action="/calorieManage/Main" method="post">
		名前:<input type="text" name="name" required><br>
		身長(cm):<input type="number" name="heightCm" min="0" step="0.1" required><br>
		体重(kg):<input type="number" name="weightKg" min="0" step="0.1" required><br>
		目標摂取カロリー:<input type="number" name="targetCal" min="0" step="1" required><br>
		<button type="submit">送信</button>
	</form>

</div>
</body>
</html>