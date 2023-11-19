//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
///*
//과제는 시작하기로 한 시각이 되면 시작합니다.
//새로운 과제를 시작할 시각이 되었을 때, 
//
//기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 
//새로운 과제를 시작합니다.
//
//진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 
//멈춰둔 과제를 이어서 진행합니다.
//
//만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 
//잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.
//
//멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
//plans	result
//[["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	["korean", "english", "math"]
//[["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
//[["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]	["bbb", "ccc", "aaa"]
//*/
//
//public class dangit3 {
//	public static void main(String[] args) {
//		String[][] plans = {
////				{ "korean", "11:40", "30" }, 
////				{ "english", "12:10", "20" }, 
////				{ "math", "12:30", "40" } }; 
//				
//				{ "music", "12:20", "40" }, { "computer", "12:30", "100" }, { "science", "12:40", "50" },
//				{ "history", "14:00", "30" }, };
////				
////				{"aaa", "12:00", "20"},
////				{"bbb", "12:10", "30"},
////				{"ccc", "12:40", "10"} };
//		Solution ss = new Solution();
//		ss.solution(plans);
//	}
//}
//
//import java.util.Arrays;
//import java.util.Calendar;
//import java.util.LinkedHashMap;
//import java.util.Map;
//import java.util.Map.Entry;
//
//class Solution {
//	public String[] solution(String[][] plans) {
//		String[] answer = new String[plans.length];
//
//		// plans[x][1] 기준으로 정렬
//		Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));
//
//		String[] planFinishSubject = new String[plans.length];
//		Map<String, Integer> planLeftSubject = new LinkedHashMap<String, Integer>();
//		
//		int finishCount = 0; // answer index
//		long difference = 0; // 앞/뒤 시간차
//		int planLeftTime = 0; // 강의를 듣고 남은 시간
//		Calendar planTimeBefore = Calendar.getInstance(); // 앞시간 수업
//		Calendar planTimeAfter = Calendar.getInstance(); // 다음시간 수업
//		for (int i = 0; i < plans.length; i++) {
//			if (i < plans.length - 1) {
//				String[] planTimeCompare1 = plans[i][1].split(":");
//				String[] planTimeCompare2 = plans[i + 1][1].split(":");
//
//				planTimeBefore.set(2023, 11, 15, Integer.parseInt(planTimeCompare1[0]),Integer.parseInt(planTimeCompare1[1]));
//				planTimeAfter.set(2023, 11, 15, Integer.parseInt(planTimeCompare2[0]),Integer.parseInt(planTimeCompare2[1]));
//
//				difference = (planTimeAfter.getTimeInMillis() - planTimeBefore.getTimeInMillis()) / 60000;
//				planLeftTime = (int) (difference - Integer.parseInt(plans[i][2]));
//				
//				// 앞시간 수업이 다음시간 전에 끝날 경우
//				if (planLeftTime >= 0) {
//					planFinishSubject[finishCount] = plans[i][0];
//					finishCount++;
//				// 앞시간 수업이 다음시간 전에 끝나지 못하는 경우
//				} else {
//					planLeftSubject.put(plans[i][0], Math.abs(planLeftTime));
//				}
//				
//				while (planLeftSubject.size() > 0 && planLeftTime > 0) {
//					Entry<String, Integer> leftSubject = (Entry<String, Integer>) planLeftSubject.entrySet().toArray()[planLeftSubject.size() - 1];
//					if (planLeftTime - leftSubject.getValue() >= 0) {
//						planFinishSubject[finishCount] = leftSubject.getKey();
//						finishCount++;
//						planLeftTime -= leftSubject.getValue();
//						planLeftSubject.remove(leftSubject.getKey());
//					} else {
//						planLeftTime -= leftSubject.getValue();
//						planLeftSubject.put(leftSubject.getKey(), Math.abs(planLeftTime));
//						break;
//					}
//				}
//			} else {
//				// 마지막 수업은 문제 없이 끝남
//				planFinishSubject[finishCount] = plans[i][0];
//				finishCount++;
//
//				while (planLeftSubject.size() > 0) {
//					Entry<String, Integer> leftSubject = (Entry<String, Integer>) planLeftSubject.entrySet().toArray()[planLeftSubject.size() - 1];
//					planFinishSubject[finishCount] = leftSubject.getKey();
//					finishCount++;
//					planLeftSubject.remove(leftSubject.getKey());
//				}
//			}
//		}
//		answer = planFinishSubject;
//		return answer;
//	}
//}