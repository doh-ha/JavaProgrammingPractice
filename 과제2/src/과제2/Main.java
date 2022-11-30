package 과제2;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		int carNum;
		int n=0;
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
		
		ShopThread shop1=new ShopThread(1, carNum, car);
		ShopThread shop2=new ShopThread(2, carNum, car);
		ShopThread shop3=new ShopThread(3, carNum, car);
		wheel.start();
		body.start();
		door.start();
		produce.start();
		shop1.start();
		shop2.start();
		shop3.start();
	}
}
