package lv2;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 
 *  - 일시 : 2021년 07월 07일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/64065
 *	  
 */
public class Lv2_64065 {
	public static void main(String[] args) throws IOException {
				
		String s = "{{1,2,2},{2,1},{1,2,4,2},{2}}";
		Solution64065 tmp = new Solution64065();
		System.out.println(Arrays.toString(tmp.solution(s)));

	}
}

class Solution64065 {
	public int[] solution(String s) {
      
		List<Integer> answerList = new ArrayList<Integer>();
		
		List<String> tmpList = new ArrayList<String>();
		
		Pattern patt = Pattern.compile("\\{(.*?)\\}");
		Matcher match = patt.matcher(s);
		while(match.find()){
			tmpList.add(match.group(1).replaceAll("\\{", "").replaceAll("\\}", ""));
		}
        
        
        Comparator<String> c = new Comparator<String>() { 
        	public int compare(String s1, String s2) { 
        		return Integer.compare(s1.length(), s2.length()); 
        	} 
        };

        Collections.sort(tmpList, c);
        
        for(int i = 0; i < tmpList.size(); i++) {
        	if(answerList.size() == 0) {
        		answerList.add(Integer.valueOf(tmpList.get(i)));
        	} else {
        		String tmpS = tmpList.get(i);
        		/*for(int j = 0; j < answerList.size(); j++) {
        			tmpS = tmpS.replaceFirst(String.valueOf(answerList.get(j)), "");
        		}*/
        		//answerList.add(Integer.parseInt(tmpS.replaceAll(",", "")));
        		String[] tmpSArray = tmpS.split(",");
        		for(int j = 0; j < tmpSArray.length; j++) {
        			for(int k = 0; k < answerList.size(); k++) {
        				if(!tmpSArray[j].equals("0") && tmpSArray[j].equals(answerList.get(k).toString())) {
        					tmpSArray[j] = "0";
        				}
        			}
        		}
        		for(int j = 0; j < tmpSArray.length; j++) {
        			if(!tmpSArray[j].equals("0")) {
        				answerList.add(Integer.parseInt(tmpSArray[j]));
        			}
        		}
        	}
        }
        
        int[] answer = new int[answerList.size()];
        
        for(int i = 0; i < answerList.size(); i++) {
        	answer[i] = answerList.get(i);
        }
        
        return answer;
    }
}
