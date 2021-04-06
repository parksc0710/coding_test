package backTracking;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

/**
 * 
 *  - 일시 : 2021년 03월 09일
 *  - 링크 : https://www.acmicpc.net/problem/15649
 *	  
 */
public class BackTracking_15649 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 최대값
		int max = Integer.valueOf(st.nextToken());
		
		// 길이
		int length = Integer.valueOf(st.nextToken());
		
		getNums(max, length);
		
	}
	
	public static void getNums(int max, int length) {
		
		int index = 1;
		int depth = 0;
		int tmpIndex = 1;
		
		String answer = "";
		
		while(index <= max) {
			answer += String.valueOf(index);
			
			while(depth < length) {
				
				while(tmpIndex <= max) {
					if(answer.indexOf(String.valueOf(tmpIndex)) < -1) {
						answer += String.valueOf(tmpIndex);
					}
					tmpIndex++;
				}
				
				depth++;
				
				if(depth == length) {
					System.out.println(answer);
					answer = "";
				}
				
			}
			index++;
			depth = 0;
		}
		
	}
	
}
