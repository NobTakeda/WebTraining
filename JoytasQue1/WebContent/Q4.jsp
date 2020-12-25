<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
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
	<!-- submitボタンにnameをつけることで、nullかbtnが返るか設定。
		一度でも送信ボタンを押していたら結果が表示されるようにしている。 -->
	</form>
<%}else if(request.getParameter("os")==null){%>
	<p>[選択なし]</p>
<%}else{ %>
    <% String[] oss=request.getParameterValues("os"); %>
	<% String ans=String.join(",",oss);%>
 <%= ans %>
<%} %>
</body>
</html>