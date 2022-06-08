package microondas;

public class Display extends Microwave {

	private String display;
	
	public Display(int p, int t) {
		super(p, t);
		// TODO Auto-generated constructor stub
	}

	public String getDisplay() {
		return display;
	}
	
	public void setDisplay(String display) {
		this.display = display;
	}
	
	public void clearDisplay() {
		display = null;
	}
	
}
