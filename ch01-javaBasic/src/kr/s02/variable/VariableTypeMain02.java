package kr.s02.variable;

public class VariableTypeMain02 {
	public static void main(String[] args) {
		// 확장 특수 출력 문자(escape sequence)
		
		char single = '\'';
		System.out.println(single);
		
		String str = "오늘은 \"수요일\" 입니다.";
		System.out.println(str);
		
		String str2 = "내일은 '목요일' 입니다.";
		System.out.println(str2);
		
		String str3 = "C:\\javaWork";
		System.out.println(str3);
		
		String str4 = "여기는 서울이고 \n저기는 부산입니다.";
		System.out.println(str4);

		String str5 = "이름\t나이\t취미";
		System.out.println(str5);
		
		String str6 = "이름\t나이\t취미";
		System.out.println(str6);

	}
}
