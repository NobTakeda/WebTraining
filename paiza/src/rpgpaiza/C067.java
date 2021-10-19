package rpgpaiza;

import java.util.Scanner;

public class C067 {
	public static int[] henkan(int num) {
		int n=0;
		int bin[]=new int[16];
		while (num>=2) {
			bin[n]=num%2;
			n++;
			num=num/2;
		}
		bin[n]=num;
		n++;

		return bin;
	}
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] data=sc.nextLine().split(" ");
		int[] numData=new int[2];
		for(int i=0;i<2;i++) {
			numData[i]=Integer.parseInt(data[i]);
		}
		int[] kaisuuData=new int[numData[0]];
		for(int i=0;i<numData[0];i++) {
			String stringKaisuu=sc.nextLine();
			kaisuuData[i]=Integer.parseInt(stringKaisuu);
		}
		int[] answerNum=henkan(numData[1]);

		for(int i=0;i<numData[0];i++) {
			System.out.println(answerNum[kaisuuData[i]-1]);
		}

	}

}
