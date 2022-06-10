package microondas;

public class Lamp {

	public Boolean lampOn;
	
	public void lamp_on(){
		this.lampOn = true;
	}	
	public void lamp_off(){
		this.lampOn = false;
	}
	
	public Boolean isLampOn() {
		if(lampOn == true) { return true; } return false;
	}

}
