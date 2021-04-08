package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42840
 *	  
 */
public class Lv1_42840 {
	public static void main(String[] args) throws IOException {
		
		int[] inArr = {1,3,2,4,2};
		Solution42840 tmp = new Solution42840();
		System.out.println(Arrays.toString(tmp.solution(inArr)));

	}

}

class Solution42840 {
	public Integer[] solution(int[] answers) {
		
		List<Integer> rtnList = new ArrayList<Integer>();
		
        int[] answer = new int[3];
        
        int[] supo1 = {1,2,3,4,5};
        int[] supo2 = {2,1,2,3,2,4,2,5};
        int[] supo3 = {3,3,1,1,2,2,4,4,5,5};
        
        int[] supo1AnswerList = new int[answers.length];
        int[] supo2AnswerList = new int[answers.length];
        int[] supo3AnswerList = new int[answers.length];
        
        int supo1AnswerCnt = 0;
        int supo2AnswerCnt = 0;
        int supo3AnswerCnt = 0;
        
        for(int i = 0; i < answers.length; i++) {
        	supo1AnswerList[i] = supo1[i%5];
        	supo2AnswerList[i] = supo2[i%8];
        	supo3AnswerList[i] = supo3[i%10];
        }
        
        for(int i = 0; i < answers.length; i++) {
        	if(answers[i] == supo1AnswerList[i]) {
        		supo1AnswerCnt++;
        	} 
        	
        	if(answers[i] == supo2AnswerList[i]) {
        		supo2AnswerCnt++;
        	}
        	
        	if(answers[i] == supo3AnswerList[i]) {
        		supo3AnswerCnt++;
        	} 
        }
        
        answer[0] = supo1AnswerCnt;
        answer[1] = supo2AnswerCnt;
        answer[2] = supo3AnswerCnt;
        
        int maxCnt = 0;
        
        for(int i = 0; i < answer.length; i++) {
        	if(answer[i] > maxCnt) {
        		maxCnt = answer[i];
        	}
        }
        
        for(int i = 0; i < answer.length; i++) {
        	if(answer[i] == maxCnt) {
        		rtnList.add(i+1);      		
        	}
        }
        
        Integer[] rtn = rtnList.toArray(new Integer[rtnList.size()]);
        
        return rtn;
        
    }
}
