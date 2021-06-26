package java0624prac;

import java.util.ArrayList;
import java.util.List;

class PuppyDAO {
	
	List<Puppy> getPuppyList(){
		
		List<Puppy> puppyList = new ArrayList<>();
		
		puppyList.add(new Puppy("푸들",2));
		puppyList.add(new Puppy("시바",3));
		puppyList.add(new Puppy("포메",4));
		
		return puppyList;
	}
	
}


public class Ex8 {

	public static void main(String[] args) {
		
		
		PuppyDAO dao = new PuppyDAO();
		List<Puppy> list = dao.getPuppyList();
		for(int i = 0; i < list.size(); ++i) {
			Puppy puppy = list.get(i);
			if(puppy.getName().equals("포메"))
				System.out.println(puppy.toString());
		}
		
		
		
	} // main
}
