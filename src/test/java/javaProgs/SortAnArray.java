package javaProgs;

public class SortAnArray {
	public static void main(String[] args) {
		int [] arr = {12,15,1,8,13};
		SortAnArray sa = new SortAnArray();
		sa.sortingArray(arr);
	}
	public void sortingArray(int [] arr) {
		int tmp;
		for(int i=0;i<arr.length-1;i++) {
			
			for(int j=i+1;j<arr.length;j++) {
				if(arr[i]>arr[j]) {
					tmp = arr[i];
					arr[i]=arr[j];
					arr[j]=tmp;
				
					/* ANY APPROACH IS FINE
					 * tmp= arr[j]; arr[j]=arr[i]; arr[i]=tmp;
					 */
				}
			}
		}
			System.out.println("Sorted array is");
			for(int i=0;i<arr.length;i++) {
				System.out.print(arr[i]+" ");
		}
	}

}
