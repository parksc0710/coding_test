package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12948
 *	  
 */
public class Lv1_12948 {
	public static void main(String[] args) throws IOException {
		
		String n = "01033334444";
		Solution12948 tmp = new Solution12948();
		System.out.println(tmp.solution(n));

	}

}

class Solution12948 {
	public String solution(String phone_number) {
        String answer = "";
        for(int i = 0; i < phone_number.length(); i++) {
        	if(i < phone_number.length()-4) {
        		answer += "*"; 
        	} else {
        		answer += phone_number.charAt(i);
        	}
        }
        return answer;
    }
}
 