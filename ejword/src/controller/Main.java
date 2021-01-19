package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.EJWord;
import model.EJWordLogic;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final int LIMIT=20;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		String searchWord=request.getParameter("searchWord");
		EJWord ejw;
		if(searchWord != null) {
			String mode=request.getParameter("mode");
			if(mode == null) {
				mode="startsWith";
			}
			String page=(String)request.getParameter("page");
			int pageNo=page==null? 1:Integer.parseInt(page);
			ejw=new EJWord(searchWord,mode,pageNo,LIMIT);
			EJWordLogic logic=new EJWordLogic();
			logic.execute(ejw);

		}else {
			ejw=new EJWord();
		}
		request.setAttribute("ejw", ejw);

		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

}
/*
package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.WordDAO;
import model.Word;

@WebServlet("/main")
public class Main extends HttpServlet {
	private static final int LIMIT=20;
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String searchWord=request.getParameter("searchWord");
		if(searchWord !=null) {
			String mode=(String) request.getParameter("mode");
			if(mode==null) {
				//もしURL直打ちなどでリクエストが来て、modoが選ばれていない場合
				mode="startsWith";
				//デフォルトの検索モードをstartsWithで設定している。
			}
			String page=(String)request.getParameter("page");
			int pageNo= page==null? 1:Integer.parseInt(page);
			WordDAO dao=new WordDAO();
			int total=dao.getCount(searchWord, mode);
			List<Word> list=dao.getListBySearchWord(searchWord, mode,LIMIT,(pageNo-1)*LIMIT);
			request.setAttribute("total", total);
			request.setAttribute("limit", LIMIT);
			request.setAttribute("searchWord", searchWord);
			request.setAttribute("mode", mode);
			request.setAttribute("list", list);
			request.setAttribute("pageNo", pageNo);

			//ここからpagination
			if(total > LIMIT) {
				//ページ数を求める
				//totalをLIMITで割り切れるか？＞trueならtotal/LIMITがページ数、余りがあったら商+1がページ数
				int pageCount=total%LIMIT==0? total/LIMIT:total/LIMIT+1;
				String link="";
				StringBuilder sb=new StringBuilder();
				sb.append("<div class='paginationBox'>\n");
				sb.append("<ul class='pagination'>\n");//この\nはソースコード上での改行。(System.outでの命令が改行されるようにする)

				//ページ数が20ページで収まるか？
				if(pageCount<20) {
					for(int i=1;i<=pageCount;i++) {
						link="/ejword/main?searchWord="+searchWord+"&mode="+mode+"&page="+i;
						sb.append("<li class='"+(pageNo==i? "active":"")+"'><a href='"+link+"'>"+i+"</a></li>\n");
					}
				}else {
					//大量にページがある場合、先頭へのリンクを追加する
					link="/ejword/main?searchWord="+searchWord+"&mode="+mode+"&page="+1;
					sb.append("<li class='"+(pageNo==1? "disabled":"")+"'><a href='"+link+"' aria-label='Start'><span aria-hidden='true'>&laquo;</span></a></li>\n");
					//現在ページから前後5件を表示
					for(int i=pageNo-5;i<=pageNo+5;i++) {
						if(i<1 || i>pageCount) {continue;}
						link="/ejword/main?searchWord="+searchWord+"&mode="+mode+"&page="+i;
						sb.append("<li class='"+(pageNo==i? "active":"")+"'><a href='"+link+"'>"+i+"</a></li>\n");
					}
					//最後へのリンクを追加する
					link="/ejword/main?searchWord="+searchWord+"&mode="+mode+"&page="+pageCount;
					sb.append("<li class='"+(pageNo==total/LIMIT+1? "disabled":"")+"'><a href='"+link+"' aria-label='End'><span aria-hidden='true'>&raquo;</span></a></li>\n");
				}
				sb.append("</ul>\n");
				sb.append("</div>\n");
				request.setAttribute("pagination", sb.toString());
			}

		}
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

}
*/
