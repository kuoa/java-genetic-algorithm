package pobj.obs;

import java.util.ArrayList;

public class SimpleObservable implements ISimpleObservable  {
	
	private ArrayList<ISimpleObserver> observers;

	public SimpleObservable() {
		observers = new ArrayList<ISimpleObserver>();
	}

	@Override
	public void addObserver(ISimpleObserver observer) {		
		observers.add(observer);		
	}

	@Override
	public void deleteObserver(ISimpleObserver observer) {
		observers.remove(observer);		
	}
	
	public void notifyObservers(){
		
		if(observers.isEmpty()){
			//System.out.println("Empty obs");
		}
		
		for (ISimpleObserver o : observers){
			o.update();
			System.out.println("observers notified");
		}
	}
	
	public ArrayList<ISimpleObserver> getList(){
		return observers;
	}
}
