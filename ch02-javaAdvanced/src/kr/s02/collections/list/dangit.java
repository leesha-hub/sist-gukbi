package kr.s02.collections.list;

import java.util.regex.Pattern;
/*
no	new_id	result
예1	"...!@BaT#*..y.abcdefghijklm"	"bat.y.abcdefghi"
예2	"z-+.^."	"z--"
예3	"=.="	"aaa"
예4	"123_.def"	"123_.def"
예5	"abcdefghijklmn.p"	"abcdefghijklmn"
*/

public class dangit {
	public static void main(String[] args) {
		String new_id = "._-";
		Solution ss = new Solution();
		ss.solution(new_id);
	}
}

class Solution {
	public String solution(String new_id) {
		String answer = "";
		boolean newIdCheck = false;
		
		// while문 안에 포함될 필요가 없는 step1
		String newRecommandID = makeIdStep1(new_id);
		// while문 안에 포함될 필요가 없는 step2
		newRecommandID = makeIdStep2(newRecommandID);
		
		while(!newIdCheck) {
			newRecommandID = makeIdStep3(newRecommandID); // 마침표 처음이나 끝에 있는 경우
			newRecommandID = makeIdStep4(newRecommandID); // 빈문자열인 경우
			newRecommandID = makeIdStep5(newRecommandID); // 16자 이상인 경우
			newRecommandID = makeIdStep6(newRecommandID); // 2자 이하인 경우
			
			// 추천 아이디 적합한지 확인
			newIdCheck = makeIdCheck(newRecommandID);
		}
		answer = newRecommandID;
		return answer;
	}
	
	public boolean makeIdCheck(String newRecID) {
		String newRecommandID = newRecID;
		
		// 빈문자열이거나 2자 이하인 경우 false
		if(newRecommandID.equals("") || newRecommandID.length() <= 2) {
			return false;
		}
		// 처음과 끝에 마침표가 있는 경우 false
		if(newRecommandID.length() == 1 && newRecommandID.charAt(0) == '.') {
			return false;
		} else {
			if (newRecommandID.charAt(0) == '.' || newRecommandID.charAt(newRecommandID.length() - 1) == '.') {
				return false;
			}
		}
		return true;
	}
	
	// step1 :: 대문자인 경우 소문자로 변경, 허용문자 외 제거(소문자, 숫자, 빼기, 밑줄, 마침표 사용가능)
	public String makeIdStep1(String new_id) {
		String newRecommandID = "";
		if (!new_id.equals("")) {
			for (int i = 0; i <= new_id.length() - 1; i++) {
				if (!Pattern.matches("^[a-zA-Z0-9._-]", new_id.substring(i, i + 1))) {
					newRecommandID += "";
				} else {
					int letterNum = (int) new_id.charAt(i);
					if (letterNum >= 65 && letterNum <= 90) {
						newRecommandID += (char) (int) (new_id.charAt(i) + 32);
					} else {
						newRecommandID += new_id.charAt(i);
					}
				}
			}
		}
		return newRecommandID;
	}
	
	// step2 :: 마침표 2개 연속될 경우 1개로 변경
	public String makeIdStep2(String newRecID) {
		String newRecommandID = newRecID;
		while (newRecommandID.contains("..")) {
			newRecommandID = newRecommandID.replace("..", ".");
		}
		return newRecommandID;
	}
	
	// step3 :: 마침표가 처음이나 끝에 위치한 경우 제거
	public String makeIdStep3(String newRecID) {
		String newRecommandID = newRecID;
		if (newRecommandID.equals("")) {
			newRecommandID = makeIdStep4(newRecommandID);
		}
		if (newRecommandID.length() == 1 && newRecommandID.charAt(0) == '.') {
			newRecommandID = "";
		} else {
			if (newRecommandID.charAt(0) == '.') {
				newRecommandID = newRecommandID.substring(1, newRecommandID.length());
			}
			if (newRecommandID.charAt(newRecommandID.length() - 1) == '.') {
				newRecommandID = newRecommandID.substring(0, newRecommandID.length() - 1);
			}
		}
		return newRecommandID;
	}
	
	public String makeIdStep4(String newRecID) {
		String newRecommandID = newRecID;
		// step4 :: 빈문자열이면 a대입
		if (newRecommandID.equals("")) {
			newRecommandID = "a";
		}
		return newRecommandID;
	}
	
	public String makeIdStep5(String newRecID) {
		String newRecommandID = newRecID;
		// step5 :: 16자 이상이면 15개 제외 나머지 모두 제거
		if (newRecommandID.length() >= 16) {
			newRecommandID = newRecommandID.substring(0, 15);
		}
		return newRecommandID;
	}
	
	public String makeIdStep6(String newRecID) {
		String newRecommandID = newRecID;
		// step6 :: 2자 이하이면 마지막 문자를 3글자가 될때까지 반복해서 붙이기
		if (newRecommandID.length() <= 2) {
			char lastWord;
			lastWord = newRecommandID.charAt(newRecommandID.length() - 1);
			while (newRecommandID.length() < 3) {
				newRecommandID += lastWord;
			}
		}
		return newRecommandID;
	}
}