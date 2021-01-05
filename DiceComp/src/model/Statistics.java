package model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Statistics implements Serializable{
	private final int fee=300;
	private Map<Integer,Integer> map=new TreeMap<>();
	private int maxThrowCount;
	private int totalCount;
	private int ave;
	private int mode;
	public Map<Integer, Integer> getMap() {
		return map;
	}
	public void setMap(Map<Integer, Integer> map) {
		this.map = map;
	}
	public int getMaxThrowCount() {
		return maxThrowCount;
	}
	public void setMaxThrowCount(int maxThrowCount) {
		this.maxThrowCount = maxThrowCount;
	}
	public int getAve() {
		return ave;
	}
	public void setAve(int ave) {
		this.ave = ave;
	}
	public int getMode() {
		return mode;
	}
	public void setMode(int mode) {
		this.mode = mode;
	}
	public int getFee() {
		return fee;
	}
	public int getTotalCount() {
		return totalCount;
	}
	public void setTotalCount(int totalCount) {
		this.totalCount = totalCount;
	}
}
