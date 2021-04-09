package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12931
 *	  
 */
public class Lv1_12931 {
	public static void main(String[] args) throws IOException {
		
		int n = 123;
		Solution12931 tmp = new Solution12931();
		System.out.println(tmp.solution(n));

	}

}

class Solution12931 {
	public int solution(int n) {
        int answer = 0;
        String numString = String.valueOf(n);
        for(int i = 0; i < numString.length(); i++) {
        	answer += Integer.valueOf(String.valueOf(numString.charAt(i)));
        }
        return answer;
    }
}
 