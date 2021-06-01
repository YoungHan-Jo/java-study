package java0601;

public class Ex4 {

	public static void main(String[] args) {
		// 각 생성자 별로 객체 생성후 setter, getter 호출 연습

		Animal a1 = new Animal("코끼리",10);
		a1.showAnimal();
		
		Animal a2 = new Animal();
		a2.setName("말");
		a2.setAge(5);
		a2.showAnimal();
		
		Animal a3 = new Animal();
		a3.showAnimal();
		
		Animal a4 = new Animal("기린");
		a4.showAnimal();
		
		Animal a5 = new Animal(15);
		a5.showAnimal();
		System.out.printf("%s는 %d 살\n",a5.getName(), a5.getAge());
		
		
		
		
		
	} // main

}
