package dfsbfs;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 04월 23일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/43162
 *	  
 */
public class Dfabfs_43162 {
	public static void main(String[] args) throws IOException {
		
		//int n = 5;
		//int[][] computers = {{1, 0, 0, 0, 0}, {0, 1, 0, 0, 1}, {0, 0, 1, 0, 1}, {0, 0, 0, 1, 1}, {1, 0, 0, 0, 1}};
		int n = 3;
		int[][] computers = {{1,1,0},{1,1,0},{0,0,1}};			
		Solution43162 tmp = new Solution43162();
		System.out.println(tmp.solution(n, computers));

	}

}

class Solution43162 {
	public int solution(int n, int[][] computers) {
       
        List<MyNetwork> networkList = new ArrayList<MyNetwork>();
        
        // n이 1이면 1 리턴
        if(n == 1) {
        	return 1;
        }
        
        // 배열 돌면서 연결된 네트워크 검색
        for(int i = 0; i < computers.length; i++) {
        	
        	// 체크 플래그
        	boolean isIn = false;
        	
        	// 배열 탐색 처음 시작할 때 네트워크 추가
        	if(i == 0) {
        		MyNetwork network = new MyNetwork();
				network.insertPcNum(i);
				networkList.add(network);
        	}
        	
        	// 연결된 컴퓨터 체크
        	for(int j = 0; j < computers[i].length; j++) {
        		
        		// 임시 네트워크 인덱스 i
            	int networkListIndexI = -1;
            	
            	// 임시 네트워크 인덱스 j
            	int networkListIndexJ = -1;
        		
        		if(i != j) { 
        			if(computers[i][j] == 0) {
        				// 연결되어있지 않으면 continue;
        				continue;
        			} else {
        				isIn = true;
        				
        				// 연결되어있으면 기존에 네트워크에 속해있는지 안속해있는지 체크
        				for(int k = 0; k < networkList.size(); k++) {
        					if(networkList.get(k).checkPcNum(i)) {
        						networkListIndexI = k;
        						break;
        					}
        				}
        				
        				for(int k = 0; k < networkList.size(); k++) {
        					if(networkList.get(k).checkPcNum(j)) {
        						networkListIndexJ = k;
        						break;
        					}
        				}
        				
        				// 기존에 속한 네트워크가 있으면 합치기
        				if(networkListIndexI == -1 && networkListIndexJ == -1) {
        					MyNetwork network = new MyNetwork();
        					network.insertPcNum(i);
        					network.insertPcNum(j);
        					networkList.add(network);
        				} else if(networkListIndexI == -1 && networkListIndexJ > -1) {
        					networkList.get(networkListIndexJ).insertPcNum(i);
        				} else if(networkListIndexI > -1 && networkListIndexJ == -1) {
        					networkList.get(networkListIndexI).insertPcNum(j);
        				} else {
        					MyNetwork networkI = networkList.get(networkListIndexI);
        					MyNetwork networkJ = networkList.get(networkListIndexJ);
        					if(networkI == networkJ) {
        						networkI.getPcNums(networkJ.pcNums);
        						MyNetwork networkINew = networkI;
            					networkList.remove(networkI);
            					networkList.add(networkINew);
        					} else {
        						networkI.getPcNums(networkJ.pcNums);
            					networkList.remove(networkJ);
        					}
        				} 
        				
        			}
        		}
        	
        	}
        	
        	// 속한 네트워크가 하나도 없을 때 신규 네트워크 추가
    		if(!isIn && i > 0) {
    			MyNetwork network = new MyNetwork();
				network.insertPcNum(i);
				networkList.add(network);
    		}
        }
        
        //System.out.println(networkList);
        
        return networkList.size();
    }
}

class MyNetwork {
	Set<Integer> pcNums = new HashSet<Integer>();
	
	boolean checkPcNum(int n) {
		if(pcNums.contains(n)) {
			return true;
		} else {
			return false;
		}
	}
	
	void insertPcNum(int n) {
		this.pcNums.add(n);
	}
	
	void deletePcNum(int n) {
		this.pcNums.remove(n);
	}
	
	void getPcNums(Set<Integer> inPcNums) {
		Iterator<Integer> iter = inPcNums.iterator(); 
		while(iter.hasNext()) { 
			this.pcNums.add(iter.next());
		}
	}
	
}