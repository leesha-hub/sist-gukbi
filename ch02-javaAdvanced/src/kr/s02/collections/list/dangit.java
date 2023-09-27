package kr.s02.collections.list;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3=	[0,0]
*/

public class dangit {
	public static void main(String[] args) {
		String[] id_list = {"con", "ryan"};
		String[] report = { "ryan con", "ryan con", "ryan con", "ryan con" };
		int k = 2;
		Solution ss = new Solution();
		ss.solution(id_list, report, k);
	}
}

class Solution {
	public int[] solution(String[] id_list, String[] report, int k) {
		int[] answer = new int[id_list.length];
		int[][] idReport = new int[id_list.length][id_list.length];
	
		for (String reportInfo : report) {
			String[] reportArr = reportInfo.split(" ");
			String reporter = reportArr[0];
			String reported = reportArr[1];
			int reporterIdx = 0;
			int reportedIdx = 0;
			for(int i=0; i<=id_list.length-1; i++) {
				System.out.println(id_list[i]);
				if(id_list[i].equals(reporter)) {
					reporterIdx = i;
				}
				if(id_list[i].equals(reported)) {
					reportedIdx = i;
				}
			}
			idReport[reporterIdx][reportedIdx] = 1; 
		}
		
		int reportCount = 0;
		int[] reporterIdxArr = new int[id_list.length];	
		for(int j=0; j<=id_list.length-1; j++) {
			for(int l= 0; l<=id_list.length-1; l++) {
				if(idReport[l][j] == 1) {
					reporterIdxArr[reportCount] = l;
					reportCount ++;
				}
			}
			if(reportCount >= k) {
				for(int i=0; i<=reportCount-1; i++) {
					answer[reporterIdxArr[i]] += 1;
				}
			}
			// 초기화
			reporterIdxArr = new int[id_list.length];
			reportCount = 0;
		}
		return answer;
	}
}