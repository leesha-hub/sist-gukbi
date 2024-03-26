import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CodingTest {
	public static void main(String[] args) {
		String[][] arr = {
				{ "answer : 1", "score : 5"},
				{ "answer : 3", "score : 3"},
				{ "answer : 2", "score : 4"},
				
//				{ "answer : 1", "score : 5"},
//				{ "answer : 5", "score : 5"},
//				{ "answer : 2", "score : 4"},
				};
		
		Solution sl = new Solution();
		sl.solution(arr);
	}
}

class Solution {
    public List<String> solution(String[][] arr) {
        String[][] answerSheet = arr; 
    	HashMap<String, Integer> scores = new HashMap<>();
        scores.put("a", 0);
        scores.put("b", 0);
        scores.put("c", 0);
        
    	for (String[] strings : answerSheet) {
			int arrAnswer = Integer.parseInt(strings[0].substring(strings[0].length() - 1));
			int arrScore = Integer.parseInt(strings[1].substring(strings[1].length() - 1));
			
			if(arrAnswer == 1) {
				scores.put("a", (scores.get("a") + arrScore));
			} else if (arrAnswer == 3) {
				scores.put("b", (scores.get("b") + arrScore));
			} else if (arrAnswer == 5) {
				scores.put("c", (scores.get("c") + arrScore));
			}
    	}
    	
    	List<String> topScorers = new ArrayList<>();
    	int maxScore = 0;
    	for(Map.Entry<String, Integer> entry : scores.entrySet()) {
    		if(entry.getValue() > maxScore) {
    			topScorers.clear();
    			topScorers.add(entry.getKey());
    			maxScore = entry.getValue();
    		} else if(entry.getValue() == maxScore) {
    			topScorers.add(entry.getKey());
    		}
    	}
    	
    	List<String> answer = new ArrayList<>();
    	for (String topScorer : topScorers) {
    		answer.add(topScorer + " : " + maxScore);
        }
    	return answer;
    }
}