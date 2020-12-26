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
		<p>グーチョキパーをえらんでね！</p>
<%	}else if(request.getParameter("hand")==null){%>
		<p>グーチョキパーをえらんでね！</p>
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
<%		}else if(handNum==0 && npcNum == 1){%>
 			<p>あなたのかちです！</p>
<%		}else if(handNum==0 && npcNum==2){ %>
 			<p>あなたのまけです！</p>
<%		}else if(handNum==1 && npcNum==0){%>
			<p>あなたのまけです！</p>
<%		}else if(handNum==1 && npcNum==2){ %>
			<p>あなたのかちです！</p>
<%		}else if(handNum==2 && npcNum==0){%>
			<p>あなたのかちです！</p>
<%		}else{ %>
			<p>あなたのまけです！</p>
<%		}
	}%>
</body>
</html>