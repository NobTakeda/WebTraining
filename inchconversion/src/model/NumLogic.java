package model;

public class NumLogic{
	public void execute(Num num,String org) {

		double cm=0;
		double inch=Double.parseDouble(org);
		num.setInch(inch);
		cm=inch*2.54;
		num.setCm(cm);


	}
}
