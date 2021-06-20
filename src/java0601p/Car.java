package java0601p;

public class Car {
	String color;
	String gearType;
	int door;
	
	Car(String color, String gearType, int door){
		this.color = color;
		this.gearType = gearType;
		this.door = door;
	}
	
	Car(){
		this("white","auto",4);
	}
	
	Car(String color){
		this(color,"auto",4);
	}
	
	void showCar(){
		System.out.printf("color : %s, gearType : %s, %d doors",color,gearType,door);
	}
}
