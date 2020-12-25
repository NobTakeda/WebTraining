<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" %>
    <%
    String[] options={
    		"好きな食べ物を一つ選んでください",
    		"寿司",
    		"ラーメン",
    		"焼き肉",
    };
    String[] results={
    		"選択なし",
    		"やっぱ寿司ですよね！",
    		"バリエーション豊富だし、ラーメン最高!",
    		"やっぱ肉ですよね！",
    };
    %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<%if(request.getParameter("btn") == null){ %>
	<form>
	<select name="favo">
	<% for(int i=0;i<options.length;i++){ %>
		<option value="<%=i %>"><%=options[i] %></option>
	<%} %>
	</select>
	<input type="submit" value="送信" name="btn">
	</form>
<%}else{ %>
	<%
	String index=request.getParameter("favo");
	%>
	<p><%=results[Integer.parseInt(index)] %></p>
<%} %>
</body>
</html>