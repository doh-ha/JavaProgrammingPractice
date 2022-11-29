package 과제2;

public class SharedWheel {
//4개 set
	private int remainWheel=0;
int n;


	synchronized public void setRemainWheel() {
		remainWheel++;
		}
	synchronized public void setRemainWheel(int n) {
		remainWheel=remainWheel+n;
		}
	

	public int getRemainWheel() {
		return remainWheel;
	}
	}