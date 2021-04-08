package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42862
 *	  
 */
public class Lv1_42862 {
	public static void main(String[] args) throws IOException {
		
		int n = 5;
		int[] lost = {1,2,3};
		int[] reserve = {2,3,4};
		Solution42862 tmp = new Solution42862();
		System.out.println(tmp.solution(n, lost, reserve));

	}

}

class Solution42862 {
	public int solution(int n, int[] lost, int[] reserve) {

        for(int i = 0; i < lost.length; i++) {
    		boolean isContinue = false;
        	
        	int lostNum = lost[i];
        	
        	
        	for(int j = 0; j < reserve.length; j++) {
        		if(lostNum == reserve[j]) {
        			lost[i] = 0;
        			reserve[j] = 0;
        			isContinue = true;
        		}
        	}

        	if(isContinue) {
        		continue;
        	}
        }
		
        for(int i = 0; i < lost.length; i++) {
        	
        	boolean isContinue = false;
        	
        	int lostNum = lost[i];
        	
        	for(int j = 0; j < reserve.length; j++) {
        		if(lostNum != 1 && lostNum-1 == reserve[j]) {
        			lost[i] = 0;
        			reserve[j] = 0;
        			isContinue = true;
        		}
        	}
        	
        	if(isContinue) {
        		continue;
        	}
        	
        	for(int j = 0; j < reserve.length; j++) {
        		if(lostNum != n && lostNum+1 == reserve[j]) {
        			lost[i] = 0;
        			reserve[j] = 0;
        		}
        	}
        }
    	
    	int lostCnt = 0;
    	for (int i = 0; i < lost.length; i++) {
    		if(lost[i] != 0) {
    			lostCnt++;
    		}
    	}
        
        return n-lostCnt;
    }
}

