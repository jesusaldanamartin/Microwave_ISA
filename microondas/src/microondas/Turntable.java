package microondas;

public class Turntable {

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
