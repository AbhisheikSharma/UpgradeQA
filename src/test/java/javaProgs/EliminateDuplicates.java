package javaProgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class EliminateDuplicates {
	
public static void main(String[] args) {
	int [] arr = {10,20,20,30,40,40,50};
	Map<Integer,Integer> mymap = new HashMap<>();
	for(int i=0;i<arr.length;i++) {
		mymap.put(arr[i], arr[i]);
	}
	System.out.println("Size of map is "+ mymap.size());
	for(Entry<Integer,Integer> entry: mymap.entrySet()) {
		System.out.println(entry.getValue());
	}
}

}
