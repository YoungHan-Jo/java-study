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
			System.out.printf("1���� 100 ������ ���� �Է��ϼ���.>");
			answer = scanner.nextInt();
			
			if(answer > randomNum) {
				System.out.println("�� ���� ���� �Է��ϼ���.");
				
			}else if(answer <randomNum) {
				System.out.println("�� ū ���� �Է��ϼ���.");
				
			}else {
				System.out.println("�����Դϴ�.");
				System.out.printf("�õ�Ƚ���� %d�� �Դϴ�.", count);
				break;
			}
		
		}while( answer != randomNum);
		
		
	}

}
