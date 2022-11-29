package 과제2;


public class ProduceThread extends Thread{
	int goal;
	int remain=0;

	private SharedCar car;
	private SharedBody b;
	private SharedWheel w;
	private SharedDoor d;
	boolean flag = false; // false로 초기화
	public void finish() { flag = true; }

	public ProduceThread() {
		
	}
	
	public ProduceThread(int carNum,SharedCar car,SharedWheel w, SharedDoor d,SharedBody b) {
		this.goal=carNum;
		this.car=car;
		this.b=b;
		this.w=w;
		this.d=d;
	}
	

	
	public void run() {
		while(true) {

	

			if(b.getRemainBody()>=1 && w.getRemainWheel()>=4 && d.getRemainDoor()>=2) {
				car.makeCar();
				System.out.println("몸체 스레드   생산 몸체: " + car.getPerfectCar() + "   몸체 재고: "+ "null");
				b.setRemainBody(-1);
				w.setRemainWheel(-4);
				d.setRemainDoor(-2);
			}
			
			
			
			try {
				Thread.sleep(80);

				
				if(car.getPerfectCar()==goal) {
					
					flag=true;
					System.out.println("몸체 생산을 종료합니다.");
					break;
					
				}
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}

