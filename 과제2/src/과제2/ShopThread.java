package 과제2;


public class ShopThread extends Thread{
	int goal;
	int remain=0;
	int no;
int eachShopSell=0;
	private SharedCar car;

	boolean flag = false; // false로 초기화
	public void finish() { flag = true; }

	public ShopThread() {
		
	}
	
	public ShopThread(int n,int carNum,SharedCar car) {
		this.goal=carNum/3;
		this.car=car;
		this.no=n; //몊 번 째 영업점

	}
	

	
	public void run() {
		while(true) {

			if(car.getRemainCar()>=1) {
				eachShopSell++;
				car.sellCar(no, goal, car);
				System.out.println();
				System.out.println("*****************************************");
				System.out.println("영업점" +no+"    판매대수: " + eachShopSell + "   재고: "+ car.getRemainCar());
				System.out.println("*****************************************");
				System.out.println();
			}
			
			
			
			try {
				

				
				if(eachShopSell==goal) {
					
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

