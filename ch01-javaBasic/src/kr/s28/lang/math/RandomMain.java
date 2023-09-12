package kr.s28.lang.math;

import java.util.Random;

public class RandomMain {
	
	public static void main(String[] args) {
		System.out.println("----------------------------");
		
		String[] luck = {"귀인을 만남", "해외여행 출발", "로또 당첨", "피곤한 하루"};
	}
	
	Random r1 = new Random();
	int index = r1.nextInt(4);
}
