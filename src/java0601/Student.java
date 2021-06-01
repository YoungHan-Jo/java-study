package java0601;

public class Student {
	// 학번 정수형 hakbun
	// 학생이름 문자열 name
	// 국어점수 정수형 kor
	// 영어점수 정수형 eng
	// 수학점수 정수형 math
	// 총점 구해서 리턴하는 메소드 sum()
	// 평균 구해서 리턴하는 메소드 avg()

	int hakbun;
	String name;
	int kor, eng, math;

	// 기본생성자 : 자바 컴파일러가 클래스 정의안에 생성자 블록이 없으면 자동으로 생성함.
	// 클래스의 역할은 객체생성용도이기 때문에,
	// 생성자가 없으면 기본생성자를 자동으로 생성시켜줌.
	
	Student(){ // 리턴값 없음
//		// 생성자 용도 : 생성된 객체의 초기상태를 준비하는 용도
		// 복잡한 초기화를 할때 사용함
	} //-> main함수에서 new Student(); 이유
	
	int sum() {
		return kor + eng + math;
	}

	double avg() {
		return (double) sum() / 3.0;
	}

	void print() {
		System.out.printf("%03d : %s\t총점 : %d 점, 평균 : %.2f 점\n", hakbun, name, sum(), avg());
	}

}
