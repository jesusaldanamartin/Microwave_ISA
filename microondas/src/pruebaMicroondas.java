import microondas.*;
import states.*;

public class pruebaMicroondas {

	public static void main(String[] args) {
		
		// constructor --> door, cook, item, power timer
		
		ClosedWithNoItem closed_no = new ClosedWithNoItem(false, false, false, 0, 0);
		OpenWithNoItem open_no = new OpenWithNoItem(true, false, false, 0, 0);
		OpenWithItem open_yes= new OpenWithItem(true, false, true, 0, 0);
		ClosedWithItem closed_yes = new ClosedWithItem(false, false, true, 0, 0);
		Cooking cook = new Cooking(false, true, true, 0,0);
		
		System.out.println(closed_no.getPower());
		System.out.println(closed_no.getTimer());
		
		closed_no.power_inc();
		System.out.println(closed_no.getPower());

	}

}
