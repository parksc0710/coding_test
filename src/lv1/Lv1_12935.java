package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12935
 *	  
 */
public class Lv1_12935 {
	public static void main(String[] args) throws IOException {
		
		int[] arr = {4,3,2,1};
		Solution12935 tmp = new Solution12935();
		System.out.println(tmp.solution(arr));

	}

}

class Solution12935 {
	public Integer[] solution(int[] arr) {
		Integer[] arrSort = new Integer[arr.length];
		Integer[] arrInteger = new Integer[arr.length];
		for(int i = 0; i < arr.length; i++) {
			arrSort[i] = Integer.valueOf(arr[i]);
			arrInteger[i] = Integer.valueOf(arr[i]);
		}
		Arrays.sort(arrSort);
		int min = arrSort[0];
		ArrayList<Integer> tmpList = new ArrayList<Integer>(Arrays.asList(arrInteger));
		int numIndex = tmpList.indexOf(min);
		tmpList.remove(numIndex);
		if(tmpList.size() == 0) {
			Integer[] answer = {-1};
			return answer;
		} else {
			Integer[] answer = tmpList.toArray(new Integer[tmpList.size()]);
			return answer;
		}
    }
}
 