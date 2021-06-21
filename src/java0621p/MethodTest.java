package java0621p;

public class MethodTest {

	public void printData(int... nums) {
		for(int i = 0; i <nums.length; ++i)
			System.out.print(nums[i] + "\t");
	}
}
