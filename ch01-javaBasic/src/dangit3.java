import java.util.Arrays;
import java.util.Calendar;
import java.util.Comparator;

/*
과제는 시작하기로 한 시각이 되면 시작합니다.
새로운 과제를 시작할 시각이 되었을 때, 

기존에 진행 중이던 과제가 있다면 진행 중이던 과제를 멈추고 
새로운 과제를 시작합니다.

진행중이던 과제를 끝냈을 때, 잠시 멈춘 과제가 있다면, 
멈춰둔 과제를 이어서 진행합니다.

만약, 과제를 끝낸 시각에 새로 시작해야 되는 과제와 
잠시 멈춰둔 과제가 모두 있다면, 새로 시작해야 하는 과제부터 진행합니다.

멈춰둔 과제가 여러 개일 경우, 가장 최근에 멈춘 과제부터 시작합니다.
plans	result
[["korean", "11:40", "30"], ["english", "12:10", "20"], ["math", "12:30", "40"]]	["korean", "english", "math"]
[["science", "12:40", "50"], ["music", "12:20", "40"], ["history", "14:00", "30"], ["computer", "12:30", "100"]]	["science", "history", "computer", "music"]
[["aaa", "12:00", "20"], ["bbb", "12:10", "30"], ["ccc", "12:40", "10"]]	["bbb", "ccc", "aaa"]
*/

public class dangit3 {
	public static void main(String[] args) {
		String[][] plans = {
//				{ "korean", "11:40", "30" }, 
//				{ "english", "12:10", "20" }, 
//				{ "math", "12:30", "40" } 

				{ "science", "12:40", "50" }, { "music", "12:20", "40" }, { "history", "14:00", "30" },
				{ "computer", "12:30", "100" } };
		Solution ss = new Solution();
		ss.solution(plans);
	}
}

class Solution {
	public String[] solution(String[][] plans) {
		String[] answer = new String[plans.length];

		Arrays.sort(plans, (o1, o2) -> o1[1].compareTo(o2[1]));

		Calendar planTimeBefore = Calendar.getInstance();
		Calendar planTimeAfter = Calendar.getInstance();
		String[] planFinishSubject = new String[plans.length];
		String[] planLeftSubject = new String[plans.length];

		for (int i = 0; i < plans.length; i++) {
			for (int j = 0; j < plans[i].length; j++) {

				String[] planTimeSplit = plans[i][1].split(":");
				int planHour = Integer.parseInt(planTimeSplit[0]);
				int planMinute = Integer.parseInt(planTimeSplit[1]);
				
//				date2.set(Calendar.HOUR, Integer.parseInt(plans[i + 1][1]));
//				System.out.println();
			}
		}

		return answer;
	}
}