package States;
import microondas.*;

// This method defines an interface for encapsulating the behavior associated with a 
// particular state of the Context

public abstract class State {
	
	protected Microwave mw;
	
	// Al constructor le paso un microondas
	public State(Microwave microondas) {
		this.mw = microondas;
	}
	
	// Defino todos los estados diferentes con los que el usuario puede toparse
	public abstract void ClosedWithNoItem();
	public abstract void OpenWithNoItem();
	public abstract void OpenWithItem();
	public abstract void ClsoedWithItem();
	public abstract void Cooking();


}
