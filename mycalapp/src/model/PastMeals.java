package model;

import java.io.Serializable;

public class PastMeals implements Serializable{
	private String name;
	private int mealCal;
	private String date;

	public PastMeals() {}
	public PastMeals(String name,int mealCal,String date) {
		this.name=name;
		this.mealCal=mealCal;
		this.date=date;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getMealCal() {
		return mealCal;
	}
	public void setMealCal(int mealCal) {
		this.mealCal = mealCal;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}

}
