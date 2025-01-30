package javaProgs;

import java.util.HashMap;
import java.util.Map;

public class R5 {
	public static void main(String[] args) {
		String str = "wfjjdfnlwfpkqjlerglfgkljnerg";
		R5 r5 = new R5();
		r5.dupli(str);
	}
	public void dupli(String str) {
		str = str.toLowerCase();
		Map<Character,Integer> mymap = new HashMap<>();
		for(char c:str.toCharArray()) {
			mymap.put(c, mymap.getOrDefault(c,0)+1);
		}
	}

}
