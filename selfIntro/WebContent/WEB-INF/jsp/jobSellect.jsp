<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Hero" import="java.util.*"%>
	<%
 	Hero h1=(Hero)request.getAttribute("hero1");
    int[] params=h1.getParams();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>職業選択</title>
</head>
<body>
<form action="/selfIntro/JobServlet" method="post">
<input type="hidden" name="hp" value="<%=params[0]%>">
<input type="hidden" name="mp" value="<%=params[1]%>">
<input type="hidden" name="str" value="<%=params[2]%>">
<input type="hidden" name="dex" value="<%=params[3]%>">
<input type="hidden" name="agi" value="<%=params[4]%>">
<input type="hidden" name="name" value="<%= h1.getName() %>">
<input type="hidden" name="race" value="<%= h1.getRace() %>">
<p><%= h1.getName() %>に<%= h1.getRace() %>のボーナスが適用されました</p><br>
<%= Arrays.toString(h1.getShowParams()) %>
<p>職業を選んでください</p>
<input type="radio" name="job" value="0">戦士<br>
<input type="radio" name="job" value="1">盗賊<br>
<input type="radio" name="job" value="2">僧侶<br>
<input type="radio" name="job" value="3">魔術師<br>
<input type="submit" value="送信">
</form>
</body>
</html>