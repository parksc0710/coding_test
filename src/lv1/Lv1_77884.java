package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 06월 22일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/77884
 *	  
 */
public class Lv1_77884 {
	public static void main(String[] args) throws IOException {
		
		int left = 13;
		int right = 17;
		Solution77884 tmp = new Solution77884();
		System.out.println(tmp.solution(left, right));

	}

}

class Solution77884 {
	public int solution(int left, int right) {
        int answer = 0;
        
        for(int i = left; i<=right; i++) {
        	int num = getAliquot(i);
        	if(num%2 == 0) {
        		answer = answer + i;
        	} else {
        		answer = answer - i;
        	}
        }
        
        return answer;
    }
	
	private int getAliquot(int n) {
		int cnt = 0;
		for(int i = 1; i <= n; i++) {
		    if (n % i == 0) {
		        cnt++; 
		    }
		} 
		return cnt;
	}
}
