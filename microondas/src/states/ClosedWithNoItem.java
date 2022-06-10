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
	@Override
	public Microwave door_closed() { throw new MicrowaveExceptions("La puerta ya está cerrada"); }
	public Microwave item_placed() { throw new MicrowaveExceptions("La puerta se encuentra cerrada"); }
	public Microwave item_removed() { throw new MicrowaveExceptions("La puerta se encuentra cerrada"); }

	@Override
	public void power_inc() {
		if(getPower() <= 10) {
			int inc = getPower() + 1;
			setPower(inc);
			display.setDisplay("Potencia aumentada:" + inc);	
		}else {
			display.setDisplay("Potencia Máxima: 10");	
			throw new MicrowaveExceptions("Potencia máxima alcanzada");
		}		
	}

	@Override
	public void power_dec() {
		int p = getPower();
		if(p != 0) {
			int dec = getPower() - 1;
			setPower(dec);
			display.setDisplay("Potencia reducida:" + dec);		
		}else {
			display.setDisplay("Potencia reducida al mínimo:" + getPower());	
			throw new MicrowaveExceptions("Potencia mínima alcanzada");

		}
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
		int t = getTimer();
		if(t != 0) {
			int dec = getTimer() - 5;
			setTimer(dec);
			display.setDisplay("Tiempo reducido:" + dec);	
		}else {
			throw new MicrowaveExceptions("No se puede reducir más el tiempo de coccion");	
		}
	}

	@Override
	public void timer_reset() {
		int reset = 0;
		setTimer(reset);
		display.setDisplay("Tiempo reseteado:" + reset);		
	}

	// El estado ClosedWithNoItem es el inicial por lo que no hay nada cocinandose.
	public void cooking_start() { throw new MicrowaveExceptions("Estado Inicial"); };
	public void cooking_stop(){ throw new MicrowaveExceptions("Estado Inicial"); };
	public void tick(){ throw new MicrowaveExceptions("Estado Inicial"); };


	

}
