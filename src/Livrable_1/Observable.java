package Livrable_1;

public interface Observable {
	
	public void addObserver(Observer o);
	
	public void notifyObservers(Object arg);

}
