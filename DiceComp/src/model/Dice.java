package model;

import java.io.Serializable;

public class Dice implements Serializable{
	//出目の状態を管理
	private int[] diceStates= {0,0,0,0,0,0,};
	private int count=0;//何回目か
	private int total=0;//いくら消費しているのか
	private int nowDice=0;//一番新しい出目
	private String msg="Push this Button";

	public int[] getDiceStates() {
		return diceStates;
	}
	public void setDiceStates(int[] diceStates) {
		this.diceStates = diceStates;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public int getTotal() {
		return total;
	}
	public void setTotal(int total) {
		this.total = total;
	}
	public int getNowDice() {
		return nowDice;
	}
	public void setNowDice(int nowDice) {
		this.nowDice = nowDice;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}

}