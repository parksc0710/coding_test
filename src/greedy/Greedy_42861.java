package greedy;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 
 *  - 일시 : 2021년 06월 08일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/42861
 *     
 */
public class Greedy_42861 {
   public static void main(String[] args) throws IOException {
      int n = 6;
      //int[][] costs = {{0,1,1},{0,2,2},{1,2,5},{1,3,1},{2,3,8}};
      //int[][] costs = {{0,1,1},{3,4,1},{1,2,2},{2,3,4}};
      int[][] costs = {{0,1,5},{0,3,2},{0,4,3},{1,4,1},{3,4,10},{1,2,2},{2,5,3},{4,5,4}};
      Solution42861 tmp = new Solution42861();
      System.out.println(tmp.solution(n, costs));

   }

}

class Solution42861 {
   public int solution(int n, int[][] costs) {
        int answer = 0;
        
        // cost별 오름차순 정렬
        Arrays.sort(costs, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
               return o1[2] - o2[2];
            }
        });
        
        // 다리 연결 List
        List<Set<Integer>> bridgeList = new ArrayList<Set<Integer>>();
        
        // costs 돌면서 섬 연결
        for(int i = 0; i < costs.length; i++) {
           int tmpNum1 = costs[i][0];
           int tmpNum2 = costs[i][1];
           
           if(bridgeList.size()==0) {
              // 최초 1회 삽입
              Set<Integer> tmpSet = new HashSet<Integer>();
              tmpSet.add(tmpNum1);
              tmpSet.add(tmpNum2);
              bridgeList.add(tmpSet);
              answer += costs[i][2];
           } else {
              
              boolean inFlag = false;
              boolean dupleFlag = false;
              for(int j = 0; j < bridgeList.size(); j++) {
                  
            	  if(bridgeList.get(j) != null) {
            		  if(j == 0 && bridgeList.get(j).contains(tmpNum1) && bridgeList.get(j).contains(tmpNum2)) {
                          // 둘 다 연결되어있으면 pass
            			  dupleFlag = true;
                          break;
                       } else if(bridgeList.get(j).contains(tmpNum1) && !bridgeList.get(j).contains(tmpNum2)){
                          inFlag = true;
                          boolean checkFlg = false;
                          // 둘 중 하나만 연결되어있으면 다른 다리가 있는지 체크 후 있으면 합치기 없으면 추가
                          for(int k = 0; k < bridgeList.size(); k++) {
                             if(bridgeList.get(k).contains(tmpNum2)) {
                                Set<Integer> removeSet = new HashSet<Integer>();
                                removeSet.addAll(bridgeList.get(k));
                                for(int key : removeSet) {
                                   bridgeList.get(j).add(key);
                                   bridgeList.get(k).remove(key);
                                }
                                bridgeList.get(k).clear();
                                checkFlg = true;
                             }
                          }
                          if(!checkFlg) {
                             bridgeList.get(j).add(tmpNum2);
                          }
                          answer += costs[i][2];
                       } else if(!bridgeList.get(j).contains(tmpNum1) && bridgeList.get(j).contains(tmpNum2)){
                          inFlag = true;
                          boolean checkFlg = false;
                          // 둘 중 하나만 연결되어있으면 다른 다리가 있는지 체크 후 있으면 합치기 없으면 추가
                          for(int k = 0; k < bridgeList.size(); k++) {
                             if(bridgeList.get(k).contains(tmpNum1)) {
                             	Set<Integer> removeSet = new HashSet<Integer>();
                                 removeSet.addAll(bridgeList.get(k));
                                for(int key : removeSet) {
                                	// 전체가 다 안나오는 현상 체크하기
                                   bridgeList.get(j).add(key);
                                   bridgeList.get(k).remove(key);
                                }
                                bridgeList.get(k).clear();
                                checkFlg = true;
                             }
                          }
                          if(!checkFlg) {
                             bridgeList.get(j).add(tmpNum1);
                          }
                          answer += costs[i][2];
                       }
            	  }
                  
               }
              
              if(!inFlag && !dupleFlag) {
                 Set<Integer> tmpSet = new HashSet<Integer>();
                  tmpSet.add(tmpNum1);
                  tmpSet.add(tmpNum2);
                  bridgeList.add(tmpSet);
                  answer += costs[i][2];
              }
           }
           
        }
        
        //System.out.println(Arrays.deepToString(costs));
        
        return answer;
    }
}