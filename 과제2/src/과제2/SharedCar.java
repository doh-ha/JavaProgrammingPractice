package 과제2;

public class SharedCar {

	private int perfectCar=0;
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

		perfectCar++;
		System.out.print("차 하나를 조립합니다.   ");
		b.setRemainBody(-1);
		w.setRemainWheel(-4);
		d.setRemainDoor(-2);
		System.out.println("차 조립 후 남은 각 재고 (바퀴, 몸체, 문 순서): "+ w.getRemainWheel() +" "+ b.getRemainBody() +" "+ d.getRemainDoor());
		}
	
	public int getPerfectCar() {
		return perfectCar;
	}
	}



