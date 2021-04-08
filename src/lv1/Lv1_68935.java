package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/68935
 *	  
 */
public class Lv1_68935 {
	public static void main(String[] args) throws IOException {
		
		int a = 125;
		Solution68935 tmp = new Solution68935();
		System.out.println(tmp.solution(a));

	}

}

class Solution68935 {
	public int solution(int n) {
		int answer = 0;
		String textNum = "";
		while(n/3 != 0) {
			textNum += String.valueOf(n%3);
			n = n/3;
		}
		textNum += String.valueOf(n);
		
		int maxPower = textNum.length()-1;
		
		while(maxPower >= 0) {
			String tmpNum = String.valueOf(textNum.charAt(textNum.length() - 1 - maxPower));
			answer += Integer.valueOf(tmpNum)*Math.pow(3, maxPower);
			maxPower--;
		}
		
		return answer;
    }
}
