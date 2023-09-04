package kr.s05.operation;

public class IfMain09 {
	public static void main(String[] args) {
		/*
		 * [실습]
		 * 
		 * 생년월일을 입력하고 만 나이를 출력하는 프로그램을 작성하시오.
		 * 만 나이 = (현재 연도 - 태어난 연도) - (생일이 지났으면 0, 생일이 지나지 않았으면 1)
		 * 
		 * [입력 예시]
		 * 출생연도 입력:2000
		 * 월 입력:3
		 * 일 입력:12
		 * 
		 * [출력 예시]
		 * 만 나이는 23
		 * 
		 */
		
		//현재 날짜 정보
		int thisYear = 2023;
		int thisMonth = 9;
		int thisDate = 4;
		
		java.util.Scanner input = new java.util.Scanner(System.in);
		System.out.print("연도 입력:");
		int year = input.nextInt();
		
		System.out.print("월 입력:");
		int month = input.nextInt();
		
		System.out.print("일 입력:");
		int date = input.nextInt();
		
		//현재 연도와 태어난 연도 연산
		int age = thisYear - year;
		
		//현재 월과 태어난 월을 비교
		if(thisMonth < month) {//예) 9 < 10
			age--;
		}else if(thisMonth == month && thisDate < date) {
			//현재 월과 태어난 월이 같으면 일 비교 예) 4 < 30
			age--;
		}else {
			//생일이 지난 경우이기 때문에 age의 변동이 없음. 그래서 
			//else를 명시할 필요가 없음
			System.out.println("~~~~~~~~~~~");
		}
		
		System.out.printf("만 나이는 %d%n", age);
			
		input.close();
		
	}
}



