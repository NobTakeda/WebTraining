package controller;

import java.io.IOException;
import java.util.ArrayList;
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

@WebServlet("/FodUpdate")
public class FodUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String date=request.getParameter("date");
		String update=request.getParameter("update");
		String isPush=request.getParameter("isPush");

		CalDAO dao=new CalDAO();
		FoodOfDay fod=new FoodOfDay();
		FodLogic fl=new FodLogic();
		HttpSession session=request.getSession();
		List<Food> updatedList=new ArrayList<>();
		if(update!=null) {
			fod.setDate(update);
			System.out.println("FodUpdate,update!=nullの場合");
			List<Food> updateList=dao.findToday(update);
			System.out.println("↑FodUpdate,dao.findToday実行");
			fl.execute(updateList, fod);
			dao.updateFOD(fod);
			updatedList=dao.findToday(update);
			session.setAttribute("date",update);
			System.out.println("FoodUpdate.java:fodテーブルを更新する時はこっち");
		}else if(date!=null){
			fod.setDate(date);
			FoodOfDay fod2=dao.findOneFOD(date);
			System.out.println("↑fod2を探す");
			if(fod2.getTotalCal()<=0) {
				List<Food> list=dao.findToday(date);
				fl.execute(list, fod);
				dao.insertFOD(fod);
				System.out.println("FodUpdate:献立を登録するボタン実行時。fod2がない時"+date);
			}
			updatedList=dao.findToday(date);
			session.setAttribute("date",date);
			System.out.println("挿入又は更新処理終了");
		}
		String isRegister="true";
		request.setAttribute("isRegister", isRegister);
		request.setAttribute("isPush", isPush);
		session.setAttribute("list",updatedList);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/manage.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
