package java0624;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Ex5 {

	public static void main(String[] args) {
		// Random 클래스: 임의의 값을 생성해주는 클래스
		
		Random random = new Random();
		System.out.println("0이상 10미만의 임의의 정수 : " +random.nextInt(10));
		
		System.out.println(random.nextBoolean());
		System.out.println(random.nextFloat());
		
		System.out.println("=============================");
		
		// 날짜와 시간: Date 클래스, Calendar 클래스
		
		Date date = new Date();
		System.out.println(date); // date.toString() 생략
		
		// yyyy 년도, MM 월 dd 일 a오전/오후 hh 시(HH 24시) mm 분 ss 초
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초 "); // 데이터 포맷
		String strDate = sdf.format(date);
		System.out.println(strDate);
		
		System.out.println("=============================");
		
		Calendar cal = Calendar.getInstance(); // 현재 날짜와 시간정보를 가짐
		
		System.out.println(cal.get(Calendar.YEAR) + "년"); // Calendar.year 은 스태틱 변수.
		
		System.out.println((cal.get(Calendar.MONTH)+1)+ "월"); // 월은 0부터 시작해서 + 1 해줘야함 
		
		System.out.println(cal.get(Calendar.DATE) + "일");
		
		int amPm = cal.get(Calendar.AM_PM); // 0 or 1 로 구분만 해줌
		System.out.println(amPm == 0 ? "오전" : "오후");
		
		
		System.out.println(cal.get(Calendar.HOUR) + "시");
		System.out.println(cal.get(Calendar.MINUTE) + "분");
		System.out.println(cal.get(Calendar.SECOND) + "초");

		//요일은 일요일부터 1번으로 시작
		int day = cal.get(Calendar.DAY_OF_WEEK);
		
		switch(day) {
		case 1:
			System.out.println("일요일");
			break;
		case 2:
			System.out.println("월요일");
			break;
		case 3:
			System.out.println("화요일");
			break;
		case 4:
			System.out.println("수요일");
			break;
		case 5:
			System.out.println("목요일");
			break;
		case 6:
			System.out.println("금요일");
			break;
		case 7:
			System.out.println("토요일");
			break;
		}
		
		System.out.println("=========================");
		
		// Math : 수학관련 static 멤버로 구성됨
		// 객체로 사용하지 않음
		
		System.out.println(Math.PI);
		System.out.println(Math.abs(-11));
		System.out.println(Math.max(20, 30));
		System.out.println(Math.pow(2,3)); // 리턴값 double
		
		// 소수점 첫째자리 가준으로 반올림round , 올림 ceil, 내링 floor
		System.out.println(Math.round(3.4));
		System.out.println(Math.ceil(3.1)); // 리턴값 double
		System.out.println(Math.floor(3.8)); // 리턴값 double
		
		
		
		
		
		
		
	} //main

}
