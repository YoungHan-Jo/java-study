package java0623;

final class FinalTest{ // final 클래스 - 상속을 못하게 막는다. 자식을 못가지게, 확장 할 수 없음.
	public static final int MAX_SIZE = 10;
	
	final int getMaxSize() { // 메소드 오버라이딩(재정의) 못하게 막음                  
		final int LV_MAX = MAX_SIZE;
		return MAX_SIZE;
	}
}

//class FinalSubTest extends FinalTest{	
//	
//}

public class Ex4 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		
		
		
	} // main

}
