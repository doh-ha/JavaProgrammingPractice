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
		this.goal=carNum;
		this.car=car;
		this.b=b;
	}
	

	
	public void run() {
		while(true) {

			finBody++;//바퀴 하나 완성 (생산바퀴)
			b.setRemainBody();
			if(b.getRemainBody()>4) {
				b.setRemainBody(4);
			}
			
			System.out.println("몸체 스레드   생산 몸체: " + finBody + "   몸체 재고: "+ b.getRemainBody());
			
			try {
				

				
				if(finBody==goal) {
					
					flag=true;
					
					System.out.println("몸체 생산을 종료합니다.");
					System.out.println();
					break;
					
				}
				Thread.sleep(80);
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}

