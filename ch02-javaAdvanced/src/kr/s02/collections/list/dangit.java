package kr.s02.collections.list;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
id_list	report	k	result
["muzi", "frodo", "apeach", "neo"]	["muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi"]	2	[2,1,1,0]
["con", "ryan"]	["ryan con", "ryan con", "ryan con", "ryan con"]	3	[0,0]
*/

public class dangit {
	public static void main(String[] args) {
		String[] id_list = {"muzi", "frodo", "apeach", "neo"};
		String[] report = { "muzi frodo","apeach frodo","frodo neo","muzi neo","apeach muzi" };
		int k = 2;
		Solution ss = new Solution();
		ss.solution(id_list, report, k);
	}
}

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = {};
        return answer;
    }
}