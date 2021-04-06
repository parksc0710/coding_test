package stackQue;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  - 일시 : 2021년 04월 06일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42583
 *	  
 */
public class StackQue_42583 {
	public static void main(String[] args) throws IOException {
		
		int bridge_length = 2;
		int weight = 10;
		int[] truck_weights = {7,4,5,6};
		Solution42583 tmp = new Solution42583();
		System.out.println(tmp.solution(bridge_length, weight, truck_weights));

	}

}

class Solution42583 {
	int cursor = 0;
	int weightSum = 0;
	boolean isEnd = false;
		
	public int solution(int bridge_length, int weight, int[] truck_weights) {
        int answer = 0;
    	
    	Map<Integer, Truck> truckMap = new HashMap<Integer, Truck>();
    	
    	
        while(!isEnd) {
        	
        	if(cursor == 0) {
        		weightSum += truck_weights[cursor];
        		truckMap.put(cursor, new Truck(truck_weights[cursor], bridge_length, cursor));
        		cursor++;
        		
        	} else if(cursor == truck_weights.length) {
        		
        		truckMap = process(truckMap);
        		
        	} else if(cursor != truck_weights.length){
        		truckMap = process(truckMap);
        		if(weightSum + truck_weights[cursor] <= weight) {
        			
        			weightSum += truck_weights[cursor];
            		truckMap.put(cursor, new Truck(truck_weights[cursor], bridge_length, cursor));
            		cursor++;
            		
        		} 
        		
        	}
        	
        	answer++;
        	
        	if(weightSum == 0 && cursor == truck_weights.length) {
    			isEnd = true;
    		}
        }
        
        return answer;
    }
	
	private Map<Integer, Truck> process(Map<Integer, Truck> map) {
		
		Map<Integer, Truck> rtn = map;
		
		for(Integer tmpCursor : map.keySet()) {
			Truck tmpTruck = map.get(tmpCursor);
			int tmpLeftLength = tmpTruck.leftLength - 1;
			tmpTruck.leftLength = tmpLeftLength;
			map.put(tmpCursor, tmpTruck);
			if(tmpLeftLength == 0) {
				weightSum = weightSum - map.get(tmpCursor).weight;
			}
		}
		
		return rtn;
		
	}
}

class Truck {
	int weight;
	int leftLength;
	int order;
	
	public Truck(int weight, int leftLength, int order) {
		super();
		this.weight = weight;
		this.leftLength = leftLength;
		this.order = order;
	}
}
