package string;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 03월 05일
 *  - 링크 : https://www.acmicpc.net/problem/4446
 *	  
 */
public class String_4446 {
	
	static List<Character> vList = Arrays.asList(new Character[]{'a', 'i', 'y', 'e', 'o', 'u'});
	static List<Character> cList  = Arrays.asList(new Character[]{'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'});
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> inStringList = new ArrayList<String>();
		String temp;

		while((temp = br.readLine() ) != null){
			inStringList.add(temp);
		}
		
		
		for(int i = 0; i < inStringList.size(); i++) {
			System.out.println(decoding(inStringList.get(i)));
		}

	}
	
	static String decoding(String before) {
		
		String rtnString = "";
		
		for(int i = 0; i < before.length(); i++) {
			
			boolean isUpperCase = false;
			
			Character tmpChar = before.charAt(i);
			if(Character.isLetter(tmpChar)) {
				if(vList.contains(Character.toLowerCase(tmpChar))) {
					
					if(Character.isUpperCase(tmpChar)) {
						isUpperCase = true;
					}
					int tmpIndex = vList.indexOf(Character.toLowerCase(tmpChar));
					int afterInex = tmpIndex + 3 > vList.size()-1 ? tmpIndex - 3 : tmpIndex + 3;
					
					if(isUpperCase) {
						rtnString += String.valueOf(Character.toUpperCase(vList.get(afterInex)));
					} else {
						rtnString += String.valueOf(vList.get(afterInex));
					}
					
				} else if(cList.contains(Character.toLowerCase(tmpChar))) {
					if(Character.isUpperCase(tmpChar)) {
						isUpperCase = true;
					}
					int tmpIndex = cList.indexOf(Character.toLowerCase(tmpChar));
					int afterInex = tmpIndex + 10 > cList.size()-1 ? tmpIndex - 10 : tmpIndex + 10;
					
					if(isUpperCase) {
						rtnString += String.valueOf(Character.toUpperCase(cList.get(afterInex)));
					} else {
						rtnString += String.valueOf(cList.get(afterInex));
					}
				}
			} else {
				rtnString += tmpChar;
			}
		}
		
		return rtnString;
	}
}
