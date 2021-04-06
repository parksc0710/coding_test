package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 *  - 일시 : 2021년 04월 06일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/72410
 *	  
 */
public class Lv1_72410 {
	public static void main(String[] args) throws IOException {
		
		String inString = "=.=";
		Solution72410 tmp = new Solution72410();
		System.out.println(tmp.solution(inString));

	}

}

class Solution72410 {
    public String solution(String new_id) {
        String answer = new_id.toLowerCase();
        answer = answer.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        answer = answer.replaceAll("[\\\\.]{2,}", "\\.");
        if(answer.charAt(0) == '.' && answer.length() != 0) {
        	answer = answer.substring(1, answer.length());
        }
        if(answer.length() != 0 && answer.charAt(answer.length()-1) == '.') {
    		answer = answer.substring(0, answer.length()-1);
    	} 
        if(answer.length() == 0) {
        	answer = "a";
        }
        if(answer.length() >= 16) {
        	answer = answer.substring(0, 15);
        	while(answer.charAt(answer.length()-1) == '.') {
        		answer = answer.substring(0, answer.length()-1);
        	}
        }
        while(answer.length() <= 2) {
        	answer = answer + answer.charAt(answer.length()-1); 
        }
        return answer;
    }
}
