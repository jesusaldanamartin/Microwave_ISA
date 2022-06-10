package microondas;

public class Heating {
	

	// Atributos
	private Boolean heating;
	private Integer power;
	
	// Metodos
	public void heating_on(){
		this.heating = true;
	}	
	public void heating_off(){
		this.heating = false;
	}

	public Boolean isHeating() {
		if(this.heating == true) { return true; } return false;
	}
	
	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}
}
