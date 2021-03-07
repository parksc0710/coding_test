package dynamicPrograming;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 *  - 일시 : 2021년 03월 08일
 *  - 링크 : https://www.acmicpc.net/problem/1003
 *
 */
public class DynamicPrograming_1003 {
	
	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		int inSize = Integer.valueOf(br.readLine()); 
        int[] inArray = new int[inSize];
        
        for(int i=0; i<inSize; i++) {
        	inArray[i] = Integer.valueOf(br.readLine()); 
        }
        
        int[][] fiboArray = new int [41][2];
        
        fiboArray[0][0] = 1;
        fiboArray[0][1] = 0;
        fiboArray[1][0] = 0;
        fiboArray[1][1] = 1;
        
        for(int i = 2; i < fiboArray.length; i++) {
        	fiboArray[i][0] = fiboArray[i-1][1];
        	fiboArray[i][1] = fiboArray[i-1][0] + fiboArray[i-1][1];
        }
		
        for(int i = 0; i < inArray.length; i++) {
        	System.out.println(fiboArray[inArray[i]][0] + " " + fiboArray[inArray[i]][1]);  
        }
	}

}
