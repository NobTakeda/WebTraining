package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.DocoDAO;
import model.Mutter;
import model.User;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//データベース授業により書き換え
		DocoDAO dao=new DocoDAO();
		List<Mutter> mutterList=dao.findAll();
		request.setAttribute("mutterList", mutterList);
		/*  //つぶやきリストをアプリケーションスコープから取得
		ServletContext application=this.getServletContext();
		List<Mutter> mutterList=(List<Mutter>) application.getAttribute("mutterList");
		*/

		/*取得できなかった場合は、つぶやきリストを新規作成してアプリケーションスコープに保存
		if(mutterList==null) {
			mutterList=new ArrayList<>();
			application.setAttribute("mutterList", mutterList);
		}
		*/

		//ログインしているか確認するためセッションスコープからユーザー情報を取得
		HttpSession session=request.getSession();
		User loginUser=(User) session.getAttribute("loginUser");

		if(loginUser==null) {//ログインしていない場合
			//リダイレクト
			response.sendRedirect("/docoTsubu/");
		}else { //ログイン済みの場合
			//フォワード
			RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
			dr.forward(request, response);
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String text=request.getParameter("text");

		//入力値チェック
		if(text !=null && text.length() !=0) {

			/*アプリケーションスコープに保存された呟きリストを取得
			ServletContext application=this.getServletContext();
			List<Mutter> mutterList=(List<Mutter>) application.getAttribute("mutterList");
			*/
			//セッションスコープに保存されたユーザーリストを取得
			HttpSession session=request.getSession();
			User loginUser=(User) session.getAttribute("loginUser");

			//データベース授業により書き換え
			DocoDAO dao=new DocoDAO();
			Mutter mutter=new Mutter(loginUser.getName(),text);
			dao.insertOne(mutter);
			/*
			List<Mutter> mutterList=dao.findAll();
			request.setAttribute("mutterList", mutterList);
			*/

			/*つぶやきをつぶやきリストに追加
			Mutter mutter=new Mutter(loginUser.getName(),text);
			PostMutterLogic postMutterLogic=new PostMutterLogic();
			postMutterLogic.execute(mutter, mutterList);
			*/

			/*アプリケーションスコープにつぶやきリストを保存
			application.setAttribute("mutterList", mutterList);
			*/
		}else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		this.doGet(request, response);
		/*メイン画面にフォワード
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dr.forward(request, response);
		*/
	}

}
