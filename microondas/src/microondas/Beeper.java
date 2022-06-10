package microondas;

public class Beeper {

	private Beeper beeper ;

	public void beep(int d) { 
			int i = 0;
			while(d > 0) { 
				i++;	
				System.out.println("Ruido de finalización" + i);
			}
	}

	public Beeper getBeeper() {
		return beeper;
	}

	public void setBeeper(Beeper beeper) {
		this.beeper = beeper;
	}
}

