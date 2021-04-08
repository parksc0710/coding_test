package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42748
 *	  
 */
public class Lv1_42748 {
	public static void main(String[] args) throws IOException {
		
		int[] inArr = {1, 5, 2, 6, 3, 7, 4};
		int[][] commands = {
				{2, 5, 3}, {4, 4, 1}, {1, 7, 3}
		};
		Solution42748 tmp = new Solution42748();
		System.out.println(Arrays.toString(tmp.solution(inArr, commands)));

	}

}

class Solution42748 {
	public int[] solution(int[] array, int[][] commands) {
        int[] answer = new int[commands.length];
        List<Integer> tmpList = new ArrayList<Integer>();
        for(int i = 0; i < commands.length; i++) {
        	tmpList.clear();
        	for(int j = commands[i][0]-1; j < commands[i][1]; j++) {
        		tmpList.add(array[j]);
        	}
        	Collections.sort(tmpList);
        	answer[i] = tmpList.get(commands[i][2]-1);
        }
        return answer;
    }
}
