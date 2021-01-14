package controller;

import java.io.IOException;
import java.util.Random;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Gladiator;
import model.GladiatorLogic;

@WebServlet("/Fight")
public class Fight extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		String hp=request.getParameter("hp");
		String pow=request.getParameter("pow");
		String speed=request.getParameter("speed");

		//剣闘士を作成せずに入場を押した場合、作成画面へ飛ばす
		if(name==null || name.equals("")) {
			RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/main.jsp");
			rd.forward(request, response);
		}
		//hiddenで受け取ったパラメータで自分の剣闘士を作成、セッションスコープに格納
		Gladiator player=new Gladiator(name,Integer.parseInt(hp),Integer.parseInt(pow),Integer.parseInt(speed));
		Gladiator enemy=new Gladiator();
		GladiatorLogic gl=new GladiatorLogic();
		gl.setEnemy(enemy);
		HttpSession session=request.getSession();
		session.setAttribute("player", player);
		session.setAttribute("enemy", enemy);
		//戦闘用のjspへ移動
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/fight.jsp");
		rd.forward(request,response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session=request.getSession();
		Gladiator player=(Gladiator)session.getAttribute("player");
		Gladiator enemy=(Gladiator)session.getAttribute("enemy");
		GladiatorLogic gl=(GladiatorLogic)session.getAttribute("gl");
		String action=request.getParameter("action");
		if(gl==null) {
			gl=new GladiatorLogic();
		}
		if(player.getHp()>0 && enemy.getHp()>0) {
			if(action==null) {
				gl.setMsgs(0,"行動が選択されていない！");
				gl.setMsgs(1,"");
				gl.setMsgs(2,"");
				gl.setMsgs(3,"");
			}else {
				//playerとenemyのアクションを設定
				player.setAction(Integer.parseInt(action));
				int enemyAction=new Random().nextInt(3)+1;
				enemy.setAction(enemyAction);

				//GladiatorLogicでアクション解決
				gl.fight(player,enemy);
			}
		}else if(player.getHp()>0 && enemy.getHp()==0) {
			gl.setMsgs(0, "剣闘士"+enemy.getName()+"はちから尽きた！");
			gl.setMsgs(1, "剣闘士"+player.getName()+"の勝利！！");
			gl.setMsgs(2, " ");
			gl.setMsgs(3, "Congratulations!!");
		}else{
			gl.setMsgs(0, "剣闘士"+player.getName()+"はちから尽きた！");
			gl.setMsgs(1, "剣闘士"+enemy.getName()+"の勝利！！");
			gl.setMsgs(2, " ");
			gl.setMsgs(3, "Game Over");
		}
		session.setAttribute("player",player);
		session.setAttribute("enemy", enemy);
		session.setAttribute("gl", gl);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/fight.jsp");
		rd.forward(request, response);
	}

}
