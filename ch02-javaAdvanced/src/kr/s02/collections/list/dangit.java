package kr.s02.collections.list;

import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
today	terms	privacies	result
"2022.05.19"	["A 6", "B 12", "C 3"]	["2021.05.02 A", "2021.07.01 B", "2022.02.19 C", "2022.02.20 C"]	[1, 3]
"2020.01.01"	["Z 3", "D 5"]	["2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z"]	[1, 4, 5]
*/

public class dangit {
	public static void main(String[] args) {
		String today = "2020.01.01";
		String[] terms = { "Z 3", "D 5" };
		String[] privacies = { "2019.01.01 D", "2019.11.15 Z", "2019.08.02 D", "2019.07.01 D", "2018.12.28 Z" };
		Solution ss = new Solution();
		ss.solution(today, terms, privacies);
	}
}

class Solution {
	public int[] solution(String today, String[] terms, String[] privacies) {
		List<Integer> answer = new ArrayList<Integer>();
		Map<String, Integer> termsMap = new HashMap<String, Integer>();

		for (String term : terms) {
			String[] termSplitArr = term.split(" ");
			termsMap.put(termSplitArr[0], Integer.parseInt(termSplitArr[1]));
		}

		String[] todaySplit = today.split("\\.");
		int todayYear = Integer.parseInt(todaySplit[0]);
		int todayMonth = Integer.parseInt(todaySplit[1]);
		int todayDay = Integer.parseInt(todaySplit[2]);
		int i = 0;
		for (String privacy : privacies) {
			String[] privacySplitArr = privacy.split(" ");
			String[] privacyCollectDay = privacySplitArr[0].split("\\.");
			int collectYear = Integer.parseInt(privacyCollectDay[0]);
			int collectMonth = Integer.parseInt(privacyCollectDay[1]);
			int CollectDay = Integer.parseInt(privacyCollectDay[2]);

			String privacyTerm = privacySplitArr[1];

			int termsDate = (termsMap.get(privacyTerm)*28)-1;
			if(CollectDay == 1) {
				collectMonth += termsMap.get(privacyTerm)-1;
				CollectDay = 28;
			}
			
			System.out.println("termsDate : " + termsDate);
		
			Date date1 = new Date(todayYear, todayMonth, todayDay);
			Date date2 = new Date(collectYear, collectMonth, CollectDay);
			int result = date1.compareTo(date2);
			if (result > 0) {
				answer.add(i + 1);
			}
			i++;
		}
		return answer.stream().mapToInt(integer -> integer).toArray();
	}
}