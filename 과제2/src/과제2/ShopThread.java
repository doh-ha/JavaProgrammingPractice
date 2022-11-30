package 과제2;


public class ShopThread extends Thread{
	int goal;
	int remain=0;
	int no;
	int eachShopSell=0; //각 가계가 판매 완료한 대수
	private SharedCar car;

	boolean flag = false; // false로 초기화
	public void finish() { flag = true; }

	public ShopThread() {
		
	}
	
	public ShopThread(int n,int carNum,SharedCar car) {
		this.goal=carNum/3; //영업점 3개이므로 3으로 나눈 값 할당 받음
		this.car=car;
		this.no=n; //몊 번 째 영업점인지

	}
	

	
	public void run() {
		while(true) {

			if(car.getRemainCar()>=1) { //재고가 하나 이상이어야지 판매 가능
				eachShopSell++;
				car.sellCar(no, goal, car);
				System.out.println();
				System.out.println("*****************************************");
				System.out.println("영업점" +no+"    판매대수: " + eachShopSell + "   재고: "+ car.getRemainCar());
				System.out.println("*****************************************");
				System.out.println();
			}
			
			
			
			try {
				

				
				if(eachShopSell==goal) { //각 영업점에 할당된 목표치 달성하면 판매 종료
					
					flag=true;
					
					System.out.println("영업점" +no+" 의 판매을 종료합니다.");
					System.out.println();
					break;
					
				}
				Thread.sleep(50);
			}
			catch(InterruptedException e) {return;}
		}
	}


	

}

