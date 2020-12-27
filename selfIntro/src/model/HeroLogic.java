package model;
import java.util.Random;

public class HeroLogic {
	public void execute(Hero hero) {
		//名前からseedを算出
		String name=hero.getName();
		int seed=0;
		for(int i=0;i<name.length();i++){
			seed+=name.charAt(i);
		}
		//seedからパラメータを決定
		int[] maxArr= {100,100,50,50,50};
		int[] vals=new int[maxArr.length];
		Random rand=new Random(seed);
		for(int i=0;i<vals.length;i++){
			vals[i]=rand.nextInt(maxArr[i])+1;
		}
		hero.setParams(vals);

	}
	public String[] makeShowParams(Hero hero,int[] params) {
		String[] showParams=new String[params.length];
		String[] paraNames=hero.getParaNames();
		for(int i=0;i<params.length;i++){
		      showParams[i] = (paraNames[i] + ":" + params[i]);
		    }
		return showParams;
	}
	public void raceBonus(Hero hero,int race) {
		int[][] raceMatrix={
				{10,10,10,10,10},
				{0,20,0,10,20},
				{30,0,20,0,0},
				{10,0,0,25,20},
				};
		int[] params=hero.getParams();
			for(int i=0;i<params.length;i++){
				params[i]+=raceMatrix[race][i];
			}
		hero.setParams(params);
		hero.setRace(race);
	}
	public void jobBonus(Hero hero,int job) {
		double[][] jobMatrix={
				{1.6,1,1.4,1,1},
				{1.1,1,1.2,1.3,1.3},
				{1.3,1.5,1.1,1,1},
				{1,1.9,1,1,1.1},
			};
		int[] params=hero.getParams();
		for(int i=0;i<params.length;i++){
			params[i]*=jobMatrix[job][i];
		}
		hero.setParams(params);
		hero.setJob(job);
	}
	public void introduction(Hero hero) {
		int[] params=hero.getParams();
		int sum=0;
		for(int i=0;i<params.length;i++) {
			sum+=params[i];
		}
		hero.setSumParam(sum);

		int[] sortedParams=params;
		int max=sortedParams[0];
		for(int i=1;i<sortedParams.length-1;i++) {
			if(max<sortedParams[i]) {
				max=sortedParams[i];
			}
		}
		hero.setSortedParams(sortedParams);
		String[] resultStr=this.makeShowParams(hero, sortedParams);
		hero.setResult(resultStr);
	}
}
