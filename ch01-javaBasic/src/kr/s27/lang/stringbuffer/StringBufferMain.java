package kr.s27.lang.stringbuffer;

public class StringBufferMain {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer("여름 덥다!!");
		System.out.println(sb);
		
		//문자 추가
		sb.insert(2, "이");
		System.out.println(sb);
		
		sb.append(" 가을은 ");
		System.out.println(sb);
		
	}
}
