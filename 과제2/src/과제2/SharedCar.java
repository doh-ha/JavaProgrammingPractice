package 과제2;

public class SharedCar {

	private int perfectCar=0;
	String name;

	synchronized public void makeCar() {

perfectCar++;
System.out.println("차 하나를 생산합니다");
		}
	
	public int getPerfectCar() {
		return perfectCar;
	}
	}



