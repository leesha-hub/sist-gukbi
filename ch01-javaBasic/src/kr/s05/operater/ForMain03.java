package kr.s05.operater;

public class ForMain03 {
	public static void main(String[] args) {
		//1부터 100까지의 합 구하기
		int sum = 0;
		
		for(int i=1;i<=100;i++) {
			//누적
			sum += i;//sum = sum + i
		}
		
		System.out.println("1부터 100까지의 합 : " + sum);
		
		System.out.println("-------------");
		
		//1부터 100까지의 범위에서 짝수의 합 구하기
		int total = 0;
		
		for(int i=1;i<=100;i++) {
			if(i%2==0) {//짝수일 경우 누적
				total += i;
			}
		}
		System.out.println("1부터 100까지 짝수의 합 : " + total);		
	}
}



