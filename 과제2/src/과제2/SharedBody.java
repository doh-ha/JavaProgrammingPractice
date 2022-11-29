package 과제2;

public class SharedBody {

	private int remainBody=0;
int n;


	synchronized public void setRemainBody() {
		remainBody++;
		}
	synchronized public void setRemainBody(int n) {
		remainBody=remainBody+n;
		}
	

	public int getRemainBody() {
		return remainBody;
	}
	}