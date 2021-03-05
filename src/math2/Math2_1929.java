package math2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 03월 04일
 *  - 링크 : https://www.acmicpc.net/problem/1929
 *	- HashSet을 사용하니 order가 맞지않아서 TreeSet으로 변경했더니 시간초과가 뜸.. 애초에 Set보다 List나 배열을 사용하는편이 더 나았을걸로 생각됨.  
 */
public class Math2_1929 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 숫자 범위 입력
		String numSize = br.readLine();
		int startNum = Integer.parseInt(numSize.split(" ")[0]) == 1 ? 2 : Integer.parseInt(numSize.split(" ")[0]);
		int endNum = Integer.parseInt(numSize.split(" ")[1]);
		
		// 범위 내 모든 숫자를 Set에 삽입
		Set<Integer> numSet = new HashSet<Integer>();
		
		for(int i = startNum; i <= endNum; i++) {
			numSet.add(i);
		}
		
		// 에라토스테네스의 체로 배수들 삭제
		for(int i = 2; i < endNum; i++) {
			for(int j = 2; j*i <= endNum; j++) {
				numSet.remove(j*i);
			}
		}
		
		// Set을 List 변환 후 답 출력(order때문에 변경...)
		List<Integer> answerList = new ArrayList<Integer>(numSet);
		Collections.sort(answerList);
		for(Integer i : answerList) {
			System.out.println(i);
		}
	}
}
