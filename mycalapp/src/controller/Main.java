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

import dao.CalDAO2;
import model.Health;
import model.HealthLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		request.setCharacterEncoding("UTF-8");
		String height=request.getParameter("heightCm");
		String weight=request.getParameter("weightKg");
		String gender=request.getParameter("gender");
		String targetCal=request.getParameter("targetCal");
		HttpSession session=request.getSession();
		Health health=(Health)session.getAttribute("loginUser");
		if(targetCal!=null) {
			health.setTargetCal(Integer.parseInt(targetCal));
		}else {
			health.setTargetCal(0);
		}
		health.setGender(Integer.parseInt(gender));
		health.setHeight(Double.parseDouble(height));
		health.setWeight(Double.parseDouble(weight));
		HealthLogic hl=new HealthLogic();
		hl.checkBmi(health,Double.parseDouble(height),Double.parseDouble(weight));
		//ここまでで名前、身長、体重、性別、BMI、標準摂取カロリーが埋まる。
		CalDAO2 dao=new CalDAO2();
		dao.insertOne(health);
		//List<Health> list=dao.findAll();
		//session.setAttribute("userData", list);
		session.setAttribute("loginUser",health);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/data.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//リクエストパラメータの取得
		String targetCal=request.getParameter("targetCal");
		HttpSession session=request.getSession();
		Health health=(Health)session.getAttribute("loginUser");
		if(targetCal!=null || Integer.parseInt(targetCal)==0){
			health.setTargetCal(Integer.parseInt(targetCal));
		}else {
			response.sendRedirect("/WEB-INF/view/data.jsp");
		}
		CalDAO2 dao=new CalDAO2();
		List<Health> list=dao.findAll();
		
		//List<Health> list=dao.findAll();
		//session.setAttribute("userData", list);
		session.setAttribute("loginUser",health);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/data.jsp");
		rd.forward(request, response);
	}
}
