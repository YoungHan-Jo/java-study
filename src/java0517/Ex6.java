package java0517;

public class Ex6 {

	public static void main(String[] args) {
		// �̸� ���� �ݺ���

		for (int i = 2; i <= 9; i++) {
			for (int j = 1; j <= 9; j++) {
				if (j == 5) {
					break;
				}
				System.out.println(i + "*" + j + "=" + i * j);
			}
			System.out.println();
		}
	} // main

}
