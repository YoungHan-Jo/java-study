package java0623p;

public abstract class Unit {
	int x, y;

	
	
	abstract void move(int x, int y);

	void stop() {
		System.out.println("현재위치에 정지");
	}
}

class Marine extends Unit {

	@Override
	void move(int x, int y) {
		System.out.println( "Marine " + x + "." + y + "로 이동");
	}

	void stimPack() {
		System.out.println("스팀팩을 사용한다");
	}

}

class Tank extends Unit {

	@Override
	void move(int x, int y) {
		System.out.println("Tank " + x + "." + y + "로 이동");

	}
	
	void modeChange() {
		System.out.println("모드 변경");
	}

}

class Dropship extends Unit {

	@Override
	void move(int x, int y) {
		System.out.println("Dropship " +x + "." + y +"로 이동");
		
	}
	
	void load() {
		System.out.println("유닛을 태운다");
	}
	
	void unload() {
		System.out.println("유닛을 내린다");
	}
	
}
