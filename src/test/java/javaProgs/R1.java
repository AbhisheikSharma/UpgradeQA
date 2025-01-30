package javaProgs;

import java.util.Scanner;

public class R1 {
	public static void main(String[] args) {
		System.out.println("Enter the array length desired ");
		Scanner sc = new Scanner(System.in);
				int length = sc.nextInt();
				//sc.close();
				int [] arr = new int[length];
				System.out.println("Enter the elements");
				for(int i=0;i<arr.length;i++) {
					arr[i]=sc.nextInt();
				}
				sc.close();
				R1 ri = new R1();
				System.out.println("Sum of elements is "+ ri.sumUp(arr));
	}
	public int sumUp(int arr[]) {
		int sum=0;
		for(int i=0;i<arr.length;i++) {
			sum+=arr[i];
		}
		return sum;
	}

}
