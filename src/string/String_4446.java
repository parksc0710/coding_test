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
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		List<String> inStringList = new ArrayList<String>();
		String temp;

		while((temp = br.readLine() ) != null){
			inStringList.add(temp);
		}
		
		List<Character> vList = Arrays.asList(new Character[]{'a', 'i', 'y', 'e', 'o', 'u'});
		List<Character> cList  = Arrays.asList(new Character[]{'b', 'k', 'x', 'z', 'n', 'h', 'd', 'c', 'w', 'g', 'p', 'v', 'j', 'q', 't', 's', 'r', 'l', 'm', 'f'});
			
		System.out.println(vList.toString());
		System.out.println(cList.toString());

	}
}
