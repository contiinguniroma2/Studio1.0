package logic.pattern;

public abstract class AbstractState {
	protected String state;

	public abstract void goNext(StateMachine stateMachine);

	public String getState() {
		return state;
	}

}