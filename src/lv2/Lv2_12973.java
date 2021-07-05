package lv2;

import java.io.IOException;
import java.util.Stack;

/**
 * 
 *  - 일시 : 2021년 07월 02일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12973
 *	  
 */
public class Lv2_12973 {
	public static void main(String[] args) throws IOException {
		
		String s = "cdcd";
		Solution12973 tmp = new Solution12973();
		System.out.println(tmp.solution(s));

	}

}

class Solution12973 {
	public int solution(String s) {

        Stack<Character> stack = new Stack<Character>();
        
        for(int i = 0; i < s.length(); i++) {
        	char inChar = s.charAt(i);
        	if(stack.size() == 0) {
        		stack.add(inChar);
        	} else {
        		if(stack.peek() == inChar) {
        			stack.pop();
        		} else {
        			stack.add(inChar);
        		}
        	}
        }
        	
        return stack.size() > 0 ? 0 : 1;
    }
}
