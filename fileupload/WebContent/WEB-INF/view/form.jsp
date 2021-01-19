<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>アップロードテスト</title>
</head>
<body>
<form action="/fileupload/Main" method="post" enctype="multipart/form-data">
<!-- 画像を送る時、送信方法は必ずpost,enctype設定する,画像のinputtypeはfile -->
名前:<input type="text" name="name"><br>
好きな言葉:<input type="text" name="word"><br>
好きな写真:<input type="file" name="pict"><br>
<button type="submit">送信</button>
</form>
</body>
</html>