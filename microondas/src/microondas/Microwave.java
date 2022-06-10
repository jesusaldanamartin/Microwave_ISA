package microondas;

// En composicion si se elimina la clase 'todo' tambien debe eliminarse la 'parte'
public abstract class Microwave {

	private Boolean doorOpen, cooking, withItem;
	private Integer power, timer;
	
	protected Heating heating = new Heating();
	protected Lamp lamp = new Lamp();
	protected Turntable turntable = new Turntable();
	protected Beeper beeper = new Beeper();
	protected Display display = new Display();
	
	
	// Constructor que solo posee como enteros la potencia y el tiempo.
	public Microwave(int p, int t) {
		this.power = p;
		this.timer = t;
	}
	
	// Constructor completo, llamo a los setters de cada variable y los adapto a lo que recibo como parametros.
	public Microwave(boolean door, boolean cook, boolean item, int p, int t) {
		this.setDoorOpen(door);
		this.cooking = cook;
		this.setWithItem(item);
		this.setPower(p);
		this.setTimer(t);
	}

	// Metodos abstractos del microondas al que
	// accedera cada estado
	public abstract Microwave door_opened();
	public abstract Microwave door_closed();
	public abstract Microwave item_placed();
	public abstract Microwave item_removed();
	public abstract void power_inc();
	public abstract void power_dec();
	public abstract void power_reset();
	public abstract void timer_inc();
	public abstract void timer_dec();
	public abstract void timer_reset();
	public abstract void cooking_start();
	public abstract void cooking_stop();
	public abstract void tick();
	
	// Metodos
	public Boolean getDoorOpen() {
		return doorOpen;
	}

	public void setDoorOpen(boolean doorOpen) {
		this.doorOpen = doorOpen;
	}

	public Boolean getCooking() {
		return cooking;
	}

	public void setCooking(boolean cooking) {
		this.cooking = cooking;
	}

	public Boolean getWithItem() {
		return withItem;
	}

	public void setWithItem(boolean withItem) {
		this.withItem = withItem;
	}

	public int getPower() {
		return power;
	}
	
	public void setPower(int power) {
		 this.power = power;
	}

	public int getTimer() {
		return timer;
	}
	
	public void setTimer(int timer) {
		this.timer = timer;
	}
}
