package javaProgs;

import java.util.Scanner;

public class Palindrome {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string to check ");
		String str = sc.next();
		sc.close();
		String revstr="";
		for(int i=str.length()-1;i>=0;i--) {
			revstr+=str.charAt(i);
		}
		if(revstr.equalsIgnoreCase(str)) {
			System.out.println("Palindrome");
		}
		else {
			System.out.println("Nope");
		}
	}

}
