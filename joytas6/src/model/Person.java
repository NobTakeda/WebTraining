package model;

import java.io.Serializable;

public class Person implements Serializable{

	private String name;
	private String email;
	private String memo;

	public Person() {}
	public Person(String name,String email,String memo) {
		this.name=name;
		this.email=email;
		this.memo=memo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getMemo() {
		return memo;
	}
	public void setMemo(String memo) {
		this.memo = memo;
	}

}
