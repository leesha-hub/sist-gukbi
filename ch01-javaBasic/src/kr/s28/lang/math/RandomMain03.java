package kr.s28.lang.math;

import java.util.Arrays;
import java.util.Random;

public class RandomMain03 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 로또 프로그램 제작
		 * 길이가 6인 int형 배열을 생성하고 1~45 숫자 범위로 난수를 구함.
		 * 중복되지 않은 6개의 숫자를 생성해서 배열에 저장하고 출력하시오.
		 * 난수 생성 : Math.random() 또는 Random 클래스의 nextInt() 메서드 사용
		 */
		
		//로또 번호를 저장할 배열 생성
		int[] lotto = new int[6];
		Random random = new Random();
		
		for(int i=0;i<lotto.length;i++) {
			lotto[i] = random.nextInt(45)+1;//1~45
			
			//중복된 숫자가 있는지 검증
			for(int j=0;j<i;j++) {
				if(lotto[i] == lotto[j]) {//값 중복
					System.out.println("~~~~" + lotto[i]);
					i--;//다른 루프로 넘어가지 못 하고 현재 루프에서 새로 값을
					    //입력할 수 있도록 처리
					break;
				}
			}
		}
		
		//오름차순 정렬
		Arrays.sort(lotto);
		
		//확장for문을 이용한 출력
		for(int num : lotto) {
			System.out.print(num + "\t");
		}
		
	}
}






