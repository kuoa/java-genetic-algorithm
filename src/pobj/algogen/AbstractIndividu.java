package pobj.algogen;

public abstract class AbstractIndividu<T> {

	/** value associated with his proper value */
	protected T valeurPropre;
	
	/** value associated with his fitness */
	protected double fitness = 0;
	
	protected AbstractIndividu(T valeurPropre){
		this.valeurPropre = valeurPropre;
	}

	public double getFitness() {
	
		return fitness;
	}

	public void setFitness(double newFitness) {
	
		fitness = newFitness;
	}	
	
	public T getValeurPropre(){
		return valeurPropre;
	}	
	
	public abstract int compareTo(IIndividu<T> i);
					
	public abstract IIndividu<T> croiser(IIndividu<T> i);
	
	public abstract void muter();
	
	public abstract IIndividu<T> clone();
	
	public void setValeurPropre(T valeurPropre){
		this.valeurPropre = valeurPropre;
	}

}