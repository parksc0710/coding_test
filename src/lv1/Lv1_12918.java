package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12918
 *	  
 */
public class Lv1_12918 {
	public static void main(String[] args) throws IOException {
		
		String s = "a234";
		Solution12918 tmp = new Solution12918();
		System.out.println(tmp.solution(s));

	}

}

class Solution12918 {
	public boolean solution(String s) {
        boolean answer = false;
        if((s.length() == 4 || s.length() == 6) && s.matches("[0-9]+")) {
        	answer = true;
        }
        return answer;
    }
}
