package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 
 *  - 일시 : 2021년 04월 12일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42889
 *	  
 */
public class Lv1_42889 {
	public static void main(String[] args) throws IOException {
		int N = 5;
		int[] stages = {2, 1, 2, 6, 2, 4, 3, 3};
		Solution42889 tmp = new Solution42889();
		System.out.println(tmp.solution(N, stages));
	}

}

class Solution42889 {
	public Integer[] solution(int N, int[] stages) {
		Integer[] answer = new Integer[N];
        
        Map<Integer, Double> fails = new HashMap<Integer, Double>();
        
        while(N > 0) {
        	int total = 0;
        	int fail = 0;
        	for(int i = 0; i < stages.length; i++) {
        		if(stages[i] >= N) {
        			total ++;        
        			if(stages[i] == N) {
        				fail++;
        			}
        		}
        	}
        	
        	double failRate = total == 0 ? 0 : (double) fail/total;
        	fails.put(N, failRate);
        	
        	N--;
        }
        
        List<Integer> keySetList = new ArrayList<>(fails.keySet());
        Collections.sort(keySetList, (o1, o2) -> (fails.get(o2).compareTo(fails.get(o1))));
        
        answer = keySetList.toArray(new Integer[keySetList.size()]);
                
        return answer;
    }
}
 