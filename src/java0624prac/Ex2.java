package java0624prac;

class Value {
	int value;
	
	Value(int value){
		this.value = value;
	}
}

public class Ex2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Value v1 = new Value(10);
		Value v2 = new Value(10);
		
		
		if(v1.equals(v2)) {
			System.out.println("서로 같음");
		}else {
			System.out.println("서로 다름");
		}
		
		System.out.println(v1.toString());
		
		System.out.println("=========================");
		
		String str1 = new String("안녕");
		String str2 = "안녕";
		
		if(str1.equals(str2)){
			System.out.println("서로 같음");
		}else {
			System.out.println("서로 다름");
		}
		
		System.out.println(str1.toString());
		
	} // main

}
