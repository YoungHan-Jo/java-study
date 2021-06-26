package java0624prac;

public class Ex4 {

	public static void main(String[] args) {
		
		int a = Integer.parseInt("30");
		System.out.println(a);
		a = Integer.valueOf("20");
		System.out.println(a);
		
		System.out.println("============================");
		
		Integer i1 = Integer.valueOf(10);
		Integer i2 = Integer.valueOf("20");
		
		int n1 = i1.intValue();
		int n2 = i2.intValue();
		
		System.out.println(n1 + n2);
		
		System.out.println("===============================");
		
		Integer i3 = Integer.valueOf(i1.intValue() + i2.intValue());
		
		Integer i4 = i1 + i2;
		
		System.out.println(i3.toString());
		
		System.out.println(i4.toString());
		
		System.out.println("=============================");
		
		
		Integer num = 200;
		
		int num2 = num;
		
		Float fnum = Float.valueOf(3.14F);
		
		float fnum2 = fnum.floatValue();
		
		System.out.println(fnum2);
		
		float fnum3 = Float.parseFloat("3.14");
		
		String str = String.valueOf(num2);
		
		System.out.println(str);
		
	} // main

}
