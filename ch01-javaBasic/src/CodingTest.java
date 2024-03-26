import java.util.HashMap;
import java.util.Map;

public class CodingTest {
	public static void main(String[] args) {
//		String[] participant = { "트리케라톱스", "티라노사우루스", "바리오닉스"};
//		String[] completion = { "바리오닉스", "티라노사우루스" };
		String[] participant = { "티라노사우루스", "파키케팔로사우루스", "티라노사우루스", "스테고사우루스"};
		String[] completion = { "파키케팔로사우루스", "스테고사우루스", "티라노사우루스" };
		Solution sl = new Solution();
		sl.solution(participant, completion);
	}
}

class Solution {
	public String[] solution(String[] participant, String[] completion) {
		Map<String, Integer> safeDinosaur = new HashMap<String, Integer>();
		for (String dinosaur : participant) {
			Integer dinoCount = safeDinosaur.get(dinosaur);
			if (dinoCount != null) {
				safeDinosaur.put(dinosaur, dinoCount + 1);
			} else {
				safeDinosaur.put(dinosaur, 1);
			}
		}

		for (String dinosaur : completion) {
			Integer dinoCount = safeDinosaur.get(dinosaur);
			if (dinoCount != null) {
				if (dinoCount == 1) {
					safeDinosaur.remove(dinosaur);
				} else {
					safeDinosaur.put(dinosaur, dinoCount - 1);
				}
			}
		}
		String[] answer = safeDinosaur.keySet().stream().toArray(String[]::new);
		return answer;
	}
}