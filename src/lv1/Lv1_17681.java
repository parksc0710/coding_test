package lv1;

import java.io.IOException;

/**
 * 
 *  - 일시 : 2021년 04월 12일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/17681
 *	  
 */
public class Lv1_17681 {
	public static void main(String[] args) throws IOException {
		int n = 6;
		int[] arr1 = {46, 33, 33 ,22, 31, 50};
		int[] arr2 = {27 ,56, 19, 14, 14, 10};
		Solution17681 tmp = new Solution17681();
		System.out.println(tmp.solution(n, arr1, arr2));
	}

}

class Solution17681 {
	public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        String[] arr1Map = new String[n];
        String[] arr2Map = new String[n];
        
        for(int i = 0; i < arr1.length; i++) {
        	arr1Map[i] = getMap(arr1[i], n);
        	arr2Map[i] = getMap(arr2[i], n);
        }
        
        for(int i = 0; i < arr1.length; i++) {
        	String tmp = "";
        	for(int j = 0; j < arr1Map[i].length(); j++) {
        		String tmp1 = String.valueOf(arr1Map[i].charAt(j));
        		String tmp2 = String.valueOf(arr2Map[i].charAt(j));
        		if(tmp1.equals("1") || tmp2.equals("1")) {
        			tmp += "#";
        		} else {
        			tmp += " ";
        		}
        		
        	}
        	answer[i] = tmp;
        }
        
        return answer;
    }
	private String getMap(int num, int n) {
		String tmpLine = "";
		while(num > 0) {
			tmpLine += (num%2);
			num = num / 2;
		}
		if(tmpLine.length() < n) {
			while(tmpLine.length() != n) {
				tmpLine += "0";
			}
		}
		StringBuffer sb = new StringBuffer(tmpLine); 
		String reversedStr = sb.reverse().toString();

		return reversedStr;
	}
}


