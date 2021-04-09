package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12934
 *	  
 */
public class Lv1_12934 {
	public static void main(String[] args) throws IOException {
		
		long n = 121;
		Solution12934 tmp = new Solution12934();
		System.out.println(tmp.solution(n));

	}

}

class Solution12934 {
	public long solution(long n) {
		String tmpString = String.valueOf(Math.sqrt((double) n));
		long answer = 0;
		if(tmpString.split("\\.")[1].equals("0")) {
			answer = Long.valueOf(tmpString.split("\\.")[0]);
			answer = (answer+1)*(answer+1);
		} else {
			answer = -1;
		}
        return answer;
    }
}
 