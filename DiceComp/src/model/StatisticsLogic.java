package model;

public class StatisticsLogic {
	public void addData(Statistics stat,Dice dice) {
		//MaxThrowCountの更新処理
		if(dice.getCount()>stat.getMaxThrowCount()) {
			stat.setMaxThrowCount(dice.getCount());
		}
		//Mapの更新処理
		int count;
		if(stat.getMap().containsKey(dice.getCount())){
			count=stat.getMap().get(dice.getCount())+1;
		}else {
			count=1;
		}
		stat.getMap().put(dice.getCount(), count);
		//トータルカウントと平均の処理
		int totalCount=0;
		int sum=0;
		for(int compCount:stat.getMap().keySet()) {
			totalCount+=stat.getMap().get(compCount);
			sum+=compCount*stat.getFee()*stat.getMap().get(compCount);
		}
		stat.setTotalCount(totalCount);
		stat.setAve(sum/totalCount);
		int modeKey=0;
		int modeValue=0;
		for(int compCount:stat.getMap().keySet()) {
			if(modeValue<stat.getMap().get(compCount)) {
				modeValue=stat.getMap().get(compCount);
				modeKey=compCount;
			}
		}
		stat.setMode(modeKey);
	}
}