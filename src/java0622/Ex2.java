package java0622;

// ***********************************
// private가 있을경우 상속관계 활용법.
// ***********************************
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
class Employee {
	private String name;
	private int salary;

	Employee() {

	}

	// 접근 지정자는 별 이유 없으면 클래스를 따라감
	Employee(String name, int salary) {
		this.name = name;
		this.salary = salary;
	}

	String getEmployee() {
		return name + ", " + salary;
	}

}

class Manager extends Employee {
	private String depart;

	Manager(String name, int salary, String depart) {
		// this.name = name; <- 부모 멤버변수 name에 private 를 붙였기 때문에 다른데서 코드로써는 사용 할 수 없음.
		// 상속은 받아짐. 다른 곳에서 잘못 입력 될 수도 있기때문에 방지 하기 위해 사용하는 private
		this.setName(name); // <- setter 를 활용해 내부적으로 접근해야함. this는 생략 가능
		this.setSalary(salary);
		this.depart = depart;
	}

	String getManager() {
		// return getName() + ", " + getSalary() + ", " + depart; // <- private 라서
		// getter를 이용해 내부적으로 접근
		return getEmployee() + ", " + depart;
	}

}

public class Ex2 {

	public static void main(String[] args) {

		Employee emp = new Employee("홍길동", 10000);
		System.out.println(emp.getEmployee());

		System.out.println("============================");

		Manager mg = new Manager("이순신", 20000, "수산물");
		System.out.println(mg.getEmployee());
		System.out.println(mg.getManager());

	} // main

}
