package 과제2;

public class SharedCar {

	private int remainCar=0; //재고
	public int perfectCar=0; //생산
	String name;
	int goal;
	int remain=0;

	private SharedCar car;
	private SharedBody b;
	private SharedWheel w;
	private SharedDoor d;

	synchronized public void makeCar(int carNum,SharedCar car,SharedWheel w, SharedDoor d,SharedBody b) {
		this.goal=carNum;
		this.car=car;
		this.b=b;
		this.w=w;
		this.d=d;
		setRemainCar(); //재고 +1
		perfectCar++; //생산 자동차 +1
		System.out.print("차 하나를 조립합니다.   ");
		b.setRemainBody(-1);
		w.setRemainWheel(-4);
		d.setRemainDoor(-2);
		System.out.println("차 조립 후 남은 각 재고 (바퀴, 몸체, 문 순서): "+ w.getRemainWheel() +" "+ b.getRemainBody() +" "+ d.getRemainDoor());
		}
	
	synchronized public void sellCar(int n,int carNum,SharedCar car) {
		this.goal=carNum;
		this.car=car;
	
		setRemainCar(-1); //재고 -1
		

	
		}
	
	private void setRemainCar() {
		// TODO Auto-generated method stub
		remainCar++;
	}

	private void setRemainCar(int n) {
		// TODO Auto-generated method stub
		remainCar=remainCar+n;
	}
	public int getRemainCar() {
		return remainCar;
	}
	
	private void setPerfectCar() {
		// TODO Auto-generated method stub
		perfectCar++;
	}

	private void setPerfectCar(int n) {
		// TODO Auto-generated method stub
		perfectCar=perfectCar+n;
	}
	public int getPerfectCar() {
		return perfectCar;
	}
	}



