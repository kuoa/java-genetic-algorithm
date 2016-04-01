package pobj.obs;

public interface ISimpleObservable {
	
	public void addObserver(ISimpleObserver observer);
	
	public void deleteObserver(ISimpleObserver observer);

}
