package kr.s05.collections.set;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Collections;
import java.util.List;

public class HashSetMain02 {
	public static void main(String[] args) {
		HashSet<Integer> hs = new HashSet<Integer>();
		while(hs.size()<6) {
			int ir = (int)(Math.random()*45) + 1; //1~45
			hs.add(ir); //중복값을 허용하지 않음
		}
		System.out.println(hs);
		
		//HashSet -> Set -> Collection
		List<Integer> list = new ArrayList<Integer>(hs);
		
		//오름차순 정렬
		Collections.sort(list);
		
		//확장for문을 이용한 요소 출력
		for(int num : list) {
			System.out.print(num + "\t");
		}
		
		
	}
}


