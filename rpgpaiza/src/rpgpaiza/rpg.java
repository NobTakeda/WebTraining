package rpgpaiza;

import java.util.Scanner;

public class rpg {
	public static void main(String[] args) {
	    Scanner sc=new Scanner(System.in);
	    int itemNum=sc.nextInt(); sc.nextLine();
	    String itemstr=sc.nextLine();
	    String[] itemPriceStrs=itemstr.split(" ");
	    int[] itemPrices=new int[itemPriceStrs.length];
	    for(int i=0;i<itemPriceStrs.length;i++) {
	    	itemPrices[i]=Integer.parseInt(itemPriceStrs[i]);
	    //itemNum=道具の種類数
	    //itemNum1の値段をitemPrices[0]に格納
	    }
	    String walletStr=sc.nextLine();
	    String[] walletStrs=walletStr.split(" ");
	    int wallet=Integer.parseInt(walletStrs[0]);
	    int orderNum=Integer.parseInt(walletStrs[1]);
	    //初期金額をwallet、注文数をorderNumとする

	    for(int k=0;k<orderNum;k++) {
	    	String list=sc.nextLine();
	    	String[] nums=list.split(" ");
	    	int sum=0;
	    	for(int j=0;j<itemNum;j++) {
	    		if(Integer.parseInt(nums[0])==j) {
	    			sum=itemPrices[j-1]*Integer.parseInt(nums[1]);
	    		}
	    		if(wallet>=sum) {
	    			wallet-=sum;
	    		}
	    	}
	    }
	    System.out.println(wallet);
	}
}
