package java0624prac;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class Ex5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Random random = new Random();
		System.out.println("0이상 3미만의 임의의 정수 : " + random.nextInt(3));
		
		System.out.println(random.nextBoolean());
		System.out.println(random.nextFloat());
		
		System.out.println("==============================");
		
		Date date = new Date();
		System.out.println(date.toString());
		
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy년 MM월 dd일 a hh시 mm분 ss초");
		System.out.println(sdf.toString());
		String strDate = sdf.format(date);
		System.out.println(strDate);
		
		System.out.println("=================================");
		Calendar cal = Calendar.getInstance();
		System.out.println(cal.get(Calendar.YEAR));
		System.out.println(cal.get(Calendar.MONTH)+1);
		System.out.println(cal.get(Calendar.DATE));
		
		int ampm = cal.get(Calendar.AM_PM);
		System.out.println(ampm == 0 ? "오전" : "오후");
		
		System.out.println(cal.get(Calendar.HOUR));
		System.out.println(cal.get(Calendar.MINUTE));
		System.out.println(cal.get(Calendar.SECOND));
		
		
		
	}// main

}
