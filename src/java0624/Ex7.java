package java0624;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Ex7 {

	public static void main(String[] args) {
		// List 인터페이스를 구현한 클래스
		// ArrayList : 가변크기 배열을 구현한 클래스.
		// Vector : ArrayList와 동일함. + 스레드 동기화를 지원함.
		List<Object> list = new ArrayList<Object>(); // <> <- 구성요소의 타입정보
		
		// add()는 마지막 위치로 추가
		list.add(10);
		list.add(3.14);
		list.add("문자열");
		list.add(true);
		list.add(new Puppy("푸들",2));
		
		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println(list.size());
		
		list.remove(1);
		System.out.println(list.size());
		System.out.println(list);
		
		list.add(3, 2.7); // 인덱스번호 3 위치에 2.7 값을 중간에 삽입하기
		System.out.println(list);
		
		System.out.println("===============iterator==================");
		//Iterator 반복자
		Iterator<Object> iter = list.iterator();
		while(iter.hasNext()) {
			System.out.println(iter.next());
		}
		
		System.out.println("=================for 문===================");
		for(int i = 0 ; i < list.size() ; ++i ) {
			System.out.println(list.get(i));
		}
		
		System.out.println("================for each===================");
		for(Object obj : list) {
			System.out.println(obj.toString());
		}
		
		System.out.println("==============list.clear();=================");
		list.clear(); // 모든 요소 삭제(비우기)
		System.out.println(list);

		
		
	} // main

}
