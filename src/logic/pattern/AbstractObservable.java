package logic.pattern;

import java.util.List;

public abstract class AbstractObservable {
	protected List<Observer> observers;
	
	public void attachObserver(Observer observer) {
		this.observers.add(observer);
	}
	
	public void detachObserver(Observer observer) {
		this.observers.remove(observer);
	}
	
	public abstract void notifyObservers();
}