package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 *  - 일시 : 2021년 06월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42861
 *	  
 */
public class Greedy_42861 {
	public static void main(String[] args) throws IOException {
		int n = 5;
		// int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
		int[][] costs = {{0,1,1},{3,4,1},{1,2,2},{2,3,4}};
		Solution42861 tmp = new Solution42861();
		System.out.println(tmp.solution(n, costs));

	}

}

class Solution42861 {
	public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // cost별 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
            	return o1[2] - o2[2];
            }
        });
        
        // 섬 연결 여부 체크 Array, 연결되면 1 연결 안되면 0 --> 해당 연결 내역 다시 체크하기
        int[] conCheck = new int[n];
        
        // costs 돌면서 섬 연결
        for(int i = 0; i < costs.length; i++) {
        	int tmpNum1 = costs[i][0];
        	int tmpNum2 = costs[i][1];
        	if(conCheck[tmpNum1] == 0 || conCheck[tmpNum2] == 0) {
        		conCheck[tmpNum1] = 1;
        		conCheck[tmpNum2] = 1;
        		answer += costs[i][2];
        	}
        }
        
        System.out.println(Arrays.deepToString(costs));
        
        return answer;
    }
}
