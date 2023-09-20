package kr.s02.collections.list;

import java.util.HashMap;
import java.util.Map;

/*
survey	choices	result
["AN", "CF", "MJ", "RT", "NA"]	[5, 3, 2, 7, 5]	"TCMA"
["TR", "RT", "TR"]	[7, 1, 3]	"RCJA"
*/

public class dangit {
	public static void main(String[] args) {
		String[] survey = { "TR", "RT", "TR" };
		int[] choices = { 7, 1, 3 };
		Solution ss = new Solution();
		ss.solution(survey, choices);
	}
}

class Solution {
	public String solution(String[] survey, int[] choices) {
		String answer = "";

		Map<String, Integer> mp = new HashMap<String, Integer>();
		String[] priorityFirst = { "R", "C", "J", "A" };
		String[] prioritySecond = { "T", "F", "M", "N" };
		
		mp.put("R", 0);
		mp.put("T", 0);
		mp.put("C", 0);
		mp.put("F", 0);
		mp.put("J", 0);
		mp.put("M", 0);
		mp.put("A", 0);
		mp.put("N", 0);

		int i = 0;
		for(int agree : choices) {
			int agreePoint = 0;
			if(agree < 4) {
				agreePoint = mp.get(survey[i].substring(0,1)) + agree;
				mp.put(survey[i].substring(0,1), agreePoint);
			} else if (agree > 4) {
				agreePoint = mp.get(survey[i].substring(1,2)) + (agree-4);
				mp.put(survey[i].substring(1,2), agreePoint);
			}
			i++;
		}
		
		for(int j=0; j<=3; j++) {
			if(mp.get(priorityFirst[j]) >= mp.get(prioritySecond[j]))
			{
				answer += priorityFirst[j];
			} else {
				answer += prioritySecond[j];
			}
		}
		System.out.println(answer);
		return answer;
	}
}