package javaProgs;

import java.util.Scanner;

public class AcceptArrayAndSum {
	public static void main(String[] args) {
		int [] arr;
		System.out.println("Enter size of array ");
		Scanner sc = new Scanner(System.in);
		int size = sc.nextInt();
		arr = new int[size];
		System.out.println("Enter the "+size+" integer elements of your choice");
		for(int i=0;i<size;i++) {
			arr[i] = sc.nextInt();
		}
		AcceptArrayAndSum a = new AcceptArrayAndSum();
		int total = a.sumUp(arr);
		System.out.println("Total of all elements you entered is "+ total);
		sc.close();
		
	}
	
	public int sumUp(int [] ar) {
		int sum = 0;
		for(int i=0;i<ar.length;i++) {
			sum+=ar[i];
		}
		return sum;
	}

}
