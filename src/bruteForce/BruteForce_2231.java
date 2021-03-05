package bruteForce;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

/**
 * 
 *  - 일시 : 2021년 03월 03일
 *  - 링크 : https://www.acmicpc.net/problem/2231
 *
 */
public class BruteForce_2231 {
	
	static List<Integer> sumList = new ArrayList<Integer>();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int inNum = in.nextInt();
		
		for(int i = 1; i < inNum; i++) {
			int answer = i + getSum(i);
			if(answer == inNum) {
				sumList.add(i);
			}
		}
		
		if(sumList.size() == 0) {
			System.out.println(0);
		} else {
			System.out.println(Collections.min(sumList));
		}

	}
	
	public static int getSum(int rowNum) {
		int returnVal = 0;
		String rowNumString = String.valueOf(rowNum);
		for(int i = 0; i < rowNumString.length(); i++) {
			returnVal += Integer.parseInt(String.valueOf(rowNumString.charAt(i)));
		}
		return returnVal;
	}

}