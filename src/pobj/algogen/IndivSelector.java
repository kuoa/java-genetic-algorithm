package pobj.algogen;

public interface IndivSelector<T> {	
	
	public IIndividu<T> getRandom(Population<T> pop);
}
