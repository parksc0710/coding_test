package order;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;


/**
 * 
 * - 일시 : 2021년 03월 07일 
 * - 링크 : https://www.acmicpc.net/problem/3273
 *
 */
public class Order_3273 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		// 수열의 크기
		int listSize = Integer.valueOf(st.nextToken());
		
		// 수열 배열 삽입 후 정렬
		st = new StringTokenizer(br.readLine());
		int[] intArr = new int[listSize];
		for(int i = 0; i < listSize; i++) {
			intArr[i] = Integer.valueOf(st.nextToken());
		}
		Arrays.sort(intArr);
		
		// 두 수의 합 조건
		int sum = Integer.valueOf(br.readLine());
		
		// 투포인트 Index 변수
		int startIndex = 0;
		int endIndex = listSize-1;
		
		// return value
		int answerCnt = 0;
		
		// 임시 변수
		int tmpSum = 0;
		
		while(startIndex < endIndex) {
			tmpSum = intArr[startIndex] + intArr[endIndex];
			if(tmpSum < sum) {
				startIndex++;
			} else if(tmpSum > sum) {
				endIndex--;
			} else if(tmpSum == sum) {
				answerCnt++;
				startIndex++;
			}
		}
		
		System.out.println(answerCnt);
	}
}
