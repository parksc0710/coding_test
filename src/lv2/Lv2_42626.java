package lv2;

import java.io.IOException;
import java.util.PriorityQueue;

/**
 * 
 *  - 일시 : 2021년 07월 02일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42626
 *	  
 */
public class Lv2_42626 {
	public static void main(String[] args) throws IOException {
		
		int scoville[] = {10, 1, 2, 3, 9, 10, 12};
		int K = 7;
		Solution42626 tmp = new Solution42626();
		System.out.println(tmp.solution(scoville, K));

	}
}

class Solution42626 {
	public int solution(int[] scoville, int K) {
        int answer = 0;

        PriorityQueue<Integer> sQueue = new PriorityQueue<>();
        for(int i = 0; i < scoville.length; i++) {
        	sQueue.offer(scoville[i]);
        }
        	
        boolean isEnd = false;
        
        while(!sQueue.isEmpty()) {
        	if(sQueue.size() == 1) {
        		if(sQueue.poll() >= K) {
        			isEnd = true;
        		}
        		break;
        		
        	} else {
        		int tmpInt = sQueue.poll();
            	if(tmpInt >= K) {
            		isEnd = true;
            		break;
            	} else {
            		int tmpInt2 = sQueue.poll();
            		int newInt = tmpInt + tmpInt2*2;
            		sQueue.offer(newInt);
            		answer++;
            	}
        	}
        }
        
        return isEnd ? answer : -1;
    }
}
