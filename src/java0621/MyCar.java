package java0621;

public class MyCar {
	// 멤버변수
	private String color;
	private String gearType; // "auto" "manual"
	private int doorCount;

	public MyCar() {
		this("white", "auto", 4);
	}

	public MyCar(String color) {
		this(color, "auto", 4);
	}

	public MyCar(String color, String gearType) {
		this(color, gearType, 4);
	}

	public MyCar(String color, String gearType, int doorCount) {
		this.color = color;
		this.gearType = gearType;
		this.doorCount = doorCount;
	}

	public String getColor() {
		return color;
	}

	public String getGearType() {
		return gearType;
	}

	public int getDoorCount() {
		return doorCount;
	}

	public void setColor(String color) {
		this.color = color;
	}

	public void setGearType(String gearType) {
		this.gearType = gearType;
	}

	public void setDoorCount(int doorCount) {
		this.doorCount = doorCount;
	}
	
	public void showCar() {
		System.out.printf("자동차 색상 : %s\n", color);
		System.out.printf("기어타입 : %s\n", gearType);
		System.out.printf("문 개수 : %d\n", doorCount);
		System.out.println("===========================");
	}
	
	// static 요소는 객체의 구성요소가 아님.
	// 클래스단위로 사용가능한 요소를 지정함.
	public static void main(String[] args) {
		MyCar car1 = new MyCar();
		car1.setColor("blue");
		car1.setGearType("manual");
		car1.setDoorCount(2);
		car1.showCar();
		
		MyCar car2 = new MyCar("red");
		car2.showCar();
		
		MyCar car3 = new MyCar("yellow", "manual");
		car3.showCar();
		
		MyCar car4 = new MyCar("green","manual",3);
		car4.showCar();
	} // main
}
