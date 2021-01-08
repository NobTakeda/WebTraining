package model;

import java.util.List;

public class ProductLogic {
	public void makeSum(Product product,List<Product> list) {
		int sum=0;
		if(list.size()>1) {
			sum=product.getPrice()+list.get(1).getSum();
			product.setSum(sum);
		}else {
			sum=product.getPrice();
		}
		product.setSum(sum);
	}
}
