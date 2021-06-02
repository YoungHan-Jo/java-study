package java0601;

public class Animal {
	// 멤버 변수
	String name;
	int age;
	
	// 기본생성자. 초기값 name 강아지 age 3
	// this : 객체 자기자신을 가리키는 클래스 내부적인 참조변수
	// 생성자 코드블록 안에서 this 사용이 가능한 이유
	// - 생성자 호출시점에는 이미 객체가 생성되었고 그 객체를 this로 부를수있음.
	Animal(){
		name = "강아지";
		age = 3;
	}
	// 외부로부터 name 받는 생성자. age 1
	Animal(String name){
		this.name = name;
		age = 1;
	}
	// age 받는 생성자. name 고양이
	Animal(int age){
		name = "고양이";
		this.age = age;
	}
	// name age 다 받는
	Animal(String name, int age){
		this.name = name;
		this.age = age;
	}
	
	// setter 메소드, getter 메소드
	String getName() {
		return name;
	}
	void setName(String name) {
		this.name = name;
	}
	int getAge() {
		return age;
	}
	void setAge(int age) {
		this.age = age;
	}
	
	// showAnimal() 출력 - age 살, name 이(가) 뛴다.
	void showAnimal() {
		System.out.printf("%d 살짜리 %s 이/가 뛴다.\n",age,name);
	}
	
}
