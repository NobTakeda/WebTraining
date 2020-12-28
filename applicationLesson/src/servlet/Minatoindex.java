package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.SiteEV;
import model.SiteEVLogic;

@WebServlet("/Minatoindex")
public class Minatoindex extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//アプリケーションスコープに保存されたサイト評価を取得
		ServletContext application=this.getServletContext();
		//jspでは暗黙のObjectnoサーブレットコンテキストの名前がapplicationなので変数名をこれにしている。
		SiteEV siteEV=(SiteEV) application.getAttribute("siteEV");

		//サイト評価の初期化（初回リクエスト実行時)
		if(siteEV==null) {
			siteEV=new SiteEV();
		}
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String action=request.getParameter("action");//ここではactionがnull

		//サイトの評価処理（初回リクエスト時は実行しない）
		SiteEVLogic siteEVLogic=new SiteEVLogic();
		if(action !=null && action.equals("like")) {
			//注）短絡評価
			//先にaction!=nullを書いておかないと、実行時にnullpointerエラーが出る
			//nullがequals()を実行しようとするため。
			siteEVLogic.like(siteEV);
		}else if(action !=null && action.equals("dislike")) {
			siteEVLogic.dislike(siteEV);
		}
		//アプリケーションスコープにサイト評価を保存
		application.setAttribute("siteEV", siteEV);

		//フォワード
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/minatoIndex.jsp");
		dr.forward(request, response);
	}

}