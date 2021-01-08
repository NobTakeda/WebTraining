package model;

import java.io.Serializable;

public class Product implements Serializable{

	private String name;
	private int price;
	private int sum;

	public Product() {}
	public Product(String name,int price) {
		this.name=name;
		this.price=price;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}
}
