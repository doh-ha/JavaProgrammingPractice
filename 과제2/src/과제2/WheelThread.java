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
		this.goal=carNum*4;
		this.car=car;
		this.w=w;
	}
	
	public void run() {
		while(true) {

			finWheel++;//바퀴 하나 완성 (생산바퀴)
			w.setRemainWheel(); //재고에 하나 추가
//			if(w.getRemainWheel()>4) { 
//				w.setRemainWheel(4);
//				
//			}
			//remain=car.getPerfectCar(); 
			
			System.out.println("바퀴 스레드   생산 바퀴: " + finWheel + "   바퀴 재고: "+ w.getRemainWheel());
			
			try {
				

				if(finWheel==goal) {
			
					flag=true;
					System.out.println("바퀴 생산을 종료합니다.");
					break;
					
					
				}
				Thread.sleep(30);
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}
