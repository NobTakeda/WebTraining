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
import model.Food;

@WebServlet("/Manage")
public class Manage extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String isRegister=(String)request.getAttribute("isRegister");
		String isPush=(String)request.getParameter("isPush");
		if(isRegister!=null) {
			request.setAttribute("isRegister", isRegister);
		}
		String date=(String)request.getAttribute("date");
		String showDate=request.getParameter("showDate");
		if(showDate==null || showDate.length()<=0) {
			showDate=date;
		}
		CalDAO dao=new CalDAO();

		List<Food> list=dao.findToday(showDate);
		String msg="";
		HttpSession session=request.getSession();
		if(list==null) {
			msg="まだ食べたものが登録されていません";
			session.setAttribute("msg",msg);
		}
		request.setAttribute("list", list);
		request.setAttribute("isPush", isPush);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/manage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name=request.getParameter("name");
		int cal=Integer.parseInt(request.getParameter("cal"));
		String date=request.getParameter("date");
		//System.out.print(date);
		int time=Integer.parseInt(request.getParameter("time"));
		Food food=new Food(name,cal,time,date);
		CalDAO dao=new CalDAO();
		dao.insertOne(food);
		//入力したFoodをテーブルに追加
		List<Food> list=dao.findToday(date);
		request.setAttribute("list", list);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/manage.jsp");
		rd.forward(request, response);
	}

}
