package java0601;

public class Ex2 {

	public static void main(String[] args) {
		// student 객체생성
		// 출력 형식
		// 학생이름 총점: ㅇㅇ 점, 평균: ㅇㅇ점

		Student s1 = new Student();

		s1.hakbun = 001;
		s1.name = "강아지";
		s1.kor = 90;
		s1.eng = 95;
		s1.math = 75;
		s1.print();

		Student s2 = new Student();

		s2.hakbun = 002;
		s2.name = "고양이";
		s2.kor = 75;
		s2.eng = 65;
		s2.math = 90;
		s2.print();

	} // main

}
