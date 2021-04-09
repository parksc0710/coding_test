package lv1;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12915
 *	  
 */
public class Lv1_12915 {
	public static void main(String[] args) throws IOException {
		String[] strings = {"abce", "abcd", "cdx"};
		int n = 1;
		Solution12915 tmp = new Solution12915();
		System.out.println(tmp.solution(strings, n));
	}

}

class Solution12915 {
	public String[] solution(String[] strings, int n) {
        List<StringInfo> StringInfoList = new ArrayList<StringInfo>();
        for(int i = 0; i < strings.length; i++) {
        	StringInfo tmp = new StringInfo(strings[i], strings[i].charAt(n));
        	StringInfoList.add(tmp);
        }
        
        Collections.sort(StringInfoList);
        
        String[] answer = new String[strings.length];
        for(int i = 0; i < StringInfoList.size(); i++) {
        	answer[i] = StringInfoList.get(i).getRawString();
        }
        
        return answer;
    }
}

class StringInfo implements Comparable<StringInfo> {
	String rawString;
	char indexChar;
	public StringInfo(String rawString, char indexChar) {
		this.rawString = rawString;
		this.indexChar = indexChar;
	}
	public String getRawString() {
		return rawString;
	}
	public char getIndexChar() {
		return indexChar;
	}
	@Override
	public int compareTo(StringInfo s) {
		int rtn = 0;
		if (this.indexChar < s.getIndexChar()) {
			rtn = -1;
        } else if (this.indexChar > s.getIndexChar()) {
        	rtn = 1;
        } else if(this.indexChar == s.getIndexChar()) {
        	if(s.getRawString().compareTo(this.getRawString()) < 0) {
        		rtn = 1;
        	} else {
        		rtn = -1;
        	}
        }
		return rtn;
	}
}
