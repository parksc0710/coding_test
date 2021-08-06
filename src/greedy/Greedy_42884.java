package greedy;

import java.io.IOException;
import java.util.Arrays;
import java.util.Comparator;

/**
 * 
 *  - 일시 : 2021년 08월 06일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42884
 *	  
 */
public class Greedy_42884 {
	public static void main(String[] args) throws IOException {
		
//		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2			
//		int[][] routes = {{-20,-19}, {-18,-17}, {-16,-15}, {-5,-3}}; //4
//		int[][] routes = {{-20,15}, {-18,-5}, {-18,-13}, {-17,-3}}; // 1
//		int[][] routes = {{-20,15}}; //1
//		int[][] routes = {{-30000,0},{-30000,1},{-30000,2}}; //1
//		int[][] routes = {{-2,-1},{1,2},{-3,0}}; //2
//		int[][] routes = {{0,1},{0,1},{1,2}}; //1
//		int[][] routes = {{0,1},{2,3},{4,5},{6,7}};//4
//		int[][] routes = {{-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
//		int[][] routes = {{-20,15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
//		int[][] routes = {{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3}}; //2
//		int[][] routes = {{0,1}, {1,2}, {2,3}, {3,4}, {4,5}, {5,6}, {6,7}, {7,8}, {8,9}, {9,10}, {10, 1}, {11,12}, {12,13}, {13,14}, {14,15}}; // 8
//		int[][] routes = {{-191,-107}, {-184,-151}, {-150,-102}, {-171,-124}, {-120,-114}}; // 2
//		int[][] routes = {{0,12}, {1,12}, {2,12}, {3,12}, {5,6}, {6,12}, {10,12}}; //2
		int[][] routes = {{-5,-3}, {-4,0}, {-4,-2}, {-1,2}, {0,3}, {1,5}, {2,4}}; //2
//		int[][] routes = {{-7,0}, {-6,-4}, {-5,-3}, {-3,-1}, {-1,4}, {1,2}, {3,4}}; //4
//		int[][] routes = {{2,2},{0,1},{-10,9}}; //2
//		int[][] routes = {{-20,15}, {-20,-15}, {-14,-5}, {-18,-13}, {-5,-3} }; //2
		Solution42884 tmp = new Solution42884();
		System.out.println(tmp.solution(routes));

	}

}

class Solution42884 {
	public int solution(int[][] routes) {
        int answer = 1;
        
        // 나가는 출구 기준 오름차순 정렬
        Arrays.sort(routes, new Comparator<int[]>() {

			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[1] - o2[1];
			}
        	
		});
        
        System.out.println(Arrays.deepToString(routes));
        
        // 0번 배열의 나가는 지점에 감시카메라 설치, 나가는 지점보다 다음 인덱스의 출입지점이 크다면 pass, 작다면 answer+1 후 다음 인덱스의 나가는 지점에 감시카메라 설치  
        int camNum = routes[0][1];
        
        for(int i = 0; i < routes.length-1; i++) {
        	int nextEnter = routes[i+1][0];
        	int nextOut = routes[i+1][1];
        	if(nextEnter <= camNum) {
        		continue;
        	} else {
        		answer++;
        		camNum = nextOut;
        	}
        	
        }
        
       
        return answer;
    }
}