<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
    <%
    String[] oss=request.getParameterValues("os");

    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("btn")==null){ %>
	<form action="Q4.jsp">
	お使いのOSを選んでください<br>
	<input type="checkbox" name="os" value="Win">Windows
	<input type="checkbox" name="os" value="Mac">Mac
	<input type="checkbox" name="os" value="Linux">Linux
	<input type="submit" value="送信" name="btn"><br>
	</form>
<%}else if(request.getParameter("os")==null){%>
	<p>[選択なし]</p>
<%}else{ %>
	<% String ans=String.join(",",oss);%>
 <%= ans %>
<%--
	<%for(int i=0;i<oss.length;i++){ %>
		<%if(oss[i]!=null){%>
			<%=oss[i] %>
		<%} %>
	<%} %>
--%>
<%} %>
</body>
</html>