package kr.s14.iostream.output;

import java.io.FileOutputStream;
import java.io.IOException;

public class FileOutputStreamMain01 {
	public static void main(String[] args) {
		FileOutputStream fos = null;
		try {
			//파일에 데이터 출력하는 방식 -> 덮어쓰기
			fos = new FileOutputStream("fileout.txt");
			
			//파일에 데이터 출력하는 방식 -> 이어쓰기
			//fos = new FileOutputStream("fileout.txt",true);
			
			String message = "Hello File! 파일에 내용 기술~~";
			         //String -> byte[]
			fos.write(message.getBytes());
			
			System.out.println("파일을 생성하고 내용을 기술했습니다.");
			
		}catch(IOException e) {
			e.printStackTrace();
		}finally {
			//자원정리
			if(fos!=null)try {fos.close();}catch(IOException e) {}
		}
	}
}





