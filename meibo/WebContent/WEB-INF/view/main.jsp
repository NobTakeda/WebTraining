<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="model.*,java.util.*"%>
    <%
    List<Person> list=(List<Person>)application.getAttribute("list");
    %>
<!DOCTYPE html>
<html lang="ja">
  <head>
    <!-- Required meta tags -->
    <meta charset="utf-8">
    <meta name="viewport" content="width=device-width, initial-scale=1, shrink-to-fit=no">

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.5.0/css/bootstrap.min.css" integrity="sha384-9aIt2nRpC12Uk9gS9baDl411NQApFmC26EwAOH8WgZl5MYYxFfc+NcPb1dKGj7Sk" crossorigin="anonymous">

    <title>名簿</title>
  </head>
  <body>
	<div class="container">
		<table class="table" >
			<% for(int i=0;i<list.size();i++){ %>
				<tr>
					<td><%= list.get(i).getName() %></td>
					<td><%= list.get(i).getHurigana() %></td>
					<td><%= list.get(i).getGender() %></td>
					<td><%= list.get(i).getBloodtype() %></td>
				</tr>
			<% } %>
		</table>
	</div>
  </body>
</html>