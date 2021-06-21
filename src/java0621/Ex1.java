package java0621;

public class Ex1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		MyDate day1 = new MyDate();
		day1.showMyDate();

		MyDate day2 = new MyDate(2030);
		day2.showMyDate();

		MyDate day3 = new MyDate(2025, 5);
		day3.showMyDate();

		MyDate day4 = new MyDate(2035, 9, 8);
		day4.showMyDate();

		MyDate day5 = new MyDate();
		day5.setYear(2021);
		day5.setMonth(6);
		day5.setDate(21);
		System.out.printf("%d-%d-%d\n", day5.getYear(), day5.getMonth(), day5.getDate());

	} // main

} // class Ex1
