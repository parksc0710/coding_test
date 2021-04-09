package lv1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 10일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12977
 *	  
 */
public class Lv1_12977 {
	public static void main(String[] args) throws IOException {
		
		int[] nums = {1,2,3,4};
		Solution12977 tmp = new Solution12977();
		System.out.println(tmp.solution(nums));

	}

}

class Solution12977 {
	public int solution(int[] nums) {
        int answer = 0;
        
        for(int i = 0; i < nums.length; i++) {
        	for(int j = i+1; j < nums.length; j++) {
        		for(int k = j+1; k < nums.length; k++) {
        			int tmpNum = nums[i] + nums[j] + nums[k];
        			if(checkPrimeNum(tmpNum)) {
                		answer++;
                	}
        		}
        	}
        }

        return answer;
    }
	
	private boolean checkPrimeNum(int num) {
		int i = num-1;
		while(i > 1) {
			if(num%i == 0) {
				break;
			}
			i--;
		}
		boolean rtn = i > 1 ? false : true;
		return rtn;
	}
}
