package java0621;

//접근지정자
//private : 클래스 외부 접근제한,내부에서만 접근가능
//default(생략): 같은 패키지 안에 있는 클래스,인터페이스 접근가능		
//protected : 
//public : 다른 패키지에 있는 클래스,인터페이스도 접근가능

//접근지정자가 올 수 있는 위치: 클래스단위,생성자/메소드,멤버변수
// 클래스단위에서 사용가능한 접근지정자 : public, default(생략)
// 클래스 제외하고 다른거는 다 사용가능
// (private,default,protected,public)

public class MyDate {
	// 멤버변수 : 정수형 year, month, date
	// private 접근지정자.
	// 클래스 외부에서의 접근 제한함. 클래스 내부에서만 접근가능.
	private int year;
	private int month;
	private int date;

	// this. : 객체 자기자신을 가리키는 내부 참조변수
	// this() : 생성자 오버로딩 시, 다른생성자를 호출하는용도.
	// 초기화 코드 중복을 최소화
	
	// 기본생성자. 초기화 year 2021, month 1, date 1
	public MyDate() {
		this(2021, 1, 1);
	}

	// 년 값을 받아서 초기화하는 생성자. 월/일 은 1로 초기화
	MyDate(int year) {
		this(year, 1, 1);
	}

	// 년과 월을 받아서 초기화 하는 생성자. 일은 1로초기화
	MyDate(int year, int month) {
		this(year, month, 1);
	}

	// 년월일 모두 받아서 초기화
	MyDate(int year, int month, int date) {
		this.year = year;
		this.month = month;
		this.date = date;
	}

	// setYear / setMonth / setDate 메서드 리턴형 void
	public void setYear(int year) {
		this.year = year;
	}

	public void setMonth(int month) {
		if(month>=1 && month <=12)
			this.month = month;
		else
			return;
	}

	public void setDate(int date) {
		if(date >=1 && date<=31)
			this.date = date;
		else
			return;
	}

	// getYear / getMonth / getMonth 메서드
	public int getYear() {
		return year;
	}

	public int getMonth() {
		return month;
	}

	public int getDate() {
		return date;
	}

	// showMyDate() 메서드. 출력 "년-월-일"
	public void showMyDate() {
		System.out.printf("%d-%d-%d\n", year, month, date);
	}
}
