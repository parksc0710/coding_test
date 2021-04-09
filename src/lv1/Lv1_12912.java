package lv1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12918
 *	  
 */
public class Lv1_12912 {
	public static void main(String[] args) throws IOException {
		int a = 5;
		int b = 3;
		Solution12912 tmp = new Solution12912();
		System.out.println(tmp.solution(a, b));
	}

}

class Solution12912 {
	public long solution(int a, int b) {
        long answer = 0;
        int sNum = a > b ? b : a;
        int eNum = a <= b ? b : a;
        for(int i = sNum; i <= eNum; i++) {
        	answer += i;
        }
        return answer;
    }
}
