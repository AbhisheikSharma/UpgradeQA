package javaProgs;

import java.util.Scanner;

public class SwapWithoutTmp {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int a=sc.nextInt();
		int b=sc.nextInt();
		a = a+b; //a = 15
		b = a-b;//b = 10;
		a = a-b;//a = 5;
		System.out.println("a after swap= "+ a);
		System.out.println("b after swap= "+ b);
sc.close();
	}

}
