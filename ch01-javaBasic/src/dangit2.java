/*
picks	minerals	result
[1, 3, 2]	
["diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone"]	
12
[0, 1, 1]	
["diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond"]	
50
*/

public class dangit2 {
	public static void main(String[] args) {
//		int[] picks = { 1, 3, 2 };
		int[] picks = { 0, 1, 1 };
//		String[] minerals = { "diamond", "diamond", "diamond", "iron", "iron", "diamond", "iron", "stone" };
		String[] minerals = { "diamond", "diamond", "diamond", "diamond", "diamond", "iron", "iron", "iron", "iron", "iron", "diamond" };

		Solution ss = new Solution();
		ss.solution(picks, minerals);
	}
}

/*
 * 사용할 수 있는 곡괭이중 아무거나 하나를 선택해 광물을 캡니다. 
 * 한 번 사용하기 시작한 곡괭이는 사용할 수 없을 때까지 사용합니다. 
 * 광물은 주어진 순서대로만 캘 수 있습니다. 
 * 광산에 있는 모든 광물을 캐거나, 
 * 더 사용할 곡괭이가 없을 때까지 광물을 캡니다.
 */
class Solution {
	public int solution(int[] picks, String[] minerals) {
		int answer = 0;
		
		/* 광산에 있는 모든 광물을 캐거나, 
		사용할 곡괭이가 없을 때까지 광물을 캠 */
		int minePossibleLength = 0;
		int selectionRowLength = 3;
		for(int pickCheck : picks) {
			if(pickCheck != 0) {
				minePossibleLength += pickCheck;
			} else {
				selectionRowLength --;
			}
		}
		minePossibleLength *= 5; // 곡괭이로 팔수 있는 minerals 수
		
		int minePossibleLimit = (minePossibleLength >= minerals.length) ? minerals.length : minePossibleLength;
		
		int selectionColumnLength = (minePossibleLimit%5 > 0) ? minePossibleLimit/5 + 1  : minePossibleLimit/5;
		int[][] mineSelection = new int[3][selectionColumnLength];
		int selectionColumnCount = 0;
		int diaFatigueCheck  = 0;
		int ironFatigueCheck = 0;
		int stoneFatigueCheck = 0;
		
		for (int i = 0; i < minePossibleLimit; i++) {	
			if(minerals[i].equals("diamond")) {
				diaFatigueCheck += 1;
				ironFatigueCheck += 5;
				stoneFatigueCheck += 25;
			} else if(minerals[i].equals("iron")) {
				diaFatigueCheck += 1;
				ironFatigueCheck += 1;
				stoneFatigueCheck += 5;
			} else {
				diaFatigueCheck += 1;
				ironFatigueCheck += 1;
				stoneFatigueCheck += 1;
			}
			
			if(i%5 == 4 || i == (minePossibleLimit-1)) {
				mineSelection[0][selectionColumnCount] = diaFatigueCheck;
				mineSelection[1][selectionColumnCount] = ironFatigueCheck;
				mineSelection[2][selectionColumnCount] = stoneFatigueCheck;
				diaFatigueCheck = 0;
				ironFatigueCheck = 0;
				stoneFatigueCheck = 0;
				selectionColumnCount ++;
			}
		}
		
		int max = 0;
		int maxIdx = 0;
		int stone_max = 0; 
		int stone_maxIdx = 0;
		int count = 0; // 5개 광물 점수 계산시마다 count ++
		int k = 0;
		
		while(count < selectionColumnLength) {
			for (k = 0; k < selectionColumnLength; k++) {
				if (picks[0] != 0 && mineSelection[1][k] > max) {
					max = mineSelection[1][k];
					maxIdx = k;
				} else {
					if (mineSelection[2][k] != 0 && mineSelection[2][k] > stone_max) {
						stone_max = mineSelection[2][k];
						stone_maxIdx = k;
					}
				}
			}
		
			if(max > 0) {
				answer += mineSelection[0][maxIdx];
				mineSelection[1][maxIdx] = 0;
				picks[0]--;
				
				// 초기화
				max = 0;
				maxIdx = 0;
			} else {
				if (picks[1] != 0) {
					if(mineSelection[1][stone_maxIdx] != 0) {
						answer += mineSelection[1][stone_maxIdx];
						mineSelection[2][stone_maxIdx] = 0;
						picks[1]--;
					} else {
						mineSelection[2][stone_maxIdx] = 0;
						count --;
					}
				} else if (picks[2] != 0) {
					answer += mineSelection[2][stone_maxIdx];
					mineSelection[2][stone_maxIdx] = 0;
					picks[2]--;
				}
				// 초기화
				stone_max = 0;
				stone_maxIdx = 0;
			}
			
			count++;
			if (count < selectionColumnLength) {
				k = 0;
			}
			
		}
		return answer;
	}
}