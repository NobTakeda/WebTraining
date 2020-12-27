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

@WebServlet("/RaceServlet")
public class RaceServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");

		String hp=request.getParameter("hp");
		String mp=request.getParameter("mp");
		String str=request.getParameter("str");
		String dex=request.getParameter("dex");
		String agi=request.getParameter("agi");
		String name=request.getParameter("name");
		int[] params=new int[5];
		params[0]=Integer.parseInt(hp);
		params[1]=Integer.parseInt(mp);
		params[2]=Integer.parseInt(str);
		params[3]=Integer.parseInt(dex);
		params[4]=Integer.parseInt(agi);

		Hero h1=new Hero(name);
		h1.setParams(params);
		HeroLogic hl1=new HeroLogic();
		String race=request.getParameter("race");
		int raceNum=Integer.parseInt(race);
		hl1.raceBonus(h1,raceNum);
		h1.setShowParams(hl1.makeShowParams(h1,h1.getParams()));

		request.setAttribute("hero1",h1);
		RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/jsp/jobSellect.jsp");
		dr.forward(request, response);
	}
}
