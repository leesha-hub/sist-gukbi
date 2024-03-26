public class CodingTest {
	public static void main(String[] args) {
		int[] number = {1,2,3,4};
		Solution sl = new Solution();
		sl.solution(number);
	}
}

class Solution {
	public int solution(int[] number) {
		int[] arr = number;
		int answer = 0;
		answer = factorial(arr.length);
		System.out.println(answer);
		return answer;
	}
	
	public int factorial(int n) {
        if (n == 0) {
            return 1;
        }
        return n * factorial(n - 1);
	}
}