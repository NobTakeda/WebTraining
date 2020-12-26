<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" import="java.util.*"%>
<% Random rand=new Random(); %>
<%
	List <String> hands=new ArrayList<>();
	hands.add("<img src=\"images/gu.png\">");
	hands.add("<img src=\"images/choki.png\">");
	hands.add("<img src=\"images/pa.png\">");

	int handNum;
	int npcNum;
	final int GOAL=10;
	int count=0;
	int npcCount=0;
	String player;
	String npc;
%>
<!DOCTYPE html>
<html>
<head>
  <meta charset="UTF-8">
  <link rel="stylesheet" href="css/main.css">
  <link href="https://fonts.googleapis.com/earlyaccess/nicomoji.css" rel="stylesheet">
  <title>じゃんけんぽん</title>
</head>
<body>
	<form method="post">
   		<input type="radio" name="hand" value="0">ぐー<br>
   		<input type="radio" name="hand" value="1">ちょき<br>
   		<input type="radio" name="hand" value="2">ぱー<br>
   		<button type="submit" name="btn">ショウブ</button>
	</form>
<%	if(request.getParameter("btn")==null ){%>
		<p>じゃんけんをしましょう！</p>
		<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
		<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%	}else if(request.getParameter("hand")==null){%>
		<p>グーチョキパーをえらんでね！</p>
		<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
		<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%	}else if(count>=GOAL || npcCount>=GOAL){
		if(count>npcCount){ %>
		<p>あなたがさきにゴールしました！</p>
<%		}else{ %>
		<p>あいてがさきにゴールしました！</p>
		<%} %>
<%	}else {
	 	String handStr=request.getParameter("hand");
	 	handNum=Integer.parseInt(handStr);
	 	npcNum=rand.nextInt(3);
	 	switch(handNum){
	 	case 0: %>
  		<div>
			<%=hands.get(0) %>
			<%=hands.get(npcNum) %>
  		</div>
<% 			break;
 	 	case 1:%>
  		<div>
			<%=hands.get(1) %>
			<%=hands.get(npcNum) %>
  		</div>
<% 			break;
 	 	case 2:%>
  		<div>
			<%=hands.get(2) %>
			<%=hands.get(npcNum) %>
  		</div>
<%	 	break;
		}
		if(handNum == npcNum){ %>
 			<p>あいこです！</p>
<%		}else if(handNum==0 && npcNum == 1){
			count+=1; %>
 			<p>あなたのかちです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			< class="score"p>あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}else if(handNum==0 && npcNum==2){
			npcCount+=5; %>
 			<p>あなたのまけです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}else if(handNum==1 && npcNum==0){
			npcCount+=1;%>
			<p>あなたのまけです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}else if(handNum==1 && npcNum==2){
			count+=2; %>
			<p>あなたのかちです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}else if(handNum==2 && npcNum==0){
			count+=5; %>
			<p>あなたのかちです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}else{
			npcCount+=2; %>
			<p>あなたのまけです！</p>
			<p class="score">あなた:<%for(int i=0;i<count;i++){ %><%="*" %><%} %></p>
			<p class="score">あいて:<%for(int j=0;j<npcCount;j++){ %><%="*" %><%} %></p>
<%		}
	}%>
</body>
</html>