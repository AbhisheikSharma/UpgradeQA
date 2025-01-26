package javaProgs;

public class MaxDiffArray {
	public static void main(String[] args) {
		int [] arr = {35,29,24,15,12};
		int max = 0;
		for (int i=0;i<arr.length-1;i++) {
			int diff = arr[i]-arr[i+1];
			System.out.println("Diff found "+ diff);
			if(diff>max) {
				max=diff;
			}
		}
		System.out.println("Maximum difference is "+ max );
	}

}
