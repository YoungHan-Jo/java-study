package java0624prac;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import lombok.AllArgsConstructor;
import lombok.ToString;

@AllArgsConstructor
@ToString
class Dog {
	String name;
	int age;
}

public class Ex6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		List<Object> list = new ArrayList<>();

		list.add(10);
		list.add(3.14);
		list.add("문자열");
		list.add(true);
		list.add(new Dog("푸들", 2));

		System.out.println(list);
		System.out.println(list.get(0));
		System.out.println("리스트 크기 : " + list.size());

		list.remove(Integer.valueOf(10));
		System.out.println(list);

		list.add(0, 2.7);
		System.out.println(list);

		System.out.println("==========iterator====================");

		Iterator<Object> iter = list.iterator();
		while (iter.hasNext())
			System.out.println(iter.next());

		System.out.println("=======for=============");
		
		for(int i = 0 ; i < list.size() ; ++i) {
			System.out.println(list.get(i));
		}
		
		System.out.println("=========for each ============");
		
		for(Object obj : list)
			System.out.println(obj.toString());
		

	} // main

}
