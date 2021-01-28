package model;

public class LoginLogic {
	public boolean execute(Health health) {
		if(health.getPass().equals("1234")) {
			return true;
		}
		return false;
	}
}