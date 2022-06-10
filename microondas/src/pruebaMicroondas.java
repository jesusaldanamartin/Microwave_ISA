import microondas.*;
import states.*;

public class pruebaMicroondas {

	public static void main(String[] args) {
		
		ClosedWithNoItem cn = new ClosedWithNoItem(false, false, false, 0, 0);
	
		System.out.println(cn.getPower());
		System.out.println(cn.getTimer());
		
	}

}
