package hw4;

import java.util.Scanner;

public class prac10 {

	public static void main(String[] args) {
		
		int randomNum = (int)(Math.random()*100) +1;
		int answer = 0;
		int count = 0;
		
		Scanner scanner = new Scanner(System.in);
		
		do {
			count++;
			System.out.printf("1에서 100 사이의 값을 입력하세요.>");
			answer = scanner.nextInt();
			
			if(answer > randomNum) {
				System.out.println("더 작은 수를 입력하세요.");
				
			}else if(answer <randomNum) {
				System.out.println("더 큰 수를 입력하세요.");
				
			}else {
				System.out.println("정답입니다.");
				System.out.printf("시도횟수는 %d번 입니다.", count);
				break;
			}
		
		}while( answer != randomNum);
		
		
	}

}
