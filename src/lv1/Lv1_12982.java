package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 12일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12982
 *	  
 */
public class Lv1_12982 {
	public static void main(String[] args) throws IOException {
		int[] d = {2,2,3,3};
		int budget = 10;
		Solution12982 tmp = new Solution12982();
		System.out.println(tmp.solution(d, budget));
	}

}

class Solution12982 {
	
	public int solution(int[] d, int budget) {
		Arrays.sort(d);
		int answer = 0;
        for(int i = 0; i < d.length; i++) {
        	if(budget > 0) {
        		if(budget>=d[i]) {
        			budget = budget-d[i];
        			answer++;
        		} 
        	}
        }
        return answer;
    }

}


