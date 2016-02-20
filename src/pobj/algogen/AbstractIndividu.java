package pobj.algogen;

/**
 * The parent class of all Individuals.
 * @author kuoa
 */

public abstract class AbstractIndividu {

	/** fitness value */
	
	protected double fitness = 0;

	/**
	 * Returns the fitness value.
	 * @return fitness
	 */
	
	public double getFitness() {
	
		return fitness;
	}
	
	/**
	 * Updates the fitness
	 * @param newFitness value
	 */
	
	public void setFitness(double newFitness) {
	
		fitness = newFitness;
	}	
	/**
	 * Compares two individuals based on their fitness.
	 * @param i the individual beeing compared to
	 * @return -1 | 0 | 1
	 */
	
	public int compareTo(IIndividu i) {

		return Double.compare(this.fitness, i.getFitness());
	}
	
	/**
	 * Returns the proper value.
	 * @return proper value
	 */
		
	public abstract Object getValeurPropre();		
	
	/**
	 * Mates two individuals based on their distinctive features.
	 * @param i the individual beeing mated with
	 * @return a new individual
	 */
	
	public abstract IIndividu croiser(IIndividu i);
	
	/**
	 * Produces a mutation on the individual	
	 */
	
	public abstract void muter();
	
	/**
	 * Clones the current individual.
	 * @return a new clonned individual
	 */
	
	public abstract IIndividu clone();

}