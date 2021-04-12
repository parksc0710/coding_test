package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 12일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/17682
 *	  
 */
public class Lv1_17682 {
	public static void main(String[] args) throws IOException {
		String dartResult = "1D2S#10S";
		Solution17682 tmp = new Solution17682();
		System.out.println(tmp.solution(dartResult));
	}

}

class Solution17682 {
	public int solution(String dartResult) {
        int answer = 0;
        List<Integer> scoreList = new ArrayList<Integer>();
        int index = 0;
        for(int i = 0; i < dartResult.length(); i++) {
        	String tmp1 = String.valueOf(dartResult.charAt(i));
        	String tmp2 = i < dartResult.length() -1 ? String.valueOf(dartResult.charAt(i+1)) : " ";
        	String tmp3 = i < dartResult.length() -2 ? String.valueOf(dartResult.charAt(i+2)) : " ";
        	
        	// 점수 체크
        	if(!tmp1.matches("[+-]?\\d*(\\.\\d+)?")) {
        		continue;
        	}
        	
        	// 10점 체크
        	if(tmp2.equals("0")) {
        		tmp1 = "10";
        		i++;
        		tmp2 = i < dartResult.length() -1 ? String.valueOf(dartResult.charAt(i+1)) : " ";
            	tmp3 = i < dartResult.length() -2 ? String.valueOf(dartResult.charAt(i+2)) : " ";
        	}
        	
        	// 옵션 체크
        	if(!(tmp3.equals("*") || tmp3.equals("#"))) {
        		tmp3 = " ";
        	}
        	
        	int tmp1Num = Integer.valueOf(tmp1);
        	
        	if(tmp2.equals("D")) {
        		tmp1Num = (tmp1Num*tmp1Num);
        	} else if(tmp2.equals("T")) {
        		tmp1Num = (tmp1Num*tmp1Num*tmp1Num);
        	}
        	
        	//System.out.println(tmp1 + " // " + tmp2 + " // " + tmp3);
        	
        	if(tmp3.equals("*") && index == 0) {
        		scoreList.add(tmp1Num * 2);
        		index++;
        	} else if(tmp3.equals("*") && index > 0) {
        		int tmpNum = scoreList.get(index-1) * 2;
        		scoreList.set(index-1, tmpNum);
        		scoreList.add(tmp1Num * 2);
        		index++;
        	} else if(tmp3.equals("#")) {
        		scoreList.add(tmp1Num * -1);
        		index++;
        	}  else {
        		scoreList.add(tmp1Num);
        		index++;
        	}
        }
        //System.out.println(scoreList.toString());
        for(int i : scoreList) {
        	answer += i;
        }
        return answer;
    }
}
 