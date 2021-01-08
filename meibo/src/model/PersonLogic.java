package model;

public class PersonLogic {
	public void execute(Person person,String[] org) {
		person.setName(org[0]);
		person.setHurigana(org[1]);
		person.setGender(org[2]);
		person.setBloodtype(org[3]);

	}
}
