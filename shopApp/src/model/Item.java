package model;

import java.io.Serializable;

public class Item implements Serializable{

	private String name;
	private int price;
	private int totalPrice;
	private int itemType;

	public Item() {}
	public Item(String name,int itemType) {
		this.name=name;
		this.itemType=itemType;

		if(this.itemType==1) {
			this.price=500;
		}else if(this.itemType==2) {
			this.price=1000;
		}else if(this.itemType==3) {
			this.price=200;
		}else {
			this.price=100;
		}
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
	public int getTotalPrice() {
		return totalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		this.totalPrice = totalPrice;
	}
	public int getItemType() {
		return itemType;
	}
	public void setItemType(int itemType) {
		this.itemType = itemType;
	}

}
