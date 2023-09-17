package kr.s02.collections.list;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 문제 설명
수포자는 수학을 포기한 사람의 준말입니다. 수포자 삼인방은 모의고사에 수학 문제를 전부 찍으려 합니다. 수포자는 1번 문제부터 마지막 문제까지 다음과 같이 찍습니다.

1번 수포자가 찍는 방식: 1, 2, 3, 4, 5, 1, 2, 3, 4, 5, ...
2번 수포자가 찍는 방식: 2, 1, 2, 3, 2, 4, 2, 5, 2, 1, 2, 3, 2, 4, 2, 5, ...
3번 수포자가 찍는 방식: 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, 3, 3, 1, 1, 2, 2, 4, 4, 5, 5, ...

1번 문제부터 마지막 문제까지의 정답이 순서대로 들은 배열 answers가 주어졌을 때, 가장 많은 문제를 맞힌 사람이 누구인지 배열에 담아 return 하도록 solution 함수를 작성해주세요.

제한 조건
시험은 최대 10,000 문제로 구성되어있습니다.
문제의 정답은 1, 2, 3, 4, 5중 하나입니다.
가장 높은 점수를 받은 사람이 여럿일 경우, return하는 값을 오름차순 정렬해주세요.
입출력 예
answers	return
[1,2,3,4,5]	[1]
[1,3,2,4,2]	[1,2,3]
*/

public class dangit {
	public static void main(String[] args) {
		int[] answer = { 1, 2, 3, 4, 5 };
//		int[] answer = { 1, 3, 2, 4, 2 };
		Solution ss = new Solution();
		ss.solution(answer);
	}
}


//class Solution {
//	public int[] solution(int[] answers) {
//		int[] answer = {};
//		int[][] supoza = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
//		int[][] supozaJumsu = { { 1, 0 }, { 2, 0 }, { 3, 0 } };
//
//		int jumsu = 0;
//		int dup_chk = 1;
//		for (int i = 0; i <= supoza.length - 1; i++) {
//			int divideN = supoza[i].length;
//			for (int j = 0; j <= answers.length - 1; j++) {
//				if (answers[j] == (supoza[i][j % divideN])) {
//					jumsu++;
//				}
//			}
//			supozaJumsu[i][1] = jumsu;
//			jumsu = 0;
//		}
//
//		// 1열(두 번째 열)을 기준으로 정렬
//		Arrays.sort(supozaJumsu, new Comparator<int[]>() {
//			@Override
//			public int compare(final int[] entry1, final int[] entry2) {
//				// entry1[1]과 entry2[1]을 비교하여 오름차순 정렬
//				return Integer.compare(entry2[1], entry1[1]);
//			}
//		});
//
//		// 동점 있는지 확인
//		for (int i = 0; i < supozaJumsu.length; i++) {
//			if (i == 0) {
//				answer = new int[3];
//				answer[i] = supozaJumsu[i][0];
//			} else {
//				if (answer[i - 1] == answer[i]) {
//					answer[i] = supozaJumsu[i][0];
//				} 
//			}
//		}
//		return answer;
//	}
//}


class Solution {
	public int[] solution(int[] answers) {
		int[] answer = {};
		int[][] supoza = { { 1, 2, 3, 4, 5 }, { 2, 1, 2, 3, 2, 4, 2, 5 }, { 3, 3, 1, 1, 2, 2, 4, 4, 5, 5 } };
		int[][] supozaJumsu = { { 1, 0 }, { 2, 0 }, { 3, 0 } };

		int jumsu = 0;
		int dup_chk = 1;
		for (int i = 0; i <= supoza.length - 1; i++) {
			int divideN = supoza[i].length;
			for (int j = 0; j <= answers.length - 1; j++) {
				if (answers[j] == (supoza[i][j % divideN])) {
					jumsu++;
				}
			}
			supozaJumsu[i][1] = jumsu;
			if(i > 0) {
				if(supozaJumsu[i-1][1] == supozaJumsu[i][1]) {
					dup_chk ++;
				} 
			}
			jumsu = 0;
		}

		// 1열(두 번째 열)을 기준으로 정렬
		Arrays.sort(supozaJumsu, new Comparator<int[]>() {
			@Override
			public int compare(final int[] entry1, final int[] entry2) {
				// entry1[1]과 entry2[1]을 비교하여 오름차순 정렬
				return Integer.compare(entry2[1], entry1[1]);
			}
		});

		// 동점 있는지 확인
		if ((supozaJumsu[0][1] == supozaJumsu[1][1]) && (supozaJumsu[0][1] == supozaJumsu[2][1])) {
			answer = new int[3];
			answer[0] = supozaJumsu[0][0];
			answer[1] = supozaJumsu[1][0];
			answer[2] = supozaJumsu[2][0];
		} else if (supozaJumsu[0][1] == supozaJumsu[1][1]) {
			answer = new int[2];
			answer[0] = supozaJumsu[0][0];
			answer[1] = supozaJumsu[1][0];
		} else {
			answer = new int[1];
			answer[0] = supozaJumsu[0][0];
		}
		return answer;
	}
}