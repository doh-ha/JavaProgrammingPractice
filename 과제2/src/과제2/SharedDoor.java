package 과제2;


public class SharedDoor {
//4개 set
	private int remainDoor=0;
int n;


	synchronized public void setRemainDoor() {
		remainDoor++;
		}
	synchronized public void setRemainDoor(int n) {
		remainDoor=remainDoor+n;
		}
	

	public int getRemainDoor() {
		return remainDoor;
	}
	}