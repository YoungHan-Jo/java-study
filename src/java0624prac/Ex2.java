package java0624prac;

import java.util.Arrays;

class Value {
	int value;

	Value(int value) {
		this.value = value;
	}

	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return String.valueOf(value);
	}

	@Override
	public boolean equals(Object obj) {

		if (!(obj instanceof Value)) // 다운캐스팅 가능한지 확인
			return false;

		boolean result = false;

		Value value = (Value) obj; // 다운캐스팅 후 비교하기

		if (this.value == value.value) // 숫자형은 그냥 비교, String은 equeals() 로 비교
			result = true;
		else
			result = false;

		return result;
	}

}

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Value v1 = new Value(10);
		Value v2 = new Value(10);

		if (v1.equals(v2)) {
			System.out.println("서로 같음");
		} else {
			System.out.println("서로 다름");
		}

		System.out.println(v1.toString());

		System.out.println("=========================");

		String str1 = new String("안녕");
		String str2 = "안녕";

		if (str1.equals(str2)) {
			System.out.println("서로 같음");
		} else {
			System.out.println("서로 다름");
		}

		System.out.println(str1.toString());
		
		System.out.println("============================");
		
		
		String str = new String("강아지,곰,호랑이,고양이,기린,코끼리");
		
		String[] strArr = str.split(",");
		
		for(String s : strArr) {
			System.out.println(s);
		}
		
		System.out.println("=============================");
		
		String joinStr = String.join("-", strArr);
		System.out.println(joinStr);

	} // main

}
