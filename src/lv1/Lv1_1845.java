package lv1;

import java.io.IOException;
import java.util.HashSet;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12918
 *	  
 */
public class Lv1_1845 {
	public static void main(String[] args) throws IOException {
		int[] nums = {3,3,3,2,2,4};
		Solution1845 tmp = new Solution1845();
		System.out.println(tmp.solution(nums));
	}

}

class Solution1845 {
	public int solution(int[] nums) {
        int answer = 0;
        int pickNum = nums.length / 2;
        Set<Integer> numsSet = new HashSet<Integer>();
        for(int i = 0; i < nums.length; i++) {
        	numsSet.add(nums[i]);        	
        }
        if(numsSet.size() < pickNum) {
        	answer = numsSet.size();
        } else {
        	answer = pickNum;
        }
        return answer;
    }
}
