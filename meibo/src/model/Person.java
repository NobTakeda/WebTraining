package model;
import java.io.Serializable;

public class Person implements Serializable{
	private String name;
	private String hurigana;
	private String gender;
	private String bloodtype;
	private String[] data;


	public Person(String string, String string2, String string3, String string4) {
		this.name=string;
		this.hurigana=string2;
		this.gender=string3;
		this.bloodtype=string4;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHurigana() {
		return hurigana;
	}
	public void setHurigana(String hurigana) {
		this.hurigana = hurigana;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBloodtype() {
		return bloodtype;
	}
	public void setBloodtype(String bloodtype) {
		this.bloodtype = bloodtype;
	}
	public String[] getData() {
		return data;
	}
	public void setData(String[] data) {
		this.data = data;
	}
}
