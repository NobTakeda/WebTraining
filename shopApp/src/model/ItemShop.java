package model;

import java.io.Serializable;

public class ItemShop implements Serializable{

	private String name;
	private int fund;
	private Item[] items;
	private int count;

	public ItemShop() {}
	public ItemShop(String name) {
		this.setName(name);
		this.items=new Item[3];
		this.setCount(0);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getFund() {
		return fund;
	}
	public void setFund(int fund) {
		this.fund = fund;
	}
	public Item[] getItems() {
		return items;
	}
	public void setItems(Item item,int index) {
		this.items[index] = item;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
}
