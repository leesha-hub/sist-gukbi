import java.util.Arrays;

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
//		int[] lost = {2,4};
//		int[] reserve = {1,3,5};
//		int n = 5;
		
//		int[] lost = {2,4};
//		int[] reserve = {3};
//		int n = 5;
//		
//		int[] lost = {3};
//		int[] reserve = {1};
//		int n = 3;
		
		int[] lost = {4,5};
		int[] reserve = {4,3};
		int n = 5;

		Solution ss = new Solution();
		ss.solution(n, lost, reserve);
	}
}

class Solution {
	public int solution(int n, int[] lost, int[] reserve) {
		int answer = 0;
        
        Arrays.sort(lost);
        Arrays.sort(reserve);

		int[] list = new int[n];
		for (int i = 0; i <= n-1; i++) {
			if (i <= lost.length - 1) {
				list[lost[i] - 1] = -1;
			}
			if (i <= reserve.length - 1) {
				list[reserve[i] - 1] = 2;
			} 
			if(list[i] == 0) {
				list[i] = 1;
			}
		}
		
		for (int j = 0; j <= lost.length - 1; j++) {
			boolean borrowYN = false;
			
			// 도난 당한 사람 중 여벌 있는 경우 check
			int findIndex = Arrays.binarySearch(reserve, lost[j]);
			if(findIndex > 0) {
				list[reserve[findIndex]-1] = 1;
			}
			// 앞 확인
			if (lost[j] > 1) {
				if (list[lost[j] - 2] == 2) {
					list[lost[j] - 1] = 1;
					list[lost[j] - 2] = 1;
					borrowYN = true;
                    continue;
				}
			}
			// 뒤 확인
			if (!borrowYN && lost[j] < list.length) {
				if (list[lost[j]] == 2) {
					list[lost[j] - 1] = 1;
					list[lost[j]] = 1;
					borrowYN = true;
                    continue;
				}
			}
		}
		
		for (int i = 0; i <= list.length - 1; i++) {
			if (list[i] > 0) {
				answer++;
			}
		}
		return answer;
	}
}