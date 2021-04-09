package lv1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/70128
 *	  
 */
public class Lv1_70128 {
	public static void main(String[] args) throws IOException {
		int[] a = {1,2,3,4};
		int[] b = {-3,-1,0,2};
		Solution70128 tmp = new Solution70128();
		System.out.println(tmp.solution(a, b));
	}

}

class Solution70128 {
	public int solution(int[] a, int[] b) {
		int answer = 0;
		for(int i = 0; i < a.length; i++) {
			answer += a[i]*b[i];
		}
        return answer;
    }
}
