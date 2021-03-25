package hash;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * 
 *  - 일시 : 2021년 03월 24일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42577
 *  - HashSet을 이용한 풀이
 *	  
 */
public class Hash_42578_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine(), ",");
		String[] array = new String[st.countTokens()];
		
		int i = 0;
		while (st.hasMoreElements()) {
			array[i++] = st.nextToken().replaceAll("[\"\\[\\]]", "").trim();
		}
		
		Solution2 tmp = new Solution2();
		System.out.println(tmp.solution(array));

	}

}

class Solution2 {
    public boolean solution(String[] phone_book) {
    	boolean answer = true;
    	
    	// set 생성
    	Set<String> inSet = new HashSet<String>();
    	
    	// 배열 값을 set에 add
    	for(String tmp : phone_book) {
    		inSet.add(tmp);
    	}
    	
    	// set iterator 생성
    	Iterator<String> iter = inSet.iterator();
    	while(iter.hasNext()) {
    		// set의 값을 하나 뽑아서 substring한 값이 set에 있는지 체크
    		String tmpString = iter.next();
    		for(int i = 1; i < tmpString.length(); i++) {
    			String tmpSubString = tmpString.substring(0, i);
    			if(inSet.contains(tmpSubString)) {
    				answer = false;
    				break;
    			}
    		}
    	}
        return answer;
    }
}
