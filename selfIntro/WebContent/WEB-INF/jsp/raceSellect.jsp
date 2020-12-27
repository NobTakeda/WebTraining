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
<title>種族選択</title>
</head>
<body>
<form action="/selfIntro/RaceServlet" method="post">
<input type="hidden" name="hp" value="<%=params[0]%>">
<input type="hidden" name="mp" value="<%=params[1]%>">
<input type="hidden" name="str" value="<%=params[2]%>">
<input type="hidden" name="dex" value="<%=params[3]%>">
<input type="hidden" name="agi" value="<%=params[4]%>">
<input type="hidden" name="name" value="<%= h1.getName() %>">
<p><%= h1.getName() %>の初期ステータスが決定しました</p><br>
<%= Arrays.toString(h1.getShowParams()) %>
<p>種族を選んでください</p>
<input type="radio" name="race" value="0">人間<br>
<input type="radio" name="race" value="1">ハイエルフ<br>
<input type="radio" name="race" value="2">トロル<br>
<input type="radio" name="race" value="3">ノーム<br>
<input type="submit" value="送信">
</form>
</body>
</html>