package java0520;

public class prac2 {

	public static void main(String[] args) {
		// 
		int sum = 0;
		
		for(int i = 1; i <300; i++) {
			if(i%2 == 0) {
				sum += -i;
			}else {
				sum += i;	
			}
			
			if(sum >=100) {
				System.out.printf("%d 까지 더하면 %d", i , sum);
				break;
			}
			
		}
		
		
		
		
	}//main
}
