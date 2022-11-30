package 과제2;

public class WheelThread extends Thread{
	int goal;
	int remain=0;
	int finWheel=0;

	boolean flag = false; // false로 초기화
	private SharedCar car;	
	private SharedWheel w;
	public void finish() { flag = true; }

	public WheelThread() {
		
	}
	
	public WheelThread(int carNum, SharedCar car, SharedWheel w) {
		this.goal=carNum*4; //목표 바퀴 개수. 차 하나 당 4개 하므로 carNum의 4배
		this.car=car;
		this.w=w;
	}
	
	public void run() {
		while(true) {

			finWheel++;//바퀴 하나 완성 (생산바퀴)
			w.setRemainWheel(); //재고에 하나 추가

			System.out.println("바퀴 스레드   생산 바퀴: " + finWheel + "   바퀴 재고: "+ w.getRemainWheel());
			
			try {
				if(finWheel==goal) { //생산 바퀴가 목표치 달성하면 종료
			
					flag=true;
					
					System.out.println("바퀴 생산을 종료합니다.");
					System.out.println();
					break;
					
					
				}
				Thread.sleep(30); //0.3초마다 생산
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}
