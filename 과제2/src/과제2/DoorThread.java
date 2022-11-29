package 과제2;

public class DoorThread extends Thread{
	int goal;
	int remain=0;
	int finDoor=0;

	boolean flag = false; // false로 초기화
	private SharedCar car;	
	private SharedDoor d;
	public void finish() { flag = true; }

	public DoorThread() {
		
	}
	
	public DoorThread(int carNum, SharedCar car, SharedDoor d) {
		this.goal=carNum*2;
		this.car=car;
		this.d=d;
	}
	
	public void run() {
		while(true) {

			finDoor++;
			d.setRemainDoor();
			if(d.getRemainDoor()>2) {
				d.setRemainDoor(2);
				//car.makeCar("바퀴");
				
				
				//remain=remain-4;
			}
			//remain=car.getPerfectCar(); 
			
			System.out.println("문 스레드   생산 문: " + finDoor + "   문 재고: "+ d.getRemainDoor());
			
			try {
				Thread.sleep(50);

				if(finDoor==goal) {
			
					flag=true;
					System.out.println("문 생산을 종료합니다.");
					break;
					
					
				}
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}
