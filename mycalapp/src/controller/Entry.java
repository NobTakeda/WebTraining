package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Health;
import model.LoginLogic;

@WebServlet("/Entry")
public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/entry.jsp");
		rd.forward(request, response);
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String name=request.getParameter("name");
		String pass=request.getParameter("pass");

		//Userインスタンス（ユーザー情報）の生成
		Health health=new Health(name,pass);

		//ログイン処理
		LoginLogic loginLogic=new LoginLogic();
		boolean isLogin=loginLogic.execute(health);

		//ログイン成功時の処理
		if(isLogin) {
			//ユーザー情報をセッションスコープに保存
			HttpSession session=request.getSession();
			session.setAttribute("loginUser", health);
		}
		//ログイン結果画面にフォワード
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
		dr.forward(request, response);
	}
}
