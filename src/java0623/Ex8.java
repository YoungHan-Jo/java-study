package java0623;

interface ITest1 {
	void methodITest1();
}

interface ITest2 {
	void methodITest2();
}

interface ITest3 extends ITest1, ITest2 {
	void methodITest3();
}

abstract class AbsTest1 {
}

abstract class AbsTest2 {
}

class SubTest extends AbsTest1 implements ITest1 {
	@Override
	public void methodITest1() {
	}
}

class SubTest2 implements ITest1, ITest2 {
	@Override
	public void methodITest2() {
	}

	@Override
	public void methodITest1() {
	}
}

class SubTest3 implements ITest3 {

	@Override
	public void methodITest1() {
	}

	@Override
	public void methodITest2() {
	}

	@Override
	public void methodITest3() {
	}
}

public class Ex8 {

	public static void main(String[] args) {

	} // main

}
