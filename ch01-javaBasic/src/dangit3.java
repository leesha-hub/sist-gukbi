import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

/*
예제	dartResult	answer	설명
1	1S2D*3T	37	11 * 2 + 22 * 2 + 33
2	1D2S#10S	9	12 + 21 * (-1) + 101
3	1D2S0T	3	12 + 21 + 03
4	1S*2T*3S	23	11 * 2 * 2 + 23 * 2 + 31
5	1D#2S*3S	5	12 * (-1) * 2 + 21 * 2 + 31
6	1T2D3D#	-4	13 + 22 + 32 * (-1)
7	1D2S3T*	59	12 + 21 * 2 + 33 * 2
*/

public class dangit3 {
	public static void main(String[] args) {
//		String dartResult = "1S2D*3T";
//		String dartResult = "1D2S#10S";
//		String dartResult = "1D2S0T";
//		String dartResult = "1S*2T*3S";
//		String dartResult = "1D#2S*3S";
//		String dartResult = "1T2D3D#";
//		String dartResult = "1D2S3T*";

		Solution ss = new Solution();
		ss.solution(dartResult);
	}
}

//class Solution {
//    public int solution(String dartResult) {
//        int answer = 0;
//        String[] dartFomularSplit = new String[3];
//        int[] dartFomularMake = new int[3];
//        
//        int splitCnt = 0;
//        int splitIdx = 0;
//        for(int i=0; i<=dartResult.length()-1; i++) {
//        	if(dartResult.charAt(i) == 'S' 
//        		|| dartResult.charAt(i) == 'D'
//        		|| dartResult.charAt(i) == 'T') {
//        		if(splitCnt == 2) { i=dartResult.length()-1; } // 3번째 수식 *,# 잘림 방지
//        		dartFomularSplit[splitCnt] = dartResult.substring(splitIdx, i+1);
//        		System.out.println(dartFomularSplit[splitCnt]);
//        		splitCnt ++;
//        		splitIdx = i+1;
//    		}
//    	}
//        
//        int makeCnt = 0;
//        for(int j=0; j<=dartFomularSplit.length-1; j++) {
//        	for(int k=0; k<=dartFomularSplit[j].length()-1; k++) {
//        		
//        	}
//        }
//        
//        return answer;
//    }
//}

class Solution {
    public int solution(String dartResult) {
        int answer = 0;
        
        Stack<Character> st = new Stack();
        
        //1D2S#10S
        for(int i=0; i<=dartResult.length()-1; i++) {
        	if(
    			((i+1) <= dartResult.length()-1) 
    			&& (dartResult.charAt(i) == '1' && dartResult.charAt(i+1) == '0')
			) {
        		// 10일때 X로 대체
        		st.add('X');
        		i++;
        	} else {
        		st.add(dartResult.charAt(i));
        	}
        }
        
        int makeCnt = 0;
        int[] dartFomularMake = new int[3];
        for(Character factor : st) {        	
        	if(factor == 'S' || factor == 'D' || factor == 'T') {
        		int powNum = 0;
        		if(factor == 'S') {
        			powNum = 1;
        		} else if(factor == 'D') {
        			powNum = 2;
        		} else if(factor == 'T') {
        			powNum = 3;
        		}
        		dartFomularMake[makeCnt] = (int) Math.pow(dartFomularMake[makeCnt], powNum);
        		makeCnt ++;
        	} else if (factor == '*' || factor == '#') {
        		if(factor == '*') { 
    				dartFomularMake[makeCnt-1] *= 2;
        			if(makeCnt-2 >= 0) {
        				dartFomularMake[makeCnt-2] *= 2;
        			}
        		} else {
        			dartFomularMake[makeCnt-1] *= -1;
        		}
        	} else {
        		if(factor == 'X') {
        			dartFomularMake[makeCnt] = 10;
        		} else {
        			dartFomularMake[makeCnt] = Integer.parseInt(String.valueOf(factor));
        		}
        	}
        }
        answer = dartFomularMake[0] + dartFomularMake[1] + dartFomularMake[2];
        return answer;
    }
}