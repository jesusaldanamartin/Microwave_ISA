package microondas;

public class Heating extends Microwave {
	

	// Atributos
	private Boolean heating;
	private Integer power;
	
	// Constructor
	public Heating(int p, int t) {
		super(p, t);
		// TODO Auto-generated constructor stub
	}
		
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
