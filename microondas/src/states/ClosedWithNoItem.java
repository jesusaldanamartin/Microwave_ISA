package states;

import microondas.Microwave;

public class ClosedWithNoItem extends Microwave {

	public ClosedWithNoItem(int p, int t) {
		super(p,t);
	}
	
	public ClosedWithNoItem(boolean door, boolean cook, boolean item, int p, int t) {
		super(door, cook, item, p, t);
		lamp.lamp_off();
		turntable.turntable_stop();
		heating.heating_off();
		setDoorOpen(door);
		setWithItem(item);
		setCooking(cook);
	}

	@Override
	public Microwave door_opened() {
		// TODO Auto-generated method stub
		return new OpenWithItem(getPower(), getTimer());	
	}

	// El estado ClosedWithNoItem es el inicial por lo que al estar la puerta cerrada
	// no habría que implementarlos.
	public Microwave door_closed() { return null; }
	public Microwave item_placed() { return null; }
	public Microwave item_removed() { return null;}

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

	// El estado ClosedWithNoItem es el inicial por lo que no hay nada cocinandose.
	public void cooking_start() {};
	public void cooking_stop(){};
	public void tick(){};


	

}
