package java0601p;

//student 객체생성
// 출력 형식
// 학생이름 총점: ㅇㅇ 점, 평균: ㅇㅇ점

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Student s1 = new Student();
		s1.hakbun = 1;
		s1.name = "강아지";
		s1.kor = 100;
		s1.eng = 75;
		s1.math = 60;
		s1.print_student();
		
		Student s2 = new Student();
		s2.hakbun = 2;
		s2.name = "고양이";
		s2.kor = 75;
		s2.eng = 75;
		s2.math = 100;
		s2.print_student();
		
		
	} // main

}
