package kr.s02.collections.list4;

import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;

public class ScoreMain {
	/*
	 * [실습]
	 * 1.멤버변수 : ArrayList, BufferedReader 객체를 저장할 수 있는 변수
	 * 2.생성자 : ArrayList, BufferedReader 객체 생성, callMenu 호출
	 * 3.메서드 : 메뉴(callMenu), 성적입력(inputScore), 성적출력(printScore)
	 *          성적 입력 조건 체크(int parseInputData(String course)) 
	 */
	private ArrayList<Score> list;
	private BufferedReader br;
	
	public ScoreMain() {
		list = new ArrayList<Score>();
		try {
			br = new BufferedReader(new InputStreamReader(System.in));
			callMenu();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			if(br!=null)try {br.close();}catch(IOException e) {}
		}
	}
	//메뉴
	public void callMenu()throws IOException{
		while(true) {
			System.out.print("1.성적입력,2.성적출력,3.종료>");
			try {
				int num = Integer.parseInt(br.readLine());
				if(num == 1) {
					inputScore();
				}else if(num == 2) {
					printScore();
				}else if(num == 3) {
					System.out.println("프로그램 종료");
					break;
				}else {
					System.out.println("[잘못 입력했습니다.]");
				}
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력하세요.]");
			}
		}
	}
	//성적입력
	public void inputScore()throws IOException{
		Score s = new Score();
		System.out.print("이름 입력:");
		s.setName(br.readLine());
		
		s.setKorean(parseInputData("국어 입력:"));
		s.setEnglish(parseInputData("영어 입력:"));
		s.setMath(parseInputData("수학 입력:"));
		
		list.add(s);
	}
	//성적출력
	public void printScore() {
		System.out.println("--------------------------------");
		System.out.println("이름\t국어\t영어\t수학\t총점\t평균\t등급");
		System.out.println("--------------------------------");
		for(Score s : list) {
			System.out.print(s.getName()+"\t");
			System.out.print(s.getKorean()+"\t");
			System.out.print(s.getEnglish()+"\t");
			System.out.print(s.getMath()+"\t");
			System.out.print(s.makeSum()+"\t");
			System.out.printf("%.2f\t", s.makeAvg());
			System.out.print(s.makeGrade()+"\n");
		}
	}
	//성적 입력 조건 체크
	public int parseInputData(String course)throws IOException{
		while(true) {
			System.out.print(course); //과목 표시
			try {
				int num = Integer.parseInt(br.readLine());
				
				//성적 유효 범위(0~100) 체크
				if(num<0 || num>100)
					throw new ScoreValueException("[0부터100까지의 값만 인정]");
				
				return num;//정상적인 점수(0~100) 반환
			}catch(NumberFormatException e) {
				System.out.println("[숫자만 입력 가능]");
			}catch(ScoreValueException e) {
				System.out.println(e.getMessage());
			}
		}
	}
	
	public static void main(String[] args) {
		new ScoreMain();
	}
}
