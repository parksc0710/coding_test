package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * 
 * - 일시 : 2021년 03월 07일 
 * - 링크 : https://www.acmicpc.net/problem/1436
 *
 */
public class BruteForce_1436 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int inNum = Integer.valueOf(br.readLine());
		int sigNum = 666;
		int count = 1;
		while(count != inNum) {
			sigNum++;
			if(String.valueOf(sigNum).contains("666")) {
				count++;
			}
		}
		System.out.println(sigNum);
	}

}
