<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.Statistics,java.util.*"%>
<%
	Statistics stat=(Statistics)application.getAttribute("stat");
	Map<Integer,Integer> map=stat.getMap();
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>結果</p>
<table border="1">
<%for(int i=1;i<=stat.getMaxThrowCount();i++){ %>
	<tr>
	<td><%=i %></td><td><%=i*stat.getFee() %></td>
	<td>
	<%if(map.containsKey(i)){ %>
		<%for(int j=0;j<map.get(i);j++){ %>
		*
		<%} %>
	<%} %>
	</td>
	</tr>
<%} %>
</table>
<p>試行回数:<%=stat.getTotalCount() %>回</p>
<p>コンプ平均値:<%=stat.getAve() %>円</p>
<p>モード（最頻値):<%=stat.getMode() %>回(<%=stat.getMode()*stat.getFee() %>)</p>
</body>
</html>