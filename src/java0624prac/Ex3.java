package java0624prac;

import java.util.StringTokenizer;

public class Ex3 {

	public static void main(String[] args) {
		// StringBuffer
		
		StringBuffer sb = new StringBuffer();
		sb.append("Java");
		sb.append(" Programming");
		
		System.out.println(sb.toString());
		
		sb.replace(0, 4, "JSP");
		System.out.println(sb.toString());
		
		//System.out.println(sb.lastIndexOf("g"));
		
		sb.insert(15, "!");
		System.out.println(sb.toString());
		
		System.out.println("================================");
		
		
		StringTokenizer st = new StringTokenizer("사과#배#수박#감#포도","#");
		
		while(st.hasMoreTokens()) {
			System.out.println(st.countTokens());
			System.out.println(st.nextToken());
			System.out.println("남은 토큰 개수 : " + st.countTokens());
			System.out.println("================================");
		}
		
		String query = new String("name=홍길동&add=busan&age=23");
		
		StringTokenizer p1 = new StringTokenizer(query, "=&");
		while(p1.hasMoreTokens()) {
			System.out.println(p1.nextToken());
		}

	} // main

}
