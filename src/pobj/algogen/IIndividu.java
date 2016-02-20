package pobj.algogen;

/**
 * A common interface for all individuals.
 * 
 * @author kuoa
 *
 */

public interface IIndividu extends Comparable<IIndividu> {

	/**
	 * Redefinition of toString().
	 * @return a string representation
	 */

	public String toString();

	/**
	 * Returns the proper value.
	 * @return a Object (Expression or Double)
	 */

	public Object getValeurPropre();

	/**
	 * Returns the fitness value.
	 * @return fitness
	 */

	public double getFitness();
	
	/**
	 * Updates the fitness
	 * @param newFitness value
	 */
	
	public void setFitness(double newFitness);

	/**
	 * Compares two individuals based on their fitness.
	 * @param i the individual beeing compared to
	 * @return -1 | 0 | 1
	 */
	
	public int compareTo(IIndividu i);	
		
	/**
	 * Mates two individuals based on their distinctive features.
	 * @param i the individual beeing mated with
	 * @return a new individual
	 */
	
	public IIndividu croiser(IIndividu i);
	
	/**
	 * Produces a mutation on the individual
	 */

	public void muter();

	/** @return a clone of the current individual */
	public IIndividu clone();

}