package model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GladiatorLogic {

	private List<String> msgs=new ArrayList<>();
	private int diff;

	public GladiatorLogic() {
		for(int i=0;i<4;i++) {
			msgs.add("");
		}
	}

	public void execute(Gladiator gladiator,String name) {
		int seed=0;
		for(int i=0;i<name.length();i++) {
			seed+=name.charAt(i);
		}
		Random rand=new Random(seed);
		int hp=rand.nextInt(51)+50;
		int pow=rand.nextInt(81);
		int speed=80-pow;
		pow+=20;
		speed+=20;
		gladiator.setName(name);
		gladiator.setHp(hp);
		gladiator.setPow(pow);
		gladiator.setSpeed(speed);
	}
	public void setEnemy(Gladiator gladiator) {
		int type=new Random().nextInt(3);
		switch(type) {
		case 0:
			gladiator.setName("タフ右衛門");
			gladiator.setHp(180);
			gladiator.setPow(50);
			gladiator.setSpeed(20);
			break;
		case 1:
			gladiator.setName("剛力之介");
			gladiator.setHp(130);
			gladiator.setPow(90);
			gladiator.setSpeed(30);
			break;
		case 2:
			gladiator.setName("韋駄天の虎");
			gladiator.setHp(50);
			gladiator.setPow(50);
			gladiator.setSpeed(130);
			break;
		}
	}
	public void keenConpetition(Gladiator offense,Gladiator defense) {
		msgs.set(1,offense.getName()+"と"+defense.getName()+"は剣を振りあげた！");
		msgs.set(2,"お互いの剣がぶつかり、激しい音をたてた！");
		msgs.set(3, "二人の剣闘士はお互いの隙を伺っている…");
	}
	public void parry(Gladiator offense,Gladiator defense) {
		Random rand=new Random();
		//100を上限とするparryとdefense側のpowで受け流し判定
		int defenseP=defense.getPow()+15;
		int parry=rand.nextInt(99)+1;
		msgs.set(1,offense.getName()+"の攻撃！ "+defense.getName()+"は攻撃を受け流そうとした！");
		if(parry<defenseP) {
			msgs.set(2,"受け流し成功！ "+offense.getName()+"は体勢を崩してしまった！");
			msgs.set(3,defense.getName()+"は追撃した！ "+defense.getPow()+"ポイントのダメージを与えた！");
			offense.setHp(offense.getHp()-defense.getPow());
			if(offense.getHp()<0) {
				offense.setHp(0);
			}
		}else {
			msgs.set(2, "受け流し失敗！ "+defense.getName()+"は攻撃を受けてしまった！");
			msgs.set(3, defense.getName()+"は"+offense.getPow()+"ポイントのダメージを受けた！");
			defense.setHp(defense.getHp()-offense.getPow());
			if(defense.getHp()<0) {
				defense.setHp(0);
			}
		}
	}
	public void dodge(Gladiator offense,Gladiator defense) {
		Random rand=new Random();
		//100を上限とするdodgeとdefense側のspeedで回避判定
		int defenseP=defense.getSpeed()+15;
		int dodge=rand.nextInt(99)+1;
		msgs.set(1, offense.getName()+"は剣を振りあげた！");
		msgs.set(2, defense.getName()+"は攻撃をかわそうとした！");
		if(dodge<defenseP) {
			msgs.set(3, defense.getName()+"は回避に成功した！");
		}else {
			msgs.set(3, "回避失敗！"+defense.getName()+"は"+offense.getPow()+"ポイントのダメージを受けた！");
			defense.setHp(defense.getHp()-offense.getPow());
			if(defense.getHp()<0) {
				defense.setHp(0);
			}
		}
	}
	public void glaring() {
		msgs.set(1, "二人の剣闘士は共に攻撃を受け流そうとしている！");
		msgs.set(2, "奇しくも睨み合いになってしまったようだ");
		msgs.set(3, "");
	}
	public void step(Gladiator offense,Gladiator defense) {
		msgs.set(1, offense.getName()+"は攻撃をかわそうとステップを踏んでいる");
		msgs.set(2, defense.getName()+"は攻撃を受け流そうと構えている");
		msgs.set(3, "……しばしの時間が過ぎてしまった。");
	}
	public void dance() {
		msgs.set(1, "二人の剣闘士は攻撃をかわそうとステップを踏んでいる");
		msgs.set(2, "…………");
		msgs.set(3, "まるで踊っているようだ！");
	}
	public void fight(Gladiator player,Gladiator enemy) {
		int actionP=player.getAction();
		int actionE=enemy.getAction();
		//speedで先制判定
		if(player.getSpeed()<enemy.getSpeed()) {
			//enemyのスピードが早い時
			msgs.set(0,enemy.getName()+"が先に行動した！");
			switch(actionE) {
			case 1:
				//enemyが攻撃を選択
				if(player.getAction()==1) {
					keenConpetition(enemy,player);
				}else if(player.getAction()==2){
					parry(enemy,player);
				}else {
					dodge(enemy,player);
				}
				break;
			case 2:
				//enemyが受け流しを選択
				if(player.getAction()==1) {
					parry(player,enemy);
				}else if(player.getAction()==2){
					glaring();
				}else {
					step(enemy,player);
				}
				break;
			case 3:
				//enemyが回避を選択
				if(player.getAction()==1) {
					dodge(player,enemy);
				}else if(player.getAction()==2) {
					step(enemy,player);
				}else {
					dance();
				}
				break;
			}
		}else{
			//playerのスピードが早い時
			msgs.set(0,player.getName()+"が先に行動した！");
			switch(actionP) {
			case 1:
				//playerが攻撃を選択
				if(actionE==1) {
					keenConpetition(player,enemy);
				}else if(actionE==2) {
					parry(player,enemy);
				}else {
					dodge(player,enemy);
				}
				break;
			case 2:
				//playerが受け流しを選択
				if(actionE==1) {
					parry(enemy,player);
				}else if(actionE==2) {
					glaring();
				}else {
					step(enemy,player);
				}
				break;
			case 3:
				//playerが回避を選択
				if(actionE==1) {
					dodge(enemy,player);
				}else if(actionE==2) {
					step(enemy,player);
				}else {
					dance();
				}
				break;
			}
		}
	}

	public int getDiff() {
		return diff;
	}

	public void setDiff(int diff) {
		this.diff = diff;
	}

	public List<String> getMsgs() {
		return msgs;
	}

	public void setMsgs(int index,String msg) {
		msgs.set(index,msg);
	}

}
