package model;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Numbers implements Serializable {
	private String str;
	List<Integer> numsList=new ArrayList<>();
	private int max;
	private int min;
	private int sum;

	public Numbers() {}
	public Numbers(String str) {
		this.str=str;
	}

	public int getMax() {
		return max;
	}
	public void setMax(int max) {
		this.max = max;
	}
	public int getMin() {
		return min;
	}
	public void setMin(int min) {
		this.min = min;
	}
	public int getSum() {
		return sum;
	}
	public void setSum(int sum) {
		this.sum = sum;
	}

	public void setNumsList(List<Integer> list) {
		this.numsList=list;
	}
	public List<Integer> getNumsList(){
		return numsList;
	}

	public String getStr() {
		return str;
	}
	public void setStr(String str) {
		this.str = str;
	}

}
