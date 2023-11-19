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
		minePossibleLength *= 5; // 곡괭이로 팔수 있는 mine 수
		
		int minePossibleLimit = (minePossibleLength >= minerals.length) ? minerals.length : minePossibleLength;
		System.out.println(minePossibleLimit);
		/*
		 * [0][x] = dia
		 * [1][x] = iron
		 * [3][x] = stone
		 * */
		int[][] fatique = {
				//다이아 철 돌
	 /*다이아*/   {1}, {1}, {1},
		 /*철*/   {5}, {1}, {1},
		 /*돌*/   {25}, {5}, {1}
		};
		
		int selectionColumnLength = (minePossibleLimit%5 > 0) ? minePossibleLimit/5 + 1  : minePossibleLimit/5;
		int[][] mineSelection = new int[selectionRowLength][selectionColumnLength];
		
		System.out.println("selectionLength x : " + selectionRowLength);
		System.out.println("selectionLength y : " + selectionColumnLength);
		int selectionRowCount = 0;
		int selectionColumnCount = 0;
		int fatiqueCheck = 0;
		for (int i = 0; i < minePossibleLimit; i++) {
			if(picks[0] != 0) {
				// 다이아는 모든 광물을 +1 로 캘수 있음
				fatiqueCheck += 1;
			}
			if(picks[1] != 0) {
				if(minerals[i].equals("diamond")) {
					fatiqueCheck += 5;
				} else {
					fatiqueCheck += 1;
				}
			}
			if(picks[2] != 0) {
				if(minerals[i].equals("diamond")) {
					fatiqueCheck += 25;
				} else if(minerals[i].equals("iron")) {
					fatiqueCheck += 5;
				} else {
					fatiqueCheck += 1;
				}
			}	
		}
		return answer;
	}
}