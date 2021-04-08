package lv1;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

/**
 * 
 *  - 일시 : 2021년 04월 09일
 *  - 링크 : https://programmers.co.kr/learn/courses/30/lessons/12901
 *	  
 */
public class Lv1_12901 {
	public static void main(String[] args) throws IOException {
		
		int a = 12;
		int b = 17;
		Solution12901 tmp = new Solution12901();
		System.out.println(tmp.solution(a, b));

	}

}

class Solution12901 {
	public String solution(int a, int b) {
        int startDay = 6;
        int days = 0;
        
        Map<Integer, String> yoil = new HashMap<Integer, String>();
        Map<Integer, Integer> monthDays = new HashMap<Integer, Integer>();
        
        monthDays.put(1, 31);
        monthDays.put(2, 29);
        monthDays.put(3, 31);
        monthDays.put(4, 30);
        monthDays.put(5, 31);
        monthDays.put(6, 30);
        monthDays.put(7, 31);
        monthDays.put(8, 31);
        monthDays.put(9, 30);
        monthDays.put(10, 31);
        monthDays.put(11, 30);

        yoil.put(1, "SUN");
        yoil.put(2, "MON");
        yoil.put(3, "TUE");
        yoil.put(4, "WED");
        yoil.put(5, "THU");
        yoil.put(6, "FRI");
        yoil.put(7, "SAT");
        
        
        while(a > 1) {
        	days += monthDays.get(a-1);
        	a--;
        }
        
        days += (b-1);        
        days = days%7;        
        startDay = (startDay + days)%7 == 0 ? 7 : (startDay + days)%7;
               
        return yoil.get(startDay);
    }
}
