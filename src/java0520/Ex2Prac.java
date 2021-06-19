package java0520;

public class Ex2Prac {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int[] score = new int[]{100,90,80,70,67};
		int sum = 0;
		float avg = 0.0f;
		
//		for(int i = 0; i < score.length; ++i)
//		sum += score[i];
		
		for(int num : score)
			sum += num;
		
		avg = (float)sum/score.length;
		
		System.out.println("합계 : "+sum);
		System.out.println("평균 : "+avg);
	}

}
