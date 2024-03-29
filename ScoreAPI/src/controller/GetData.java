package controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ScoreDAO;
import model.Score;

@WebServlet("/GetData")
public class GetData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String count_s=request.getParameter("count");
		int count;
		if(count_s==null) {
			count=10;
		}else {
			count=Integer.parseInt(count_s);
		}
		ScoreDAO dao=new ScoreDAO();
		List<Score> list=dao.find(count);
		Gson gson=new Gson();
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		out.print("{\"result\":"+ gson.toJson(list)+"}");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
