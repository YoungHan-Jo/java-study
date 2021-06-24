package java0623p;

public class Product {
	int price;
	int bonusPoint;

	public Product(int price) {
		this.price = price;
		bonusPoint = (int) price / 10;
	}
}

class Tv extends Product {

	Tv() {
		super(100);
	}

	@Override
	public String toString() { // 객체 출력시 나올 문자열
		return "Tv";
	}
}

class Computer extends Product {

	Computer() {
		super(200);
	}

	@Override
	public String toString() {
		return "Computer";
	}

}

class Audio extends Product {

	Audio() {
		super(50);
	}

	@Override
	public String toString() {
		return "Audio";
	}

}
