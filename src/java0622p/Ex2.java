package java0622p;

class Emp {
	private String name;
	private int sal;

	Emp(String name, int sal) {
		super();
		this.name = name;
		this.sal = sal;
	}

	String getEmp() {
		return name + ", " + sal;
	}
}


class Dept extends Emp {
	String dept;

	Dept(String name, int sal, String dept) {
		super(name, sal);
		this.dept = dept;
	}

	@Override
	String getEmp() {
		return super.getEmp() + ", " + dept;
	}

}

public class Ex2 {

	public static void main(String[] args) {
		
		Emp p1 = new Dept("홍길동",10000,"인사부");
		System.out.println(p1.getEmp());
		
		Emp p2 = new Dept("이순신",20000,"마케팅");
		System.out.println(p2.getEmp());
		

	} // main

}
