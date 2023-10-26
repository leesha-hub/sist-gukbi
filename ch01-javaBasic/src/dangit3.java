import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/*
targets	result
[[4,5],[4,8],[10,14],[11,13],[5,12],[3,7],[1,4]]	3
*/

public class dangit3 {
	public static void main(String[] args) {
		int[][] targets = { { 4, 5 }, { 4, 8 }, { 10, 14 }, { 11, 13 }, { 5, 12 }, { 3, 7 }, { 1, 4 } };

		Solution ss = new Solution();
		ss.solution(targets);
	}
}

class Solution {
    public int solution(int[][] targets) {
        int answer = 0;
        
        Arrays.sort(targets, (o1, o2) -> {
            return o1[0]-o2[0]; // 첫번째 숫자 기준 오름차순 {1,30}{2,10}{3,50}{4,20}{5,40}
        });
        
        for(int i=0; i<=targets.length-1; i++) {
        	System.out.println("targets[" + i + "][0] : " + targets[i][0] + " targets[" + i + "][1] : " + targets[i][1]);
        }
        return answer;
    }
}