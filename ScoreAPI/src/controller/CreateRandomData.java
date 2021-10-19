package controller;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import dao.ScoreDAO;
import model.Score;

@WebServlet("/CreateRandomData")
public class CreateRandomData extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		String path=application.getRealPath("/WEB-INF/data/data.csv");
		FileInputStream fis=new FileInputStream(path);
		InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
		BufferedReader br=new BufferedReader(isr);
		List<Score> list=new ArrayList<>();
		Random rand=new Random();
		String line;
		while((line=br.readLine())!=null){
			String[] vals=line.split(",");
			Score score=new Score();
			score.setName(vals[0]);
			//0~9999のランダム
			score.setScore(rand.nextInt(100000));
			score.setSex(Integer.parseInt(vals[1]));
			list.add(score);
		}
		ScoreDAO dao=new ScoreDAO();
		dao.insertAll(list);
		br.close();
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

}
