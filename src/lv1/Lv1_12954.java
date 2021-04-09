package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12954
 *	  
 */
public class Lv1_12954 {
	public static void main(String[] args) throws IOException {
		
		int x = 2;
		int n = 5;
		Solution12954 tmp = new Solution12954();
		System.out.println(tmp.solution(x, n));

	}

}

class Solution12954 {
	public long[] solution(long x, int n) {
        long[] answer = new long[n];
        for(int i = 0; i < n; i++) {
        	answer[i] = x*(i+1);
        }
        return answer;
    }
}
 