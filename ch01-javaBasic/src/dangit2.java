/*
board	result
["O.X", ".O.", "..X"]	1
["OOO", "...", "XXX"]	0
["...", ".X.", "..."]	0
["...", "...", "..."]	1
*/

public class dangit2 {
	public static void main(String[] args) {
//		String[] board = { "O.X", ".O.", "..X" };
//		String[] board = { "OOO", "...", "XXX" };
//		String[] board = { "...", ".X.", "..." };
//		String[] board = { "O..", "O..", "O.." };
		String[] board = { "XO.", "OXO", "XOX" };
//		String[] board = { "OOO", "XOX", "XXO" };

		Solution ss = new Solution();
		ss.solution(board);
	}
}

class Solution {
	public int solution(String[] board) {
		int answer = 1;
		char[][] boardRenew = new char[3][3];

		int batFirstCount = 0;
		int batSecondCount = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				boardRenew[i][j] = board[i].charAt(j);
				if (boardRenew[i][j] == 'O') {
					batFirstCount++;
				} else if (boardRenew[i][j] == 'X') {
					batSecondCount++;
				}
			}
		}

		// 1. X > O *후공이 더 나와있는 상태
		if (batSecondCount > batFirstCount) {
			answer = 0;
			return answer;
		}
		
		// 2. 후공이 없는데, 선공이 두개 이상 나와있는 상태
		if (batSecondCount == 0 && batFirstCount > 1) {
			answer = 0;
			return answer;
		}
		
		// 3. 차이가 1 이상
		if (Math.abs(batFirstCount-batSecondCount) > 1) {
			answer = 0;
			return answer;
		}

		/*
		 * 4. 가로 OR 세로 OR 대각선 빙고시 게임종료 
		 * ㄴ 이때 서로 같거나 한쪽이 크면 FALSE
		 */
		boolean bingoFirstYN = true;
		boolean bingoSecondYN = true;
		if (board[0].equals("OOO") || board[1].equals("OOO") || board[2].equals("OOO")) {
			bingoFirstYN = true;
		} else if (board[0].equals("XXX") || board[1].equals("XXX") || board[2].equals("XXX")) {
			bingoSecondYN = true;
		} else if (("" + boardRenew[0][0] + boardRenew[1][0] + boardRenew[2][0]).equals("OOO")
				|| ("" + boardRenew[0][1] + boardRenew[1][1] + boardRenew[2][1]).equals("OOO")
				|| ("" + boardRenew[0][2] + boardRenew[1][2] + boardRenew[2][2]).equals("OOO")) {
			bingoFirstYN = true;
		} else if (("" + boardRenew[0][0] + boardRenew[1][0] + boardRenew[2][0]).equals("XXX")
				|| ("" + boardRenew[0][1] + boardRenew[1][1] + boardRenew[2][1]).equals("XXX")
				|| ("" + boardRenew[0][2] + boardRenew[1][2] + boardRenew[2][2]).equals("XXX")) {
			bingoSecondYN = true;
		} else if (("" + boardRenew[0][0] + boardRenew[1][1] + boardRenew[2][2]).equals("OOO")
				|| ("" + boardRenew[0][2] + boardRenew[1][1] + boardRenew[2][0]).equals("OOO")) {
			bingoFirstYN = true;
		} else if (("" + boardRenew[0][0] + boardRenew[1][1] + boardRenew[2][2]).equals("XXX")
				|| ("" + boardRenew[0][2] + boardRenew[1][1] + boardRenew[2][0]).equals("XXX")) {
			bingoSecondYN = true;
		} else {
			bingoFirstYN = false;
			bingoSecondYN = false;
		}
		
		if(bingoFirstYN == true) {
			if(batFirstCount >= batSecondCount) {
				answer = 0;
			}
		}
		
		if(bingoSecondYN == true) {
			if(batSecondCount >= batFirstCount) {
				answer = 0;
			}
		}
		System.out.println(answer);
		return answer;
	}
}