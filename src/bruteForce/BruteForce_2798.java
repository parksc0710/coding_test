package bruteForce;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *  - 일시 : 2021년 03월 02일
 *  - 링크 : https://www.acmicpc.net/problem/2798
 *
 */
public class BruteForce_2798 {
	
	static List<Integer> sumList = new ArrayList<Integer>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int n, max;
		n = in.nextInt();
		max = in.nextInt();
		int r = 3;
		
		Integer[] inArray = new Integer[n];

		boolean[] visited = new boolean[n];
		
		for(int i = 0; i < n; i++) {
			inArray[i] = in.nextInt();
		}
		
		// 내림차순 정렬
		Arrays.sort(inArray, Collections.reverseOrder());
		
		combination(inArray, visited, 0, n, r, max);
		
		System.out.println(Collections.max(sumList));

	}
	
	static void combination(Integer[] arr, boolean[] visited, int start, int n, int r, int max) {
		if (r == 0) {
            print(arr, visited, n, max);
            return;
        }
		
	    for(int i=start; i<n; i++) {
	        visited[i] = true;
	        combination(arr, visited, i + 1, n, r - 1, max);
	        visited[i] = false;
	    }
	}
	
	// 배열 출력
    static void print(Integer[] arr, boolean[] visited, int n, int max) {
    	int tmpSum = 0;
        for (int i = 0; i < n; i++) {
            if (visited[i]) {
                //System.out.print(arr[i] + " ");
            	tmpSum += arr[i];
            }
        }
        
        if(tmpSum <= max) {
        	// 결과 저장
        	sumList.add(tmpSum);
        }
    }

}
