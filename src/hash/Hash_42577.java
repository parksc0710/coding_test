package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 *  - 일시 : 2021년 03월 24일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577
 *	  
 */
public class Hash_42577 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		String[] array = new String[st.countTokens()];
		
		int i = 0;
		while (st.hasMoreElements()) {
			array[i++] = st.nextToken().replaceAll("[\"\\[\\]]", "").trim();
		}
		
		Solution tmp = new Solution();
		System.out.println(tmp.solution(array));

	}

}

class Solution {
    public boolean solution(String[] phone_book) {
    	boolean answer = true;
    	// 배열 오름차순 정렬
    	Arrays.sort(phone_book);
    	for(int i = 0; i < phone_book.length; i++) {
    		if(i < phone_book.length-1 && phone_book[i+1].indexOf(phone_book[i]) == 0) {
    			answer = false;
    			break;
    		}
    	}
        return answer;
    }
}
