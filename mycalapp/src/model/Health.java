package model;

import java.io.Serializable;

public class Health implements Serializable {
	private String name;
	private String pass;
	private double weight;
	private double height;
	private double bmi;
	private int cal;
	private int targetCal;
	private int morning;
	private int lunch;
	private int supper;
	private int gender;
	private int id;

	public Health() {}
	public Health(String name,String pass) {
		this.name=name;
		this.pass=pass;
	}

	public Health(int id,String name,int gender,Double height,Double weight,Double bmi,int cal,int targetCal){
		this.name=name;
		this.gender=gender;
		this.height=height;
		this.weight=weight;
		this.bmi=bmi;
		this.cal=cal;
		this.targetCal=targetCal;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	public double getWeight() {
		return weight;
	}
	public void setWeight(double weight) {
		this.weight = weight;
	}
	public double getHeight() {
		return height;
	}
	public void setHeight(double height) {
		this.height = height;
	}
	public double getBmi() {
		return bmi;
	}
	public void setBmi(double bmi) {
		this.bmi = bmi;
	}
	public int getCal() {
		return cal;
	}
	public void setCal(int cal) {
		this.cal = cal;
	}
	public int getTargetCal() {
		return targetCal;
	}
	public void setTargetCal(int targetCal) {
		this.targetCal = targetCal;
	}
	public int getMorning() {
		return morning;
	}
	public void setMorning(int morning) {
		this.morning = morning;
	}
	public int getLunch() {
		return lunch;
	}
	public void setLunch(int lunch) {
		this.lunch = lunch;
	}
	public int getSupper() {
		return supper;
	}
	public void setSupper(int supper) {
		this.supper = supper;
	}
	public int getGender() {
		return gender;
	}
	public void setGender(int gender) {
		this.gender = gender;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

}
