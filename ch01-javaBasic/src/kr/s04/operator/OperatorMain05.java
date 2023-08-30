package kr.s04.operator;

public class OperatorMain05 {
	public static void main(String[] args) {
		// 입력시작
		java.util.Scanner input = new java.util.Scanner(System.in);

		System.out.print("국어 : ");
		int korean = input.nextInt();
		input.nextLine();
		System.out.printf("국어 = %d%n", korean);

		System.out.print("영어 : ");
		int english = input.nextInt();
		input.nextLine();
		System.out.printf("영어 = %d%n", english);

		System.out.print("수학 : ");
		int math = input.nextInt();
		input.nextLine();
		System.out.printf("수학 = %d%n", math);

		// 총점 구하기
		int sum = korean + english + english;

		// 평균 구하기
		double avg = sum / 3.0;
		// int/int로 계산된 결과는 int다. double타입 변수에 대입할시, 데이터 유실
//		double avg = sum/3;

		System.out.println("총점 : " + sum);
		System.out.println("평균 : " + avg);

		input.close();
	}
}
