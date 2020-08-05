package logic.pattern;

public abstract class AbstractState {
	protected String state;

	public abstract void goNext(StateMachine stateMachine);
	
	public abstract void notifyStudent();

	public String getState() {
		return state;
	}

}