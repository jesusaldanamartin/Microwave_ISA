import states.*;
import microondas.*;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;


public class Test_microwave {
	
	private Microwave mw;
	
	@BeforeEach
	public void Microwave() {
		@SuppressWarnings("unused")
		Microwave mw = new ClosedWithNoItem(0,0); // Creo un objeto microondas con el estado inicial.
	}
	
	@Test
	public void testPowerInc() {
		mw.setPower(9);
		mw.power_inc();
		assertEquals(10, mw.getPower()); // Se añade +1 a la potencia correctamente					
		assertThrows(MicrowaveExceptions.class, ()-> mw.power_inc()); // Límite de potencia en 10
	}
	
	@Test
	public void testPowerDec() {
		mw.setPower(1);
		mw.power_dec();
		assertEquals(0, mw.getPower()); // Se resta -1 a la potencia correctamente	
		mw.power_reset(); // Cambio la potencia a 0
		assertThrows(MicrowaveExceptions.class, ()-> mw.power_dec()); // No se puede reducir más de 0
	}
	
	@Test
	public void testTimer() {
		mw.setTimer(120);
		mw.timer_inc();
		assertEquals(125, mw.getTimer()); // Se añade +5 segundos al timer correctamente					
		mw.timer_dec();
		mw.timer_dec();
		assertEquals(115, mw.getTimer()); // Se restan -10 segundos al timer correctamente	
		mw.timer_reset();
		assertThrows(MicrowaveExceptions.class, ()-> mw.timer_dec()); // No se puede reducir más de 0 el tiempo
	}
	
	@Test
	public void testPowerTimer() {
		Microwave mw2 = new Cooking(0,0); // Test de Power y Timer en otro estado diferente
		//Power
		mw.setPower(9);
		mw.power_inc();
		assertEquals(10, mw.getPower()); // Se añade +1 a la potencia correctamente					
		assertThrows(MicrowaveExceptions.class, ()-> mw.power_inc()); // Límite de potencia en 10
		//Timer
		mw2.setTimer(90);
		mw2.timer_inc();
		assertEquals(95, mw2.getTimer()); // Se añade +5 segundos al timer correctamente					
		mw2.timer_dec();
		mw2.timer_dec();
		assertEquals(85, mw2.getTimer()); // Se restan -10 segundos al timer correctamente	
		mw2.timer_reset();
		assertThrows(MicrowaveExceptions.class, ()-> mw2.timer_dec()); // No se puede reducir más de 0 el tiempo
	}
	
	@Test
	public void estadoClosedWithNoItem() {
		
		assertThrows(MicrowaveExceptions.class, ()-> mw.door_closed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw.item_removed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw.item_placed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw.cooking_start()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw.cooking_stop()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw.tick()); 
		assertFalse(mw.getHeating());
		assertFalse(mw.getLamp());
		assertFalse(mw.getTurntable());
	}
	
	@Test
	public void estadoOpenWithNoItem() {
		
		Microwave mw2 = new OpenWithNoItem(0,0); 		
		assertThrows(MicrowaveExceptions.class, ()-> mw2.door_opened()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw2.item_removed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw2.cooking_start()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw2.cooking_stop()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw2.tick()); 
		assertFalse(mw2.getHeating());
		assertTrue(mw2.getLamp());
		assertFalse(mw2.getTurntable());
	}
	
	@Test
	public void estadoOpenWithItem() {
		
		Microwave mw3 = new OpenWithItem(0,0); 		
		assertThrows(MicrowaveExceptions.class, ()-> mw3.door_opened()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw3.item_placed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw3.cooking_start()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw3.cooking_stop()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw3.tick()); 
		assertFalse(mw3.getHeating());
		assertTrue(mw3.getLamp());
		assertFalse(mw3.getTurntable());
	}
	
	@Test
	public void estadoClosedWithItem() {
		
		Microwave mw4 = new ClosedWithItem(0,0); 		
		assertThrows(MicrowaveExceptions.class, ()-> mw4.door_closed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw4.item_removed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw4.item_placed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw4.cooking_stop()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw4.tick()); 
		assertFalse(mw4.getHeating());
		assertFalse(mw4.getLamp());
		assertFalse(mw4.getTurntable());
	}
	
	@Test
	public void estadoCooking() {
		
		Microwave mw5 = new Cooking(0,0); 		
		assertThrows(MicrowaveExceptions.class, ()-> mw5.door_closed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw5.item_removed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw5.item_placed()); 
		assertThrows(MicrowaveExceptions.class, ()-> mw5.cooking_start()); 
		assertTrue(mw5.getHeating());
		assertTrue(mw5.getLamp());
		assertTrue(mw5.getTurntable());
	}
	
	public void interrupcionCooking() {
		Microwave mw6 = new Cooking(7,60); 		
		mw6.cooking_start(); // Comienzo a cocinar con potencia 7 y timer 60s
		assertTrue(mw6.getHeating()); // Compruebo que se esta calentando la comida
		for(int i = 0; i < 30; i++) {
			mw6.tick(); // Realizo 30 ticks, lo que equivale a 30 segundos de timer
		}
		mw6.setDoorOpen(true); // Compruebo cada parte del microondas al abrirse
		assertTrue(mw6.getDoorOpen());
		assertTrue(mw6.getLamp());
		assertFalse(mw6.getHeating());
		assertFalse(mw6.getTurntable());
		assertEquals(30,mw6.getTimer()); // Pese a interrumpirse la coccion se mantiene el tiempo.
	}
}