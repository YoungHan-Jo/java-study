package java0601p;

import java.util.Scanner;

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Animal a1 = new Animal();
		a1.showAnimal();
		
		Animal a2 = new Animal("호랑이");
		a2.showAnimal();
		
		Animal a3 = new Animal(10);
		a3.showAnimal();
		
		Animal a4 = new Animal("치타",5);
		a4.showAnimal();
		
		a4.setName("코끼리");
		a4.setAge(10);
		a4.showAnimal();
		
		Scanner scanner = new Scanner(System.in);
		
		String animal = scanner.nextLine();
		int age = scanner.nextInt();
		
		Animal a5 = new Animal(animal, age);
		a5.showAnimal();
		
	} // main

}
