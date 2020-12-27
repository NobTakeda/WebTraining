package model;
import java.io.Serializable;

public class Hero implements Serializable{
	private int[] params;
	private String[] paraNames={"体力","魔力","パワー","きようさ","すばやさ"};
	private String[] races= {"人間","ハイエルフ","トロル","ノーム"};
	private String[] jobs={"戦士","盗賊","僧侶","魔術師"};
	private String[] showParams;
	private String name;
	private String race;
	private String job;
	private int sumParam;
	private int[] sortedParams;
	private String[] result;

	public Hero() {}
	public Hero(String name) {
		this.name=name;
	}

	public int[] getParams() {
		return params;
	}

	public void setParams(int[] params) {
		this.params = params;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getRace() {
		return race;
	}

	public void setRace(int num) {
		this.race = races[num];
	}
	public void setRace(String race) {
		this.race = race;
	}

	public String getJob() {
		return job;
	}

	public void setJob(int num) {
		this.job =jobs[num];
	}
	public void setJob(String job) {
		this.job=job;
	}
	public String[] getParaNames() {
		return paraNames;
	}
	public void setParaNames(String[] paraNames) {
		this.paraNames = paraNames;
	}
	public String[] getShowParams() {
		return showParams;
	}
	public void setShowParams(String[] showParams) {
		this.showParams = showParams;
	}
	public String[] getRaces() {
		return races;
	}
	public void setRaces(String[] races) {
		this.races = races;
	}
	public String[] getJobs() {
		return jobs;
	}
	public void setJobs(String[] jobs) {
		this.jobs = jobs;
	}
	public int getSumParam() {
		return sumParam;
	}
	public void setSumParam(int sumParam) {
		this.sumParam = sumParam;
	}
	public int getSortedParams(int num) {
		return sortedParams[num];
	}
	public void setSortedParams(int[] sortedParams) {
		this.sortedParams = sortedParams;
	}
	public String[] getResult() {
		return result;
	}
	public void setResult(String[] result) {
		this.result = result;
	}
}
