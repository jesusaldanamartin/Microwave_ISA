package states;

@SuppressWarnings("serial")
public class MicrowaveExceptions extends RuntimeException{

	public MicrowaveExceptions() {
		super();
	}
	
	public MicrowaveExceptions(String msg) {
		super(msg);
	}
}
