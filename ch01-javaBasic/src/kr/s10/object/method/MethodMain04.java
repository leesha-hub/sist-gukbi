package kr.s10.object.method;

public class MethodMain04 {
	/*
	 * [실습]
	 * 배열 요소 수(사람 수)를 입력 받아서 배열 weight 생성
	 * 입력 받은 정수를 배열 weight에 저장하고 배열 weight가 가진
	 * 모든 요소의 수 중 최소값을 구하는 minOf 메서드를 작성하시오.
	 * 
	 * [입력 예시]
	 * 사람 수:3
	 * 1번의 체중:53
	 * 2번의 체중:62
	 * 3번의 체중:71
	 * 
	 * [출력 예시]
	 * 가장 마른 사람의 체중 : 53kg
	 */
	public int minOf(int[] a) {
		int min = a[0]; //초기값
		for(int i=1;i<a.length;i++) {
			if(a[i]<min) {
				min = a[i];
			}
		}
		return min;
	}
	
	public static void main(String[] args) {
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("사람 수:");
		int num = input.nextInt();
		
		int[] weight = new int[num];//체중을 저장하는 배열
		
		for(int i=0;i<num;i++) {
			System.out.print((i+1) + "번의 체중:");
			weight[i] = input.nextInt();
		}
		
		//객체 선언 및 생성
		MethodMain04 me = new MethodMain04();
		System.out.println(
			"가장 마른 사람의 체중 : " + me.minOf(weight) + "kg");		
		
		input.close();
	}
}
