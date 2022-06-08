package microondas;

public class Beeper extends Microwave {

	private Beeper beeper ;

	public Beeper(int p, int t) {
		super(p, t);
		// TODO Auto-generated constructor stub
	}

	public void beep(int d) { 
		if(beeper.getTimer() == 0) {
			System.out.println("La alarma sonará" + d + "segundos");
//			int i = 0;
//			while(d > 0) { 
//				i++;
//				System.out.println("¡La comida se termino hace" + i + "segundos!");
//					
//			} 	
		}
		}
	

}
