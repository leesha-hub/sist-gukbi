public class CodingTest {
	public static void main(String[] args) {
		int[] arr = {1,2,3};
//		int[] arr = {1,2,3,4};
		
		Solution sl = new Solution();
		sl.solution(arr);
	}
}

class Solution {
    public int solution(int[] arr) {
    	int answer = 0;
    	int[] positiveIntArr = arr;
    	for(int i=0; i<=positiveIntArr.length; i++) {
    		for(int j=i+1; j<positiveIntArr.length; j++) {
    			answer += positiveIntArr[i] * positiveIntArr[j];
    		}
    	}
    	return answer;
    }
}