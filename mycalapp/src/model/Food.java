package model;

import java.io.Serializable;

public class Food implements Serializable{

	private String name;
	private int cal;
	private String date;

	public Food() {}
	public Food(String name,int cal) {
		this.name=name;
		this.cal=cal;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	
}
