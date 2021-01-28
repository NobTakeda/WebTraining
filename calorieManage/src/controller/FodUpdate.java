package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.CalDAO;
import model.FodLogic;
import model.Food;
import model.FoodOfDay;

@WebServlet("/FodUpdate")
public class FodUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		String update=request.getParameter("update");

		CalDAO dao=new CalDAO();
		FoodOfDay fod=new FoodOfDay();
		FodLogic fl=new FodLogic();

		if(update!=null) {
			fod.setDate(update);
			List<Food> updateList=dao.findToday(update);
			fl.execute(updateList, fod);
			dao.updateFOD(fod);
			request.setAttribute("date",update);
		}else {
			fod.setDate(date);
			List<Food> list=dao.findToday(date);
			fl.execute(list, fod);
			dao.insertFOD(fod);
			request.setAttribute("date",date);
		}
		String isRegister="true";

		request.setAttribute("isRegister", isRegister);

		RequestDispatcher rd=request.getRequestDispatcher("/Manage");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
