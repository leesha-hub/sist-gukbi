package kr.s06.array;

public class ArrayMain12 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 요소의 수를 지정하고 지정된 수로 정수형 배열을 생성해서 해당 
		 * 배열에 정수를 저장하시오.
		 * 배열에 저장된 요소를 역순을 출력하시오.
		 * 
		 * [입력 예시]
		 * 요소수:3
		 * array[0] : 20
		 * array[1] : 10
		 * array[2] : 5
		 * 
		 * [출력 예시]
		 * 요소를 역순으로 정렬했습니다.
		 * array[0] : 5
		 * array[1] : 10
		 * array[2] : 20
		 */
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("요소수:");
		int num = input.nextInt();
		
		//배열 선언 및 생성
		int[] array = new int[num];
		
		for(int i=0;i<num;i++) {
			System.out.print("array["+i+"]:");
			array[i] = input.nextInt();
		}
		//역순으로 정렬
		for(int i=0;i<array.length/2;i++) {
			int t = array[i];
			array[i] = array[array.length-1-i];
			array[array.length-1-i] = t;
		}
		
		System.out.println("요소를 역순으로 정렬했습니다.");
		for(int i=0;i<num;i++) {
			System.out.println("array["+i+"]:" + array[i]);
		}
		
		input.close();		
	}
}






