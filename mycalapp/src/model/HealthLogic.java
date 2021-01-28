package model;

public class HealthLogic {

	public void checkBmi(Health health,double height,double weight) {
		double bmi=weight/((height/100)*(height/100));
		bmi=((double)Math.round(bmi * 10))/10;
		health.setBmi(bmi);

		int gender=health.getGender();
		if(gender==1) {
			health.setCal(2400);
		}else {
			health.setCal(1800);
		}
	}
}
