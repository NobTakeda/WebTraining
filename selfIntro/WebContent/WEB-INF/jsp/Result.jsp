<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Hero" import="java.util.*" %>
	<%
 	Hero h1=(Hero)request.getAttribute("hero1");
    String[] result=h1.getResult();
	%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>自己紹介</title>
</head>
<body>
<p><%= h1.getRace() %>のボーナスが適用されました</p><br>
<%= Arrays.toString(h1.getShowParams()) %><br>
<p>****作成成功！****</p>
<p>私は<%= h1.getRace() %>の<%= h1.getJob() %>、<%= h1.getName() %>です。</p><br>
<p>能力値(<%= h1.getSumParam() %>)を高い順に並べると、</p><br>
<% for(int i=0;i<result.length;i++){ %>
	<%= result[i]  %><br>
<%} %>
<p>です。今後ともよろしく...</p>
</body>
</html>