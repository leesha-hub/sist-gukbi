package kr.s05.operater;

public class SwitchMain03 {
	public static void main(String[] args) {
		java.util.Scanner input = 
				new java.util.Scanner(System.in);
		int score;
		char grade;
		
		System.out.print("성적 입력>");
		score = input.nextInt();
		
		if(score<0 || score>100) {
			System.out.println("성적은 0~100만 입력 가능");
			System.exit(0);//프로그램 종료
		}
		
		switch(score/10) {
		case 10://100
			grade = 'A'; break;
		case 9://90~99
			grade = 'A'; break;
		case 8://80~89
			grade = 'B'; break;
		case 7://70~79
			grade = 'C'; break;
		case 6://60~69
			grade = 'D'; break;
		default ://0~59	
			grade = 'F';
		}
		
		System.out.println();//단순 줄바꿈
		System.out.printf("성적 : %d%n", score);
		System.out.printf("등급 : %c%n", grade);
		
		input.close();
	}
}




