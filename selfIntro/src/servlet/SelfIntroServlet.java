package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Hero;
import model.HeroLogic;


@WebServlet("/SelfIntroServlet")
public class SelfIntroServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/index.jsp");
		dr.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String name=request.getParameter("name");
		Hero h1=new Hero(name);
		HeroLogic hl1=new HeroLogic();
		hl1.execute(h1);

		h1.setShowParams(hl1.makeShowParams(h1,h1.getParams()));

		request.setAttribute("hero1",h1);
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/raceSellect.jsp");
		dr.forward(request, response);
	}

}
