package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Health;
import model.HealthLogic;

@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/form.jsp");
		rd.forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String height=request.getParameter("height");
		String weight=request.getParameter("weight");
		Health health=new Health(Double.parseDouble(height),Double.parseDouble(weight));
		HealthLogic hl=new HealthLogic();
		hl.execute(health);

		request.setAttribute("health",health);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/result.jsp");
		rd.forward(request, response);
	}

}
