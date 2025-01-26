package javaProgs;

import java.util.Scanner;

public class MultiplyWithoutMultiply {
	public static void main(String[] args) {
		System.out.println("ENter the number for which you want the table:");
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		int sum=0;
		
		for(int i=1;i<=10;i++) {
			sum+=num;
			System.out.println(num + " * "+ i+" = "+sum);
		}
		sc.close();
	}

}
