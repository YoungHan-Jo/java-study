package java0531;

// 도서관리 프로그램
// 클랫정의 Book
// 책 제목 - 문자열 title
// 책 가격 - 정수형 price
// 책 개수 - 정수형 count

// 총의 총 합계구하기 메소드 sum
// 단위 가격 * 개수 리턴

class Book {
	String title;
	int price;
	int count;
	
	int sum() {
		return price * count;
	}
	
}


public class Ex2 {

	public static void main(String[] args) {
		
		
		Book book1 = new Book();
		
		book1.title = "Java";
		book1.price = 25000;
		book1.count = 5;
		System.out.println(book1.title + " 다 팔면 "+ book1.sum());
		
		Book book2 = new Book();
		
		book2.title = "C";
		book2.price = 15000;
		book2.count = 3;
		System.out.println(book2.title + " 다 팔면 " +book2.sum());
		
		Book book3 = book2;
		
		System.out.println(book3.title + " 다 팔면 " +book3.sum());
		book3 = null; // 객체가 아니고 주소를 삭제하기 때문에 연결을 끊는것. 
		book2 = null; // 연결이 모두 끊어진 객체는 쓰레기 객체. java는 자동으로 삭제시켜줌
		
		
		
		
	} // main

}
