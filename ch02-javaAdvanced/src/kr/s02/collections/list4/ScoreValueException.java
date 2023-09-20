package kr.s02.collections.list4;

//사용자 정의 예외클래스 (성적은 0 ~ 100 가능 나머지는 예외)
public class ScoreValueException extends Exception{
	public ScoreValueException(String message) {
		super(message);
	}
}
