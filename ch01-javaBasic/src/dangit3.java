import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
sequence	k	result
[1, 2, 3, 4, 5]	7	[2, 3]
[1, 1, 1, 2, 3, 4, 5]	5	[6, 6]
[2, 2, 2, 2, 2]	6	[0, 2]
*/

public class dangit3 {
	public static void main(String[] args) {
		int[] sequence = { 1, 2, 3, 4, 5 };
		int k = 7;

		Solution ss = new Solution();
		ss.solution(sequence, k);
	}
}

class Solution {
	public int[] solution(int[] sequence, int k) {
		int[] answer = {-1,-1};
		List<Integer> list = new ArrayList<Integer>();
		
		for(int seq_num : sequence) {
			list.add(seq_num);
		}

		// k와 일치하는 요소가 있으면 바로 return
		if (list.indexOf(k) != -1) {
			int i = list.indexOf(k);
			answer[0] = i;
			answer[1] = i;
			return answer;
		}

		int result = 0;
		int start_idx = 0;
		for (int i = 0; i <= sequence.length - 1; i++) {
			
			// 요소가 k보다 큰 경우 return
			if(sequence[i] > k) {
				return answer;
			}
			
			result += list.get(i);
			if (result == k) {
				if ((answer[0] == -1) || (answer[1] - answer[0] > i - start_idx)) {
					answer[0] = start_idx;
					answer[1] = i;
					if((i - start_idx) == 1) {
						return answer;
					}
				}
			} else if (result > k) {
				result = 0;
				start_idx++;
				i = start_idx - 1;
			}
		}
		return answer;
	}
}