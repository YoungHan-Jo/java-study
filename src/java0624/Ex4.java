package java0624;

public class Ex4 {

	public static void main(String[] args) {
		// Wrapper 클래스
		// 자바는 기본적으로 객체지향언어이므로 객체를 대상으로 처리하는 경우가 많음. ( 기본자료형 8개는 객체가 아님)
		// 기본자료형의 값을 객체로 만들어서 사용할 수 있도록 대응되는 Wrapper 클래스를 제공함.
		
		// 기본자료형	<->		래퍼클래스(객체자료형)
//			byte		<-> 	Byte
//			short		<->		Short
//			int			<->		Integer
//			long		<-> 	Long
//			float		<->		Float
//			double		<->		Double
//			char		<->		Character
//			boolean		<->		Boolean
		
		System.out.println(Integer.MIN_VALUE); // int 의 최소값
		System.out.println(Integer.MAX_VALUE); // int 의 최대값
		
		
		// 문자열"30" -> 기본자료형 숫자 30으로 바꾸기
		int a = Integer.parseInt("30"); // parse로 시작하는 메소드는 문자열을 처리대상
		System.out.println(a);
		
		System.out.println("======================");
		
		// int를 Integer 객체로 [박싱(포장)]하기
		Integer i1 = Integer.valueOf(20);
		Integer i2 = Integer.valueOf("30");
		
		int n1 = i1.intValue(); //Integer객체를 int로 [언박싱]하기
		int n2 = i2.intValue();
		
		System.out.println(n1+n2);
		
		System.out.println("==================================");
		
		Integer i3 = Integer.valueOf(i1.intValue() + i2.intValue()); // JDK 5 전에는 일일이 박싱|언박싱 해야했음.
		
		Integer i4 = i1 + i2; // JDK 5 버전 이후에는 자동 박싱|언박싱 지원됨
		
		System.out.println("i4 = " + i4);
		
		System.out.println("====================");
		
		Integer num = 200; // 자동 박싱 Integer.valueOf(200) 로 컴파일됨. // 객체화
		int num2 = num; // 자동언박싱 num.intValue() 로 컴파일됨.
		
		
		Float fnum = 3.14F; // Float.valueOf(3.14F) 자동 박싱
		float fnum2 = fnum; // fnum.floatValue(); 자동 언박싱
		
		
		float fnum3 = Float.parseFloat("3.14"); // 문자열을 숫자형으로 변환. 
		
		System.out.println("fnum3 = " + fnum3);
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	} // main

}
