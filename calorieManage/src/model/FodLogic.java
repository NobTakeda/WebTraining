package model;

import java.util.List;

public class FodLogic {

	public void execute(List<Food> list,FoodOfDay fod) {
		int breakfastCal=0;
		int lunchCal=0;
		int supperCal=0;
		int totalCal=0;

		for(int i=0;i<list.size();i++) {
			switch(list.get(i).getTime()) {
			case 0:
				breakfastCal+=list.get(i).getCal();
				break;
			case 1:
				lunchCal+=list.get(i).getCal();
				break;
			case 2:
				supperCal+=list.get(i).getCal();
				break;
			}
		}
		totalCal=breakfastCal+lunchCal+supperCal;
		fod.setBreakfastCal(breakfastCal);
		fod.setLunchCal(lunchCal);
		fod.setSupperCal(supperCal);
		fod.setTotalCal(totalCal);
	}
}
