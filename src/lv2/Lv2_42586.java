package lv2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *  - 일시 : 2021년 07월 5일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42586
 *	  
 */
public class Lv2_42586 {
	public static void main(String[] args) throws IOException {
		
		int[] progresses = {93, 30, 55};
		int[] speeds = {1, 30, 5};
		Solution12901 tmp = new Solution12901();
		System.out.println(tmp.solution(progresses, speeds));

	}

}

class Solution12901 {
	public int[] solution(int[] progresses, int[] speeds) {
		
		Queue<Integer> pQueue = new LinkedList<Integer>();
		for (int i = 0; i < progresses.length; i++) {
			pQueue.add(progresses[i]);
		}
		
		Queue<Integer> sQueue = new LinkedList<Integer>();
		for (int i = 0; i < speeds.length; i++) {
			sQueue.add(speeds[i]);
		}
	    
		List<Integer> answerList = new ArrayList<Integer>();
		
        int days = 1;
        int complete = 0;
        
        while(pQueue.size() > 0) {
        	while(pQueue.size() > 0 && pQueue.peek() + sQueue.peek() * days >= 100) {
        		pQueue.poll();
        		sQueue.poll();
        		complete++;
        	}
        	if(complete > 0) {
        		answerList.add(complete);
        		complete = 0;
        	}
        	days++;
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}

