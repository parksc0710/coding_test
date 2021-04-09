package lv1;

import java.io.IOException;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12930
 *	  
 */
public class Lv1_12930 {
	public static void main(String[] args) throws IOException {
		String s = "try hello world";
		Solution12930 tmp = new Solution12930();
		System.out.println(tmp.solution(s));
	}

}

class Solution12930 {
	public String solution(String s) {
		String answer = "";
		
		String[] sSplit = s.split(" ", -1);
		
		for(int i = 0; i < sSplit.length; i++) {
			StringBuilder sNew = new StringBuilder(sSplit[i]);
			int j = 0;
			while(j < sNew.length()) {
				char tmp = sNew.charAt(j);
				if(j%2 == 0) {
					sNew.setCharAt(j, Character.toUpperCase(tmp));
				} else if(j%2 == 1){
					sNew.setCharAt(j, Character.toLowerCase(tmp));
				}
				j++;
			}
			if(i == sSplit.length-1) {
				answer += sNew.toString();
			} else {
				answer += sNew.toString() + " ";
			}
		}
		
        return answer;
    }
}
