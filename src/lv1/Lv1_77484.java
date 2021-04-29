package lv1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  - 일시 : 2021년 04월 29일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/77484
 *	  
 */
public class Lv1_77484 {
	public static void main(String[] args) throws IOException {
		
		int[] lottos = {44, 1, 0, 0, 31, 25};
		int[] win_nums = {31, 10, 45, 1, 6, 19};
		Solution77484 tmp = new Solution77484();
		System.out.println(tmp.solution(lottos, win_nums));

	}

}

class Solution77484 {
	public int[] solution(int[] lottos, int[] win_nums) {
		int zeroCnt = 0;
		int matchCnt = 0;
		int win1 = 0;
		int win2 = 0;
		
		for(int i = 0; i < lottos.length; i++) {
			if(lottos[i] == 0) {
				zeroCnt++;
				continue;
			} else {
				for(int j = 0; j < win_nums.length; j++) {
					if(lottos[i] == win_nums[j]) {
						matchCnt++;
						continue;
					}
				}
			}
		}
		
		switch(matchCnt) {
			case 6: win2 = 1; break;
			case 5: win2 = 2; break;
			case 4: win2 = 3; break;
			case 3: win2 = 4; break;
			case 2: win2 = 5; break;
			default : win2 = 6;  break;
		}
		
		switch(matchCnt + zeroCnt) {
			case 6: win1 = 1; break;
			case 5: win1 = 2; break;
			case 4: win1 = 3; break;
			case 3: win1 = 4; break;
			case 2: win1 = 5; break;
			default : win1 = 6;  break;
		}
		
        int[] answer = {win1, win2};
        return answer;
    }
}
