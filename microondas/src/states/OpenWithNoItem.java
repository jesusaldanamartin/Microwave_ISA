package states;

import microondas.Microwave;

public class OpenWithNoItem extends Microwave {

	public OpenWithNoItem(int p, int t) {
		super(p,t);
	}
	
	public OpenWithNoItem(boolean door, boolean cook, boolean item, int p, int t) {
		super(door, cook, item, p, t);
		heating.heating_off();
		lamp.lamp_on();
		turntable.turntable_stop();	
		setDoorOpen(door);
		setWithItem(item);
		setCooking(cook);
	}
	
	
	public Microwave door_opened() { return null; }

	// Regresamos al estado anterior
	public Microwave door_closed() {
		return new ClosedWithNoItem(getPower(), getTimer());
	}
	// Vamos al siguiente estado
	public Microwave item_placed() {
		return new OpenWithItem(getPower(), getTimer());
	}

	public Microwave item_removed() { return null; }

	@Override
	public void power_inc() {
		int inc = getPower() + 1;
		setPower(inc);
		display.setDisplay("Potencia aumentada:" + inc);		
	}

	@Override
	public void power_dec() {
		int dec = getPower() - 1;
		setPower(dec);
		display.setDisplay("Potencia reducida:" + dec);		
	}

	@Override
	public void power_reset() {
		int reset = 0;
		setPower(reset);
		display.setDisplay("Potencia reseteada:" + reset);			
	}

	@Override
	public void timer_inc() {
		int inc = getTimer() + 5;
		setTimer(inc);
		display.setDisplay("Tiempo aumentado:" + inc);	
		
	}

	@Override
	public void timer_dec() {
		int dec = getTimer() - 5;
		setTimer(dec);
		display.setDisplay("Tiempo reducido:" + dec);	
	}

	@Override
	public void timer_reset() {
		int reset = 0;
		setTimer(reset);
		display.setDisplay("Tiempo reseteado:" + reset);		
	}

	// En el estado OpenWithNoItem aún no hay nada cocinandose.
	public void cooking_start() {};
	public void cooking_stop(){};
	public void tick(){};


	

}
