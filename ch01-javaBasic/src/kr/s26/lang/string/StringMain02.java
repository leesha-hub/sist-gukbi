package kr.s26.lang.string;

public class StringMain02 {
	public static void main(String[] args) {
		String s1 = "Kwon Sun Ae";
		           //012345678910 , 길이 : 11
		
		//지정한 문자의 인덱스 반환
		int index = s1.indexOf('n');
		System.out.println("맨 처음 문자 n의 위치 : " + index);
		
		index = s1.indexOf("Sun");
		System.out.println("문자열 Sun의 위치 : " + index);
		
		index = s1.lastIndexOf('n');
		System.out.println("마지막 문자 n의 위치 : " + index);
		
		//지정한 인덱스를 통해서 문자를 반환
		char c = s1.charAt(index);
		System.out.println("추출한 문자 : " + c);
		
		index = s1.indexOf('S');
		//지정한 인덱스부터 끝 인덱스까지 문자열 추출
		String str = s1.substring(index);
		System.out.println("대문자 S부터 끝까지 잘라내기 : " + str);
		
		//시작 인덱스부터 끝 인덱스 전까지 문자열 추출
		str = s1.substring(index,index+3);
		System.out.println(
				"시작 인덱스부터 끝 인덱스 전까지 문자열 추출 : " + str);
		
		int length = s1.length();
		System.out.println("s1의 길이 : " + length);
		
		String[] array = s1.split(" ");
		for(int i=0;i<array.length;i++) {
			System.out.println("array["+i+"] : " + array[i]);
		}
	}
}




