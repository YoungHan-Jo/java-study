package java0510;

public class Ex5 {

	public static void main(String[] args) {
		// * 연산자의 종류
		// 산술연산자 + - * / %
		// 비교연산자 > < <= >= == !=
		// 논리연산자 %% || ! (and, or ,not)
		// 대입연산자 = += -= *= /= %=
		// 조건연산자 (조건식) ? 참 값 : 거짓 값
		// 형변환연산자 (자료형)
		// 인스턴스확인연산자 instanceof

		System.out.println(5 + 3 * 4);
		System.out.println(-3 - 5);

		int x;
		int y;
		x = y = 3;
		System.out.println("x = " + x);
		System.out.println("y = " + y);

		System.out.println("====================");
		System.out.println("증감 연산자 후위형 i++");
		// 증감 연산자 ++(1 증가) --(1감소)
		int i = 5, j = 0;

		// i++;
		j = i++; // --> j = i; 수행 후 i++;를 수행
		System.out.println("j = i++; 실행 후, i = " + i + " j = " + j);

		System.out.println("====================");
		System.out.println("증감 연산자 전위형 ++i");
		i = 5;
		j = 0;

		j = ++i; // --> ++i; 수행 후 j = i; 수행
		System.out.println("j = ++i; 실행 후, i = " + i + " j = " + j);

		// 부호연산자
		int num = -10;
		num = -num; // 부호 반대로 바꾸는 표현
		System.out.println("num = " + num);

	} // main

}
