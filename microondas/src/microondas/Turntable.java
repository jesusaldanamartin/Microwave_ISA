package microondas;

public class Turntable extends Microwave {

	public Turntable(int p, int t) {
		super(p, t);
		// TODO Auto-generated constructor stub
	}

	public Boolean turntableOn;
	
	public void turntable_start(){
		this.turntableOn = true;
	}	
	public void turntable_stop(){
		this.turntableOn = false;
	}
	
	public Boolean isMoving() {
		if(turntableOn == true) { return true; } return false;
	}
}
