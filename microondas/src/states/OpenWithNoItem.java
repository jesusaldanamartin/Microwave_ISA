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
	
	
	public Microwave door_opened() { throw new MicrowaveExceptions("La puerta ya está abierta"); }

	// Regresamos al estado anterior
	public Microwave door_closed() {
		return new ClosedWithNoItem(getPower(), getTimer());
	}
	// Vamos al siguiente estado
	public Microwave item_placed() {
		return new OpenWithItem(getPower(), getTimer());
	}

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

	// En el estado OpenWithNoItem aún no hay nada cocinandose.
	public void cooking_start() { throw new MicrowaveExceptions("!!Puerta abierta y no hay objeto¡¡"); };
	public void cooking_stop(){ throw new MicrowaveExceptions("!!Puerta abierta y no hay objeto¡¡"); };
	public void tick(){ throw new MicrowaveExceptions("!!Puerta abierta y no hay objeto¡¡"); };


	

}
