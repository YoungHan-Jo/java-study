package java0623p;

public class Chap7_28 {

	public static void main(String[] args) {

		Buyer b = new Buyer();

		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Audio());
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Computer());
		b.buy(new Tv());
		b.buy(new Computer());

		b.summary();

	} // main

}
