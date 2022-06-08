package microondas;

// En composicion si se elimina la clase 'todo' tambien debe eliminarse la 'parte'
public class Microwave {

	private Boolean doorOpen, cooking, withItem;
	private Integer power, timer;
	
	private Heating heating;
	private Lamp lamp;
	private Turntable turntable;
	private Beeper beeper;
	private Display display;
	
	
	// Constructor que solo posee como enteros la potenia y el tiempo.
	public Microwave(int p, int t) {
		this.power = p;
		this.timer = t;
	}
	
	// Constructor completo que recibe como parametros en booleanos si la puerta esta abierta, si se esta cocinando
	// un alimento y si hay algun objeto dentro. Además se le pasa como enteros la potenia y el tiempo.
	public Microwave(boolean door, boolean cook, boolean item, int p, int t) {
		this.doorOpen = door;
		this.cooking = cook;
		this.withItem = item;
		this.power = p;
		this.timer = t;
	}

	// TBD
//	public void door_opened() {}
//	public void door_closed() {}
//	public void item_placed() {}
//	public void item_removed() {}
//	public void power_inc() {}
//	public void power_dec() {}
//	public void power_reset() {}
//	public void timer_inc() {}
//	public void timer_dec() {}
//	public void timer_reset() {}
//	public void cooking_start() {}
//	public void cooking_stop() {}
//	public void tick() {}
	
	public Boolean getDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(Boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public Boolean getCooking() {
		return cooking;
	}

	public void setCooking(Boolean cooking) {
		this.cooking = cooking;
	}

	public Boolean getWithItem() {
		return withItem;
	}

	public void setWithItem(Boolean withItem) {
		this.withItem = withItem;
	}

	public Integer getPower() {
		return power;
	}

	public void setPower(Integer power) {
		this.power = power;
	}

	public Integer getTimer() {
		return timer;
	}

	public void setTimer(Integer timer) {
		this.timer = timer;
	}
}
