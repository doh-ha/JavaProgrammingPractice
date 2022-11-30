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
		this.goal=carNum*2; //목표 문 개수. 차 하나 당 2개 필요
		this.car=car;
		this.d=d;
	}
	
	public void run() {
		while(true) {
 
			finDoor++; //문 하나 완성 (생산 문)
			d.setRemainDoor();  //문 재고
 
			
			System.out.println("문 스레드   생산 문: " + finDoor + "   문 재고: "+ d.getRemainDoor());
			
			try {
				

				if(finDoor==goal) { //생산 문 개수가 목표치 달성하면 종료
			
					flag=true;
					
					System.out.println("문 생산을 종료합니다.");
					System.out.println();
					break;
					
					
				}
				Thread.sleep(50); //0.5초마다 생산
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}
