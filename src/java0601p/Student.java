package java0601p;

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
	
	Student(){
		
	}
	
	int sum() {
		return kor + eng + math;
	}
	
	double avg() {
		return (double)sum()/3.0;
	}
	
	void print_student() {
		System.out.printf("%03d : %s\t총점 : %d 점, 평균 : %.2f 점\n", hakbun, name, sum(), avg());
	}
}
