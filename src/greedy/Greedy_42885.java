package greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 05월 31일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42885
 *	  
 */
public class Greedy_42885 {
	public static void main(String[] args) throws IOException {
		
		int[] people = {70, 50, 80, 50};			
		int limit = 100;
		Solution42885 tmp = new Solution42885();
		System.out.println(tmp.solution(people, limit));

	}

}

class Solution42885 {
	public int solution(int[] people, int limit) {
        int answer = 0;
        
        // array to list
        List<Integer> peopleList = new ArrayList<Integer>(people.length);
        for (int i : people) {
        	peopleList.add(i);
        }
        
        // 내림차순  정렬
        Collections.sort(peopleList, Collections.reverseOrder());

        int tmpSum = 0;
        
        int i = 0;
        int endPointer = peopleList.size()-1;
        
        while(i <= endPointer) {
        	tmpSum += peopleList.get(i);
        	if(tmpSum + peopleList.get(endPointer) <= limit) {
        		endPointer--;
        	}
        	i++;
        	answer++;
        	tmpSum = 0;
        }
        
        return answer;
    }
}