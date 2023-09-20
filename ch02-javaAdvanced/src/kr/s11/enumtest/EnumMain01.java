package kr.s11.enumtest;

public class EnumMain01 {
	//enum을 사용하지 않고 static 상수를 사용한 경우
	public static final String JAVA = "JAVA";
	public static final String JSP = "JSP";
	public static final String ORACLE = "ORACLE";
	
	public static void main(String[] args) {
		System.out.println(JAVA);
		System.out.println(JSP);
		System.out.println(ORACLE);
	}
}
