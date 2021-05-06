package dfsbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * 
 *  - 일시 : 2021년 04월 27일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/43163
 *	  
 */
public class Dfabfs_43163 {
	public static void main(String[] args) throws IOException {
		
		String begin = "hit";
		String target = "cog";
		String[] words = {"hot", "dot", "dog", "lot", "log", "cog"};
		Solution43163 tmp = new Solution43163();
		System.out.println(tmp.solution(begin, target, words));

	}

}

class Solution43163 {
	public int solution(String begin, String target, String[] words) {
		int answer = 0;
		
		List<String> checkedList = new ArrayList<String>();
		List<String> wordsList = Arrays.asList(words);
		
		// bfs 사용
		Queue<String> queue = new LinkedList<String>();
		
		
		checkedList.add(begin);
		wordsList.remove(begin);
		queue.add(begin);
		for(int i = 0; i < wordsList.size(); i++) {
			if(checkDiff(begin, wordsList.get(i))) {
				
			}
		}
		
		
		return answer;
	}
	
	public boolean checkDiff(String before, String after) {
		int diff = 0;
		for(int i = 0; i < before.length(); i++) {
			for(int j = 0; j < after.length(); j++) {
				if(before.charAt(i) == after.charAt(j)) {
					continue;
				}
			}
		}
	}
}

