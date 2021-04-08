package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12906
 *	  
 */
public class Lv1_12906 {
	public static void main(String[] args) throws IOException {
		
		int[] a = {1,1,3,3,0,1,1};
		Solution12906 tmp = new Solution12906();
		System.out.println(Arrays.toString(tmp.solution(a)));

	}

}

class Solution12906 {
	public Integer[] solution(int[] arr) {
        Integer[] answer = {};
        
        List<Integer> tmpArray = new ArrayList<Integer>();
        
        for(int i = 0; i < arr.length; i++) {
        	if(i == 0) {
        		tmpArray.add(arr[i]);
        	} else if(i > 0 && arr[i] == arr[i-1]) {
        		continue;
        	} else {
        		tmpArray.add(arr[i]);
        	}
        }
        
        answer = tmpArray.toArray(new Integer[tmpArray.size()]);
        
        return answer;
    }
}
