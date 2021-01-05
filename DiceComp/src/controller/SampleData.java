package controller;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeMap;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Dice;
import model.Statistics;
import model.StatisticsLogic;
@WebServlet("/SampleData")
public class SampleData extends HttpServlet {
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext application=this.getServletContext();
		Statistics stat=(Statistics)application.getAttribute("stat");
		if(stat==null) {
			stat=new Statistics();
		}
		this.createDummy(stat);
		Dice dice=new Dice();
		dice.setCount(6);
		dice.setTotal(1800);
		StatisticsLogic sl=new StatisticsLogic();
		sl.addData(stat, dice);
		application.setAttribute("stat", stat);
		RequestDispatcher rd=request.getRequestDispatcher("/WEB-INF/view/stat.jsp");
		rd.forward(request, response);
	}
	private void createDummy(Statistics stat) {
		//<何回でコンプしたか,それが何回あったか>を管理するMap
		//TreeMapを使うことでKeyを昇順にしてくる。
		Map<Integer, Integer> map = new TreeMap<>();
		//実行例をみると1回から~発生した最大回数まで出力しているのでその最大回数を調べる変数
		int maxThrowCount = 0;
		for (int i = 0; i < 500; i++) {
			//1回ごとのコンプ回数
			int diceThrowCount = diceCompCount();
			if (diceThrowCount > maxThrowCount) {
				//もし、最大回数が更新されたらmaxThrowCountを更新していく
				maxThrowCount = diceThrowCount;
			}
			//Mapに登録するときの回数用の変数
			int count;
			if (map.containsKey(diceThrowCount)) {
				//再登場ならばcountは今までの合計値+1
				count = map.get(diceThrowCount) + 1;
			} else {
				//初登場ならばcountは1
				count = 1;
			}
			//マップに登録(or 更新)
			map.put(diceThrowCount, count);
		}
		stat.setMap(map);
		stat.setMaxThrowCount(maxThrowCount);
	}
	private int diceCompCount() {
		Random rand = new Random();
		Set<Integer> set=new HashSet<>();
		int count=0;
		while(set.size() < 6){
			count++;
			int dice=rand.nextInt(6)+1;
			set.add(dice);
		}
		return count;
	}
}