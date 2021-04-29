package lv1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  - 일시 : 2021년 04월 29일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/76501
 *	  
 */
public class Lv1_76501 {
	public static void main(String[] args) throws IOException {
		
		int[] absolutes = {4,7,12};
		boolean[] signs = {true, false, true};
		Solution76501 tmp = new Solution76501();
		System.out.println(tmp.solution(absolutes, signs));

	}

}

class Solution76501 {
	public int solution(int[] absolutes, boolean[] signs) {
		int answer = 0;
		
		int[] newInt = new int[absolutes.length];
		
		for(int i = 0; i < absolutes.length; i++) {
			if(signs[i]) {
				newInt[i] = absolutes[i];
			} else {
				newInt[i] = absolutes[i] * -1;
			}
		}
		
		for(int i = 0; i < newInt.length; i++) {
			answer += newInt[i];
		}
		return answer;
	}
}
