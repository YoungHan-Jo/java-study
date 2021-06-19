package java0531;


public class Ex1prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		TreeX tree1 = new TreeX();
		tree1.name = "버드";
		tree1.age = 5;
		tree1.showTree();
		
		TreeX tree2 = new TreeX();
		tree2.name = "소";
		tree2.age = 50;
		tree2.showTree();
		
	} //main
}//class


class TreeX {
	
	String name;
	int age;
	
	void showTree() {
		System.out.printf("%d 살 %s나무가 바람에 ",age,name);
		if(age < 10)
			System.out.println("세게 흔들린다.");
		else
			System.out.println("살살 흔들린다.");
	}
}
