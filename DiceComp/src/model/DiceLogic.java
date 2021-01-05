package model;

public class DiceLogic {
	public void throwDice(Dice dice) {
		final int fee=300;
		int index=(int)(Math.random()*6);

		//statesチェック(0:一度も出ていない,1:初めて出た,2以上:過去に出た)
		int[] states=dice.getDiceStates();
		//前回初めてだった目を過去にステートを変える
		for(int i=0;i<states.length;i++) {
			if(states[i]==1) {
				states[i]=2;
			}
		}
		states[index]++;
		dice.setDiceStates(states);
		dice.setNowDice(index+1);
		dice.setCount(dice.getCount()+1);
		dice.setTotal(dice.getTotal()+fee);
		String msg=String.format("Count:%d Total:%d", dice.getCount(),dice.getTotal());
		//完了チェック
		boolean isFinished=true;
		//全てのsutateをチェックして0があった場合は未完了
		for(int n:dice.getDiceStates()) {
			if(n==0) {
				isFinished=false;
				break;
			}
		}
		if(isFinished) {
			msg+="Complete! Try again!";
		}
		dice.setMsg(msg);
	}

}
