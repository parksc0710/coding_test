package lv1;

import java.io.IOException;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12916
 *	  
 */
public class Lv1_12916 {
	public static void main(String[] args) throws IOException {
		String s = "Pyy";
		Solution12916 tmp = new Solution12916();
		System.out.println(tmp.solution(s));
	}

}

class Solution12916 {
	boolean solution(String s) {
		boolean answer = true;
		
		s = s.toLowerCase();
		StringBuilder sNew = new StringBuilder(s);
		int pNum = 0;
		int yNum = 0;
		
		while(sNew.indexOf("p") > -1) {
			sNew.setCharAt(sNew.indexOf("p"), '_');
			pNum++;
		}
		
		while(sNew.indexOf("y") > -1) {
			sNew.setCharAt(sNew.indexOf("y"), '_');
			yNum++;
		}
		
		if(pNum == 0 && yNum == 0) {
			answer = true;
		} else if(pNum == yNum) {
			answer = true;
		} else if(pNum != yNum) {
			answer = false;
		}
		
        return answer;
    }
}
