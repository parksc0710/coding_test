package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12932
 *	  
 */
public class Lv1_12932 {
	public static void main(String[] args) throws IOException {
		
		int n = 12345;
		Solution12932 tmp = new Solution12932();
		System.out.println(tmp.solution(n));

	}

}

class Solution12932 {
	public int[] solution(long n) {
		String numString = String.valueOf(n);
        int[] answer = new int[numString.length()];
        for(int i = numString.length()-1; i > -1; i--) {
        	answer[numString.length()-1-i] = Integer.valueOf(String.valueOf(numString.charAt(i-1)));
        }
        return answer;
	}
}
 