package Observer;

public interface Subject {
	public void registerObserver(Oberver o);
	public void unRegisterObserver(Oberver o);
	public void notifyObserver();

}
