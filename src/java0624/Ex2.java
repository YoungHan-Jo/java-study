package java0624;

import java.util.Arrays;

public class Ex2 {

	public static void main(String[] args) {
		// String 클래스
		String str = "Java Programming";

		System.out.println(str.length()); // 문자열 길이(문자개수)

		if (str.equals("Java Programming")) {
			System.out.println("문자열 같음");
		}

		System.out.println("charAt(0) : " + str.charAt(0)); // char charAt(i) - i 번 인덱스 문자 하나 호출 // String 객체는 char배열과같음
		System.out.println("substring(5) : " + str.substring(5)); // String substring(i) - i번 인덱스부터 끝까지 호출
		System.out.println("substring(5,8) : " + str.substring(5, 8)); // String substring(i,j) - 인덱스 i 이상 j미만까지 호출
		System.out.println("문자열 연결 : " + str + "!!!");
		System.out.println("문자열 대체 : " + str.replace("Java", "JSP")); // replace(바꿀문자열, 새 문자열)
		System.out.println("문자열 앞에서부터 첫 인덱스 위치 : " + str.indexOf('a'));
		System.out.println("문자열 뒤에서부터 첫 인덱스 위치 : " + str.lastIndexOf('a'));
		System.out.println("문자열 인덱스 위치 : " + str.indexOf("gram")); // g 인덱스 위치로 친다
		System.out.println("대문자로 변환 : " + str.toUpperCase());
		System.out.println("소문자로 변환 : " + str.toLowerCase());

		System.out.println("=========================================");
		// 문자열 분리
		String[] strArr = str.split(" "); // 공백을 기준으로 분리
		System.out.println(Arrays.toString(strArr));
		for (String string : strArr)
			System.out.println(string);

		String[] strArr2 = str.split(""); // 모든 문자 분리
		System.out.println(Arrays.toString(strArr2));

		System.out.println("=======================================");

		System.out.println("특정문자 포함 유무 : " + str.contains("Pro"));
		System.out.println("특정문자로 시작하는지 : " + str.startsWith("Jav"));
		System.out.println("특정문자로 끝나는지 : " + str.endsWith("ing"));

		System.out.println("====================================");

		String str2 = "   [안  녕]   ";
		System.out.println(str2);
		System.out.println("좌우 공백을 없애기 : " + str2.trim());

		System.out.println("======================================================================");
		// 주민번호 남,여 구분 - > 1,3 남 // 2,4 여
		String jumin = "981220-3234567";

		int beginIndex = jumin.indexOf("-") + 1;
		
		System.out.println("주민번호 뒷자리 시작 인덱스 번호 : " + beginIndex); // index = 7
		
		char ch = jumin.charAt(beginIndex);
		String genderNum = jumin.substring(beginIndex, beginIndex + 1);
		
		
		if (ch == '1' || ch == '3') {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}

		System.out.println("===================================");

		if (genderNum.equals("1") || genderNum.equals("3")) {
			System.out.println("남자");
		} else {
			System.out.println("여자");
		}

		// 부분문자열 가져오기

	} // main
}
