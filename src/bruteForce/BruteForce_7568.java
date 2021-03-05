package bruteForce;

import java.util.Scanner;

/**
 * 
 *  - 일시 : 2021년 03월 04일
 *  - 링크 : https://www.acmicpc.net/problem/7568
 *
 */
public class BruteForce_7568 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int inCnt = in.nextInt();
		Person[] personList = new Person[inCnt];
		Integer[] answerList = new Integer[inCnt];

		for(int i = 0; i < inCnt ; i++) {
			Integer tmpWeight = in.nextInt();
			Integer tmpHeight = in.nextInt();
			personList[i] = new Person(tmpWeight, tmpHeight);
		}
		
		for(int i = 0; i < personList.length; i++) {
			int tmpAnswer = 1;
			int tmpWeight = personList[i].getWeight();
			int tmpHeight = personList[i].getHeight();
			
			for(int j = 0; j < personList.length; j++) {
				if(i != j && personList[j].getWeight() > tmpWeight && personList[j].getHeight() > tmpHeight) {
					tmpAnswer++;
				}
			}
			answerList[i] = tmpAnswer;
		}
		
		for(int i = 0; i < inCnt ; i++) {
			if(i < inCnt - 1) {
				System.out.print(answerList[i] + " ");
			} else {
				System.out.println(answerList[i]);
			}
		}
	}

}

class Person {
	
	Integer weight;
	Integer height;
	
	public Person(Integer weight, Integer height) {
		this.weight = weight;
		this.height = height;
	}
	
	public Integer getWeight() {
		return weight;
	}
	public Integer getHeight() {
		return height;
	}
	
}
