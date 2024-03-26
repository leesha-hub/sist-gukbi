public class CodingTest {
	public static void main(String[] args) {
		int a = 10;

		Solution sl = new Solution();
		sl.solution(a);
	}
}

class Solution {
	public int solution(int a) {
		int answer = 0;
		int number = a;

		int divideCount = 0;
		for (int i = 2; i <= a; i++) {
			if(isPrime(i)) {
				answer += i;
			}
		}
		return answer;
	}
	
	private boolean isPrime(int num) {
		for (int i = 2; i * i <= num; i++) {
	        if (num % i == 0) return false; 
	    }
	    return true; 
	}
}