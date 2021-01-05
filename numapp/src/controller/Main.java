package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Numbers;
import model.NumbersLogic;


@WebServlet("/Main")
public class Main extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html; charset=UTF-8");
		String str=request.getParameter("str");
		String numA=request.getParameter("numA");
		if(numA!=null){
			RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			dr.forward(request, response);
		}else if(str==null) {
			RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/view/index.jsp");
			dr.forward(request, response);
		}else {
			Numbers numbers=new Numbers();
			NumbersLogic nl=new NumbersLogic();
			numbers.setStr(str);
			nl.makeArray(str,numbers);
			nl.makeMax(numbers);
			nl.makeMin(numbers);
			nl.makeSum(numbers);
			request.setAttribute("numbers", numbers);
			RequestDispatcher dr=request.getRequestDispatcher("/WEB-INF/view/result.jsp");
			dr.forward(request,response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
