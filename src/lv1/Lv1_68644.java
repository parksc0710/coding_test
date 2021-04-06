package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 
 *  - 일시 : 2021년 04월 06일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/68644
 *	  
 */
public class Lv1_68644 {
	public static void main(String[] args) throws IOException {
		
		int[] numbers = {2,1,3,4,1};
		Solution68644 tmp = new Solution68644();
		System.out.println(Arrays.toString(tmp.solution(numbers)));

	}

}

class Solution68644 {
	public Integer[] solution(int[] numbers) {
		ArrayList<Integer> tmpList = new ArrayList<Integer>();
		
		int tmpSum = 0;
		
		for(int i = 0; i < numbers.length; i++) {
			for(int j = 0; j <numbers.length; j++) {
				if(i != j) {
					tmpSum = numbers[i]+numbers[j];
					if(!tmpList.contains(tmpSum)) {
						tmpList.add(tmpSum);
					}
				}
			}
		}
		
		Collections.sort(tmpList);
	
		Integer[] answer = tmpList.toArray(new Integer[tmpList.size()]);

		return answer;
	}
}
