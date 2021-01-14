package model;

import java.io.Serializable;

public class Gladiator implements Serializable{
	private String name;
	private int hp;
	private int pow;
	private int speed;
	private boolean isHave;
	private int action;

	public Gladiator() {}
	public Gladiator(String name,int hp,int pow,int speed) {
		this.name=name;
		this.hp=hp;
		this.pow=pow;
		this.speed=speed;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getHp() {
		return hp;
	}
	public void setHp(int hp) {
		this.hp = hp;
	}
	public int getSpeed() {
		return speed;
	}
	public void setSpeed(int speed) {
		this.speed = speed;
	}
	public boolean isHave() {
		return isHave;
	}
	public void setHave(boolean isHave) {
		this.isHave = isHave;
	}
	public int getPow() {
		return pow;
	}
	public void setPow(int pow) {
		this.pow = pow;
	}
	public int getAction() {
		return action;
	}
	public void setAction(int action) {
		this.action = action;
	}
}

