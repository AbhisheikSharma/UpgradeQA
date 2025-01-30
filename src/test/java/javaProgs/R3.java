package javaProgs;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;

public class R3 {
	public static void main(String[] args) {
		int arr[] = {10,10,20,30,40,40,50};
		Map<Integer, Integer> mymap = new LinkedHashMap<>();
		for(int i=0;i<arr.length;i++) {
			mymap.put(arr[i], arr[i]);		}
		for(Entry<Integer,Integer> entry:mymap.entrySet()) {
			System.out.println(entry.getValue());
		}
	}

}
