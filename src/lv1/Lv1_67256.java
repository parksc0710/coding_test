package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/67256
 *	  
 */
public class Lv1_67256 {
	public static void main(String[] args) throws IOException {
		
		int[] numbers = {1, 3, 4, 5, 8, 2, 1, 4, 5, 9, 5};
		String hand = "right";
		Solution67256 tmp = new Solution67256();
		System.out.println(tmp.solution(numbers, hand));

	}

}

class Solution67256 {
	public String solution(int[] numbers, String hand) {
		String answer = "";
		int lNum = 10;
		int rNum = 20;
		for(int i = 0; i < numbers.length; i++) {
			int nowNum = numbers[i];
			if(nowNum == 1 || nowNum == 4 || nowNum == 7) {
				lNum = nowNum;
				answer += "L";
			} else if(nowNum == 3 || nowNum == 6 || nowNum == 9) {
				rNum = nowNum;
				answer += "R";
			} else {
				int lDis = checkDistance(lNum, nowNum);
				int rDis = checkDistance(rNum, nowNum);
				if(lDis == rDis && hand.equals("right")) {
					rNum = nowNum;
					answer += "R";
				} else if(lDis == rDis && hand.equals("left")) {
					lNum = nowNum;
					answer += "L";
				} else if(lDis < rDis) {
					lNum = nowNum;
					answer += "L";
				} else if(lDis > rDis) {
					rNum = nowNum;
					answer += "R";
				}
				
			}
		}
		
        return answer;
    }
	
	private int checkDistance(int sNum, int eNum) {
		int distance = 0;
		int[][] numMatrix = new int[][]{{1,4,7,10}, {2,5,8,0}, {3,6,9,20}};
		int sNumX = 0;
		int sNumY = 0;
		int eNumX = 0;
		int eNumY = 0;
		for(int i = 0; i < numMatrix.length; i++) {
			for(int j = 0; j < numMatrix[i].length; j++ ) {
				if(numMatrix[i][j] == sNum) {
					sNumX = i;
					sNumY = j;
				}
				
				if(numMatrix[i][j] == eNum) {
					eNumX = i;
					eNumY = j;
				}
			}
		}
		int distanceX = (sNumX - eNumX) < 0 ? -(sNumX - eNumX) : (sNumX - eNumX);
		int distanceY = (sNumY - eNumY) < 0 ? -(sNumY - eNumY) : (sNumY - eNumY);
		distance = distanceX+distanceY;
		return distance;
	}
}
 