/*
board	result
["O.X", ".O.", "..X"]	1
["OOO", "...", "XXX"]	0
["...", ".X.", "..."]	0
["...", "...", "..."]	1
*/

public class dangit2 {
	public static void main(String[] args) {
		String[] board = { "...D..R", ".D.G...", "....D.D", "D....D.", "..D...." };
//		String[] board = { ".D.R", "....", ".G..", "...D" };

		Solution ss = new Solution();
		ss.solution(board);
	}
}

class Solution {
    public int solution(String[] board) {
        int answer = 0;
        return answer;
    }
}