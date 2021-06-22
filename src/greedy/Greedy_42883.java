package greedy;

import java.util.Stack;

/**
 * 
 *  - 일시 : 2021년 06월 17일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42883
 *	  
 */
public class Greedy_42883 {
	public static void main(String[] args){
		
//		String number = "999";
//		int k = 2;
		String number = "9998887776665554443332221110009";
		int k = 30;
		Solution42883 tmp = new Solution42883();
		System.out.println(tmp.solution(number, k));

	}

}

class Solution42883 {
	public String solution(String number, int k) {
        String answer = "";
        
        Stack<String> stack = new Stack<String>();
        
        int popCnt = 0;
        
		for (int i = 0; i < number.length(); i++) {

			if (popCnt < k) {

				if (stack.size() == 0 && number.charAt(i) == '0') {
					popCnt++;
				} else if (stack.size() == 0 && number.charAt(i) != '0') {
					stack.push(String.valueOf(number.charAt(i)));
				} else {
					int nowInt = Integer.valueOf(String.valueOf(number.charAt(i)));
					while (true) {
						if (popCnt < k) {
							if (stack.size() == 0) {
								stack.push(String.valueOf(nowInt));
								break;
							} else {
								int beforeInt = Integer.valueOf(stack.pop());
								if (beforeInt < nowInt) {
									popCnt++;
								} else {
									stack.push(String.valueOf(beforeInt));
									stack.push(String.valueOf(nowInt));
									break;
								}
							}
						} else {
							stack.push(String.valueOf(nowInt));
							break;
						}

					}
				}
			} else {
        		stack.push(String.valueOf(number.charAt(i)));
        	}

		}
		
		int tmpInt = 0;
		
		// popCnt가 k보다 작으면 나머지 만큼 작은 수 제외
		while(popCnt < k) {
			int tmpIndex = stack.indexOf(String.valueOf(tmpInt));
			if(tmpIndex > -1) {
				stack.remove(tmpIndex);
				popCnt++;
			} else {
				tmpInt++;
			}
			
			if(tmpInt == 10) {
				break;
			}
			
		}
		
        
        // stack 값 index 별로 빼서 answer 추가
        for(int i = 0; i < stack.size(); i++) {
        	answer += stack.get(i);
        }
        
        return answer;
    }
}