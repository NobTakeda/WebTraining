package model;

public class NumbersLogic {

	public void makeArray(String str,Numbers numbers) {
		String[] strs=str.split(",");
		for(String n:strs) {
			int num=Integer.parseInt(n);
			numbers.getNumsList().add(num);
		}
	}
	public void makeMax(Numbers numbers) {
		int max=numbers.getNumsList().get(0);
		for(int i=1;i<=numbers.getNumsList().size()-1;i++) {
			if(max<numbers.getNumsList().get(i)) {
				max=numbers.getNumsList().get(i);
			}
		}
		numbers.setMax(max);;
	}
	public void makeMin(Numbers numbers) {
		int min=numbers.getNumsList().get(0);
		for(int i=1;i<=numbers.getNumsList().size()-1;i++) {
			if(min>numbers.getNumsList().get(i)) {
				min=numbers.getNumsList().get(i);
			}
		}
		numbers.setMin(min);
	}
	public void makeSum(Numbers numbers) {
		int sum=0;
		for(int i=0;i<numbers.getNumsList().size();i++) {
			sum+=numbers.getNumsList().get(i);
		}
		numbers.setSum(sum);
	}
}
