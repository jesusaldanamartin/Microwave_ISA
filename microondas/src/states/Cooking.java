package states;

import microondas.Microwave;

public class Cooking extends Microwave {

	public Cooking(int p, int t) {
		super(p,t);
	}

	public Cooking(boolean door, boolean cook, boolean item, int p, int t) {
		super(door, cook, item, p, t);
		setDoorOpen(door);
		setWithItem(item);
		lamp.lamp_on();
		heating.heating_on();
		turntable.turntable_start();
		setCooking(cook);
	}

	@Override
	public Microwave door_opened() {
		return new OpenWithItem(getPower(), getTimer());
	}

	@Override
	public Microwave door_closed() { return null; }
	public Microwave item_placed() { return null; }
	public Microwave item_removed() { return null; }

	@Override
	public void power_inc() {
		if(getPower() <= 10) {
			int inc = getPower() + 1;
			setPower(inc);
			display.setDisplay("Potencia aumentada:" + inc);	
		}else {
			display.setDisplay("Potencia M�xima: 10");	
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
			new ClosedWithItem(getPower(), getTimer());
		}
	}

	@Override
	public void power_reset() {
		int reset = 0;
		setPower(reset);
		display.setDisplay("Proceso interrumpido");
		new ClosedWithItem(getPower(), getTimer());
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
		}
	}

	@Override
	public void timer_reset() {
		int reset = 0;
		setTimer(reset);
		display.setDisplay("Proceso interrumpido");
		new ClosedWithItem(getPower(), getTimer());	
	}

	@Override
	public void cooking_start() {};

	@Override
	public void cooking_stop() {
		new ClosedWithItem(getPower(), getTimer());
	}

	@Override
	public void tick() {
		int tRestante = getTimer()-1;
		boolean dOpen = getDoorOpen();
		setPower(tRestante);
		display.setDisplay(tRestante + "");
		if(tRestante == 0) {
			heating.heating_off();
			beeper.beep(3);
			turntable.turntable_stop();
			lamp.lamp_on();
			display.setDisplay("La comida est� lista");
		}else if(dOpen == true) {
			heating.heating_off();
			beeper.beep(3);
			turntable.turntable_stop();
			lamp.lamp_on();
			display.setDisplay("Quedan" + tRestante + "segundos");
		}
		}

}
