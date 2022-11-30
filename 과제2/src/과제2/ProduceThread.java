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

			if(b.getRemainBody()>=1 && w.getRemainWheel()>=4 && d.getRemainDoor()>=2) { //몸체는 하나, 바퀴는 4개, 문은 2개 이상 확보되어야지 조립 시작
				System.out.println();
				System.out.println("--------------------------------------------------------------------");
				car.makeCar(goal,car,w,d,b);
				
				System.out.println("자동차 조립 스레드   조립 자동차: " + car.getPerfectCar()  + "   자동차 재고: "+ car.getRemainCar());
				System.out.println("--------------------------------------------------------------------");
			}
			
			
			
			try {

				if(car.getRemainCar()==goal) {
					
					flag=true;
					
					System.out.println("자동차 조립을 종료합니다.");
					System.out.println();
					break;
					
				}
				Thread.sleep(100);
			}
			catch(InterruptedException e) {return;}
		}
	}
	

}

