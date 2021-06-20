package java0531prac;

//도서관리 프로그램
//클랫정의 Book
//책 제목 - 문자열 title
//책 가격 - 정수형 price
//책 개수 - 정수형 count

//총의 총 합계구하기 메소드 sum
//단위 가격 * 개수 리턴

public class Ex2 {
	public static void main(String[] args) {

		Book[] bookArr = new Book[3];
		
		for(int i = 0 ; i < bookArr.length; ++i)
			bookArr[i] = new Book();
		
	}// main
}

class Book {
	String title;
	int price;
	int count;

	int sum() {
		return price * count;
	}
}