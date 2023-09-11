import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/*
board	moves	result
[[0,0,0,0,0],[0,0,1,0,3],[0,2,5,0,1],[4,2,4,4,2],[3,5,1,3,1]]	[1,5,3,5,1,2,1,4]	4
*/

public class dangit3 {
	public static void main(String[] args) {
		int n = 5;
		int[][] board = new int[][]{{0,0,0,0,0},{0,0,1,0,3},{0,2,5,0,1},{4,2,4,4,2},{3,5,1,3,1}};
		int[] move = {1,5,3,5,1,2,1,4};

		Solution ss = new Solution();
		ss.solution(board, move);
	}
}

class Solution {
    public int solution(int[][] board, int[] moves) {
        int answer = 0;

        int[] basket = new int[moves.length];
        int moveNumber = 0;
        int basketIdx = 0;
        for(int moveLine : moves) {
            for(int i=0; i<=board[moveLine-1].length-1; i++) {
                if(board[i][moveLine-1] != 0) {
                    moveNumber = board[i][moveLine-1];
                    board[i][moveLine-1] = 0;
                    basket[basketIdx] = moveNumber;

                    // basket 중복 여부 확인
                    if(basketIdx > 0) {
                        if(basket[basketIdx] == basket[basketIdx-1]) {
                            basketIdx -= 2;
                            answer += 2;
                        } 
                    }
                    basketIdx ++;
                    break;
                }
            }
        }
        return answer;
    }
}