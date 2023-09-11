//import java.util.HashMap;
import java.util.Map;

//import java.util.Arrays;

/*
players	callings	result
["mumu", "soe", "poe", "kai", "mine"]	
["kai", "kai", "mine", "mine"]	
["mumu", "kai", "mine", "soe", "poe"]
*/

public class dangit2 {
	public static void main(String[] args) {
		String[] players = {"mumu", "soe", "poe", "kai", "mine"};
		String[] callings = {"kai", "kai", "mine", "mine"};

		Solution ss = new Solution();
		ss.solution(players, callings);
	}
}

//class Solution {
//    public String[] solution(String[] players, String[] callings) {
//        String[] answer = {};
//        
//        String tmp = "";
//        for(String callName : callings) {
//        	for(int i=0; i<=players.length-1; i++) {
//        		if(players[i].equals(callName)) {
//        			if(i==0) {
//	        			break;
//        			} else {
//        				tmp = players[i];
//	        			players[i] = players[i-1];
//	        			players[i-1] = tmp;
//	        			break;
//        			}
//        		}
//        	}
//        }
//        answer = players;
//        return answer;
//    }
//}

import java.util.HashMap;
import java.util.Map;

//class Solution {
//    public String[] solution(String[] players, String[] callings) {
//        String[] answer = {};        
//        Map<String,Integer> map = new HashMap<String,Integer>();
//        
//        int i=0;
//        for(String playerName : players) {
//        	map.put(playerName, i);
//        	i++;
//        }
//        for(String callName : callings) {
//    		String tmp = "";
//    		int findIdx = map.get(callName);
//    		if(findIdx == 0) {
//        		break;
//    		} else {
//    			map.put(callName, findIdx-1);
//                map.put(players[findIdx-1], findIdx);
//                
//                tmp = players[findIdx];
//                players[findIdx] = players[findIdx-1];
//    			players[findIdx-1] = tmp;
//    		}    	
//        }
//        answer = players;
//        return answer;
//    }
//}