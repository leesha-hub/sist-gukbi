package kr.s01.exception;

public class ExceptionMain06 {
	
	public void methodA(String[] n)throws Exception{
		if(n.length>0) {
			for(String s : n) {
				System.out.println(s);
			}
		}else {
			//인위적으로 예외 발생
			//인위적으로 예외를 발생시킬 때는 try~catch로 감싸거나
			//메서드에서 사용할 경우 throws 예약어를 사용해야 
			//오류가 발생하지 않음
			throw new Exception("배열에 요소가 없습니다.");
		}
	}
	
	public static void main(String[] args) {
		ExceptionMain06 ex = new ExceptionMain06();
		try {
			ex.methodA(args);
		}catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
}




