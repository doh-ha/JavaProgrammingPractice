package 과제2;


public class BodyThread extends Thread{
	int goal;
	int remain=0;
	int finBody=0;
	private SharedCar car;
	private SharedBody b;
	boolean flag = false; // false로 초기화
	public void finish() { flag = true; }

	public BodyThread() {
		
	}
	
	public BodyThread(int carNum,SharedCar car,SharedBody b) {
		this.goal=carNum; //목표 몸체 개수 
		this.car=car;
		this.b=b;
	}
	

	
	public void run() {
		while(true) {

			finBody++;//몸체 하나 완성 (생산몸체)
			b.setRemainBody(); //몸체 재고 저장
			
			
			System.out.println("몸체 스레드   생산 몸체: " + finBody + "   몸체 재고: "+ b.getRemainBody());
			
			try {
				if(finBody==goal) { //생산 몸체가 목표치 달성하면 종료
					
					flag=true;
					
					System.out.println("몸체 생산을 종료합니다.");
					System.out.println();
					break;
					
				}
				Thread.sleep(80); //0.8초마다 생산
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}

