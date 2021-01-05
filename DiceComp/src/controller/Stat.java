package controller;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Statistics;
@WebServlet("/Stat")
public class Stat extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		Statistics stat=(Statistics)application.getAttribute("stat");
		if(stat==null) {
			stat=new Statistics();
		}
		application.setAttribute("stat", stat);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/stat.jsp");
		rd.forward(request, response);
	}
}