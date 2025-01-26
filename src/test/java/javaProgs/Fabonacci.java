package javaProgs;

public class Fabonacci {
	public static void main(String[] args) {
		int i=1,j=2;
		int tmp;
		System.out.println(i+" ");
		System.out.println(j+" ");
		for (int x=0;x<5;x++) {
			tmp=i+j;
			System.out.println(tmp+" ");
			i=j;
			j=tmp;
		}
	}

}
