package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/64061
 *	  
 */
public class Lv1_64061 {
	public static void main(String[] args) throws IOException {
		
		int[][] board = {{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] moves = {1,5,3,5,1,2,1,4};
		Solution64061 tmp = new Solution64061();
		System.out.println(tmp.solution(board, moves));

	}

}

class Solution64061 {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;
        List<Integer> basket = new ArrayList<Integer>();
        
        for(int i = 0; i < moves.length; i++) {
        	
        	int moveIndex = moves[i]-1;
        	
        	for(int j = 0; j < board.length; j++) {
        		if(board[j][moveIndex] != 0) {
        			basket.add(board[j][moveIndex]);
        			board[j][moveIndex] = 0;
        			int nowIndex = basket.size()-1;
        			if(nowIndex > 0 && basket.get(nowIndex) == basket.get(nowIndex-1)) {
        				basket.remove(basket.size()-1);
        				basket.remove(basket.size()-1);
        				answer += 2;
        			}
        			break;
        		} 
        	}
        }
        
        return answer;
    }
}
