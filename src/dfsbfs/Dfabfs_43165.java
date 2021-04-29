package dfsbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 27일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/43165
 *	  
 */
public class Dfabfs_43165 {
	public static void main(String[] args) throws IOException {
		
		int[] numbers = {1,1,1,1,1};
		int target = 3;
		Solution43165 tmp = new Solution43165();
		System.out.println(tmp.solution(numbers, target));

	}

}

class Solution43165 {
	public int solution(int[] numbers, int target) {
        int answer = 0;
        
        int index = 0;
        
        while(index < numbers.length) {
        	int[] tmp = numbers;
        	
        	index++;
        }
        
        return answer;
    }
}
