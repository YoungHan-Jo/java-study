package java0624;

import java.util.ArrayList;
import java.util.List;

//DAO : data access object : 데이터를 접근할 수 있는 클래스. (파일, DB, 네트워크상의 다른 서버 데이터 등)
class PuppyDAO {
	
	List<Puppy> getPuppyList(){
		// 리스트 컬렉션 객체 준비
		// <> 제네릭(Generics) : 타입 매개변수. 자료형 한 종류로 일반화시키기 <Puppy> <- Puppy 만 들어올 수 있게
		List<Puppy> puppyList = new ArrayList<>(); // ArrayList<Puppy>() <- <> 똑같이 넣어줘야하는데 같아서 생략 가능.
		
		puppyList.add(new Puppy("푸들",2));
		puppyList.add(new Puppy("포메",3));
		puppyList.add(new Puppy("시바",4));
		
		return puppyList;
	}
}

public class Ex8 {

	public static void main(String[] args) {
		
		PuppyDAO dao = new PuppyDAO();
		List<Puppy> list = dao.getPuppyList();
		
		for(int i = 0 ; i < list.size(); ++i) {
			Puppy puppy = list.get(i);
			if(puppy.getName().equals("포메")) { // List 는 뭐 찾을때 처음부터 쫙 검색해야함 - > map 으로 하면 키 값으로 바로 찾을 수 있음
				System.out.println(puppy.toString());
			}
		}
		
		
		
	} // main

}
