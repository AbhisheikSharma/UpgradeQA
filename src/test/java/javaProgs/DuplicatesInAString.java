package javaProgs;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class DuplicatesInAString {
	
	public static void main(String[] args) {
		String str = "ThisIsDuplicateCalculatorProgram";
		DuplicatesInAString dis = new DuplicatesInAString();
		dis.findDuplicatesAndCounts(str);
	}
	
	public void findDuplicatesAndCounts(String str) {
		str=str.toLowerCase();
		Map<Character,Integer>mymap = new HashMap<>();
		for(char c:str.toCharArray()) {
			mymap.put(c, mymap.getOrDefault(c, 0)+1);
		}
		for(Entry<Character,Integer> entry: mymap.entrySet()) {
			if(entry.getValue()>1 ) {
				System.out.println(entry.getKey() +"-->"+ entry.getValue());
							}
		}
		
	}

}
