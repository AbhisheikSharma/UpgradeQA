package javaProgs;

public class R2 {
	public static void main(String[] args) {
		int arr[] = {10,12,17,29,36};
		int maxdiff = 0;
		for(int i=0;i<arr.length-1;i++) {
				int tmp=arr[i+1]-arr[i];
				if(tmp>maxdiff) {
					maxdiff=tmp;
				}
			}
		System.out.println("maxdiff: "+ maxdiff);
	}

}
