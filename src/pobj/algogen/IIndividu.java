package pobj.algogen;


public interface IIndividu <T> extends Comparable<IIndividu<T>> {

	/** Redefinition of toString() */
	public String toString();

	/** Access the value associated with the individual @return valeurPropre */
	public T getValeurPropre();

	/** @return the fitness value */
	public double getFitness();

	/** Set a @param newFitness value */
	public void setFitness(double newFitness);

	/**
	 * Compares the fitness of the current individual with individual @param i, @return
	 * -1 | 0 | 1
	 */
	public int compareTo(IIndividu<T> i);

	/**
	 * @return a new individual with common traits of the current individual and @param
	 *         i
	 */
	public IIndividu<T> croiser(IIndividu<T> i);

	/** Mutates the current individual */
	public void muter();

	/** @return a clone of the current individual */
	public IIndividu<T> clone();

}