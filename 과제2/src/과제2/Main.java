package 과제2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int carNum;
		Scanner sc=new Scanner(System.in);
		System.out.println("자동차 대수를 입력하세요:");
		carNum=sc.nextInt();
		
		SharedCar car=new SharedCar();
		
		SharedWheel w=new SharedWheel();
		SharedBody b=new SharedBody();
		SharedDoor d=new SharedDoor();
		
		WheelThread wheel=new WheelThread(carNum,car,w);
		BodyThread body=new BodyThread(carNum,car,b);
		DoorThread door=new DoorThread(carNum,car,d);
		ProduceThread produce=new ProduceThread(carNum,car,w,d,b);
		wheel.start();
		body.start();
		door.start();
		produce.start();
	}
}
