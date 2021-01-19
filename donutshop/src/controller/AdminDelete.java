package controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.DonutDAO;
import model.Donut;

@WebServlet("/Admin/Delete")
@MultipartConfig
public class AdminDelete extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String id=request.getParameter("id");
		DonutDAO dao=null;
		if(id!=null) {
			dao=new DonutDAO();
			dao.deleteOne(Integer.parseInt(id));
		}
		List<Donut> list=dao.findAll();
		request.setAttribute("list", list);
		request.setAttribute("msg", "1件削除しました");
		response.sendRedirect("/WEB-INF/admin/main.jsp");
		/*
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/admin/main.jsp");
		rd.forward(request,response);
		*/
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
