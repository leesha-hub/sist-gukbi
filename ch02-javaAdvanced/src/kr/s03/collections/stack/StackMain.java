package kr.s03.collections.stack;

import java.util.Stack;

public class StackMain {
	public static void main(String[] args) {
		String[] array = {"진달래","백합","개나리","벚꽃","장미"};
		
		//스택(stack) : 후입선출 LIFO(Last-In First-Out) 방식
		Stack<String> stk = new Stack<String>();
		
		for(int i=0;i<array.length;i++) {
			stk.push(array[i]);
		}
		
		//요소의 목록 출력
		System.out.println(stk);
		System.out.println("-----------");
		
		//반복문을 이용한 요소의 출력
		while(!stk.isEmpty()) {//현재 스택이 비어 있지 않다면
			//스택에 저장된 객체를 꺼내 오면 저장된 객체는 지워짐
			System.out.print(stk.pop()+"\t");
		}
		System.out.println("\n-----------");
		
		System.out.println(stk);
		
	}
}





