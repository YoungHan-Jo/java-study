package java0513;

public class Ex1 {

	public static void main(String[] args) {
		// 조건연산자 (삼항연산자)

		// (조건식) ? 참 : 거짓 ;
		int age = 19;
		String str = "";
		// 나이가 10대 범위에 있으면 str변수에 "10대" 저장
		// 가 아니면 str변수에 "10대 아님" 저장
		str = (age >= 10 && age <= 19) ? "10대" : "10대 아님";

		System.out.println(age + " 세 -> " + str);

		System.out.println("======================================");
		// 주민등록번호 뒷자리에 첫째자리는 성별정보
		// 1남 2여 3남 4여
		int jumin = 3;
		str = (jumin == 1 || jumin == 3) ? "남자" : "여자";
		System.out.println(jumin + " -> " + str);

		str = (jumin % 2 == 1) ? "남자" : "여자";
		System.out.println(jumin + " -> " + str);

		System.out.println("===============================================");

		// 출력 각 과목, 총점, 평균
		// 평균 60이상 & 각 과목 40점 이상이면 ----> str에 합격, 아니면 불합격
		// 합격 불합격여부 출력

		int kor = 85, eng = 80, math = 40; // 국어, 영어, 수학 과목별 점수
		int sum = 0; // 세과목 합계
		double avg = 0.0; // 세과목 평균

		sum = kor + eng + math;
		avg = sum / 3.0;

		System.out.printf("국어: %d\t 영어: %d\t 수학: %d%n", kor, eng, math);
		System.out.printf("합계: %d\t 평균: %.2f%n", sum, avg);
		str = (avg >= 60 && kor >= 40 && eng >= 40 && math >= 40) ? "합격" : "불합격";
		System.out.println(str);
		avg = Math.round(avg * 100) / 100.0;
		System.out.println(avg);

		System.out.println("==================");
		// 복합대입연산자

		int a = 10;
		a = a + 1;
		a += 1;

		a++;

		a = 0;
		a = a + 2;
		System.out.println("a = " + a);
		a += 2;
		System.out.println("a = " + a);
		
		a = 10;
		a /= 3;
		System.out.println("a = " + a);

	}//

}
