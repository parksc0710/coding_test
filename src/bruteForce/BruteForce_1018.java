package bruteForce;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * 
 * - 일시 : 2021년 03월 04일 
 * - 링크 : https://www.acmicpc.net/problem/1018
 *
 */
public class BruteForce_1018 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// 체스판 크기 입력
		String boardSize = br.readLine();
		int sizeX = Integer.parseInt(boardSize.split(" ")[0]);
		int sizeY = Integer.parseInt(boardSize.split(" ")[1]);

		// 체스판 색 정보 2차원 배열 삽입
		Character[][] boardArray = new Character[sizeX][sizeY];
		for (int i = 0; i < sizeX; i++) {
			String tmpLineString = br.readLine();
			for (int j = 0; j < sizeY; j++) {
				boardArray[i][j] = tmpLineString.charAt(j);
			}
		}

		// 맨 왼쪽 위 색에 따른 경우의 수 변수 선언
		List<Integer> blackList = new ArrayList<>();
		List<Integer> whiteList = new ArrayList<>();
		
		int black = 0;
		int white = 0;

		// 기준색에 따른 재 색칠 경우의 수 확인
		for(int x = 0; x < sizeX-7; x++) {
			for(int y = 0; y < sizeY-7; y++) {
				
				for (int i = 0+x; i < 8+x; i++) {
					for (int j = 0+y; j < 8+y; j++) {

						if ((i + j) % 2 == 0 && boardArray[i][j] == 'B') {
							white++;
						} else if ((i + j) % 2 == 1 && boardArray[i][j] == 'W') {
							white++;
						} else if ((i + j) % 2 == 0 && boardArray[i][j] == 'W') {
							black++;
						} else if ((i + j) % 2 == 1 && boardArray[i][j] == 'B') {
							black++;
						}
					}
				}
				
				blackList.add(black);
				whiteList.add(white);
				black = 0;
				white = 0;
				
			}
		}
		
		// 각 리스트 중에서 최소값 출력
		System.out.println(Collections.min(blackList) >= Collections.min(whiteList) ? Collections.min(whiteList) : Collections.min(blackList));		

	}

}
