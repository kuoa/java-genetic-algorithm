package pobj.algogen;

public interface IIndividu extends Comparable<IIndividu> {

	/** Redefinition of toString() */
	public String toString();

	/** Access the value associated with the individual @return valeurPropre */
	public Object getValeurPropre();

	/** @return the fitness value */
	public double getFitness();

	/** Set a @param newFitness value */
	public void setFitness(double newFitness);

	/**
	 * Compares the fitness of the current individual with individual @param i, @return
	 * -1 | 0 | 1
	 */
	public int compareTo(IIndividu i);

	/**
	 * @return a new individual with common traits of the current individual and @param
	 *         i
	 */
	public IIndividu croiser(IIndividu i);

	/** Mutates the current individual */
	public void muter();

	/** @return a clone of the current individual */
	public IIndividu clone();

}