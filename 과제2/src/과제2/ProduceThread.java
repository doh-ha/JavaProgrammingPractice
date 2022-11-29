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
				
				System.out.println("자동차 조립 스레드   조립 자동차: " + car.getPerfectCar() + "   자동차 재고: "+ "null");
				b.setRemainBody(-1);
				w.setRemainWheel(-4);
				d.setRemainDoor(-2);
			}
			
			
			
			try {
				Thread.sleep(100);

				
				if(car.getPerfectCar()==goal) {
					
					flag=true;
					System.out.println("자동차 조립을 종료합니다.");
					break;
					
				}
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}

