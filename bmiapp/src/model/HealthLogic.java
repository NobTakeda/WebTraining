package model;

public class HealthLogic {

	public void execute(Health health) {
		double bmi=health.getWeight()/(health.getHeight()/100*health.getHeight()/100);
		health.setBmi(bmi);
		String bodyType;
		if(bmi < 18.5) {
			bodyType="痩せ型";
		}else if(bmi <25) {
			bodyType="普通";
		}else {
			bodyType="肥満";
		}
		health.setBodyType(bodyType);
	}
}
