package model;

import java.io.Serializable;
import java.util.List;

public class RankingResult implements Serializable{
	private int lastId; //最後に挿入したデータのid
	private int rank; //最後に挿入したデータの順位
	private List<Score> list; //順位データを降順ソートしたリスト
	private boolean isRankingIn; //指定順位に入っているか

	public RankingResult() {}

	public int getLastId() {
		return lastId;
	}
	public void setLastId(int lastId) {
		this.lastId = lastId;
	}
	public int getRank() {
		return rank;
	}
	public void setRank(int rank) {
		this.rank = rank;
	}
	public List<Score> getList() {
		return list;
	}
	public void setList(List<Score> list) {
		this.list = list;
	}
	public boolean isRankingIn() {
		return isRankingIn;
	}
	public void setRankingIn(boolean isRankingIn) {
		this.isRankingIn = isRankingIn;
	}

}
