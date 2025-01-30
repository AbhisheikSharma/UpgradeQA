package javaProgs;

import java.util.Scanner;

public class R4 {
	public static void main(String[] args) {
		System.out.println("Enter number to check");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		R4 r4 = new R4();
		r4.isIt(num);
		sc.close();
	}
	public void isIt(int num) {
		boolean isPrime = true;
		for(int i=2;i<Math.sqrt(num);i++) {
			if(num%i==0) {
				isPrime=false;
				break;
			}
		}
		if(isPrime==false) {
			System.out.println("Not prime");
		}
		else {
			System.out.println("Prime");
		}
	}

}
