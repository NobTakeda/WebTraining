package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import dao.CalDAO;
import model.FodLogic;
import model.Food;
import model.FoodOfDay;

@WebServlet("/ShowGraph")
public class ShowGraph extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		CalDAO dao=new CalDAO();
		FoodOfDay fod=new FoodOfDay();
		fod.setDate(date);
		FodLogic fl=new FodLogic();
		List<Food> list=dao.findToday(date);
		fl.execute(list,fod);

		//1週間分のFoodOfDayデータをfodlistに詰める
		List<FoodOfDay> fodlist=dao.findFOD(date);
		HttpSession session=request.getSession();
		session.setAttribute("fodlist",fodlist);
		request.setAttribute("date", date);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/showgraph.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
