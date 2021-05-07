package dfsbfs;

import java.io.IOException;
import java.util.LinkedList;
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
		
		// target이 words 안에 없으면 0 반환
		boolean isIn = false;
		for(int i = 0; i < words.length; i++) {
			if(target.equals(words[i])) {
				isIn = true;
			}
		}
		
		if(!isIn) {
			return answer;
		}
		
		
		// target이 words 안에 있으면 bfs 탐색
		
		boolean findFlag = false;
		
		boolean[] flagArray = new boolean[words.length];
		
		Queue<String> queue = new LinkedList<String>();
		
		queue.add(begin);
		
		while(!findFlag) {
			
			answer++;
			
			int size = queue.size();
			
			for(int i = 0; i < size; i++) {
				String nowString = queue.poll();
				
				for(int j = 0; j < words.length; j++) {
					if(checkDiff(nowString, words[j]) && !flagArray[j]) {

						// begin과 하나만 다르면 큐에 추가
						queue.add(words[j]);
						flagArray[j] = true;
						
						// 찾은 문자가 target이랑 같으면 정답 반환
						if(words[j].equals(target)) {
							findFlag = true;
							break;
						}

					}
				}
			}
			
		}
		
		return answer;
	}
	
	public boolean checkDiff(String before, String after) {
		
		boolean rtn = false;
		
		int diff = 0;
		
		for(int i = 0; i < before.length(); i++) {
			if(before.charAt(i) != after.charAt(i)) {
				diff++;
				continue;
			}
			if(diff > 1) {
				break;
			}
		}
		
		if(diff == 1) {
			rtn = true;
		}
		
		return rtn;
	}
}

