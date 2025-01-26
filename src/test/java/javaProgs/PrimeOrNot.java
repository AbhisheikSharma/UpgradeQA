package javaProgs;

import java.util.Scanner;

public class PrimeOrNot {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter a number > 1 to check for prime ");
		int num = sc.nextInt();
		sc.close();
		
		boolean prime = true;
		for(int i=2;i<=Math.sqrt(num);i++) {
			if(num%i==0) {
				prime = false;
				break;
			}		
		}
		if(prime) {
			System.out.println("Number is prime");
		}
			else {
				System.out.println("Number is not prime");
			}
		}
}
