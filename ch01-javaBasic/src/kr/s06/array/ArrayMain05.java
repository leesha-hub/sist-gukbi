package kr.s06.array;

public class ArrayMain05 {
	public static void main(String[] args) {
		//배열 선언 및 생성, 초기화
		int[] array = {10,20,30,40,50};
		             //0  1  2  3  4 , length = 5
		//반복문을 이용한 배열의 요소 출력
		             //배열의 길이
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"]:" + array[i]);
		}
		System.out.println("-------------------------");
		//개선된 루프(확장 for문)
		   //변수명   : 배열명
		for(int num : array) {
			System.out.println(num);
		}
	}
}




