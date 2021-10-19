package controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import dao.ScoreDAO;
import model.RankingResult;
import model.Score;

@WebServlet("/GetRanking")
public class GetRanking extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//parameterでcountが来ているか？
		String count=request.getParameter("count");
		//countが来ていなかったらTOP10,そうでなければcount件のデータを取得する
		count = count==null ? "10":count;
		String name=request.getParameter("name");
		name = name==null ? "未入力":name;
		String score=request.getParameter("score");
		score = score==null ? "0":score;
		String sex=request.getParameter("sex");
		sex = sex==null ? "0":sex;

		//Scoreインスタンスを作成
		Score s=new Score();
		s.setName(name);
		s.setScore(Integer.parseInt(score));
		s.setSex(Integer.parseInt(sex));

		//RankingResultインスタンスを取得
		ScoreDAO dao=new ScoreDAO();
		RankingResult result=dao.getRankingResult(s, Integer.parseInt(count));
		//パーサーをnew
		Gson gson=new Gson();
		//コンテントタイプをjsonに指定
		response.setContentType("application/json;charset=UTF-8");
		PrintWriter out=response.getWriter();
		//resultインスタンスをJSONにして出力する
		out.print(gson.toJson(result));

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request,response);
	}

}
