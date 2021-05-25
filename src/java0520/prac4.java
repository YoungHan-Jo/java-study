package java0520;

public class prac4 {

	public static void main(String[] args) {
		// 11, 88, 77, 22, 44, 99, 55, 66, 5, 33

		int[] numArr = { 11, 88, 77, 22, 44, 99, 55, 66, 5, 33 };

		for (int i = 0; i < numArr.length; i++) {
			for (int j = i + 1; j < numArr.length; j++) {
				if (numArr[i] < numArr[j]) {
					int tmp = numArr[i];
					numArr[i] = numArr[j];
					numArr[j] = tmp;
				}
			}
		}
		for(int i = 0; i<numArr.length;i++) {
			System.out.print(numArr[i] + " ");
		}
		
		
		
		
	}//main

}
