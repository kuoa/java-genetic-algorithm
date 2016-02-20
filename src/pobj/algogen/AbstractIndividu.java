package pobj.algogen;

public abstract class AbstractIndividu {

	/** value associated with his fitness */
	protected double fitness = 0;

	public double getFitness() {
	
		return fitness;
	}

	public void setFitness(double newFitness) {
	
		fitness = newFitness;
	}	
	
	public int compareTo(IIndividu i) {

		return Double.compare(this.fitness, i.getFitness());
	}
	
	public abstract Object getValeurPropre();		
					
	public abstract IIndividu croiser(IIndividu i);
	
	public abstract void muter();
	
	public abstract IIndividu clone();

}