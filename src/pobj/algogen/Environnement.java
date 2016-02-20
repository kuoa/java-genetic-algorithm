package pobj.algogen;

/** 
 * A interface that simulates the environment of the current population
 * @author kuoa
 */

public interface Environnement {
	
	/**
	 * Evaluates the individual on the current environment.
	 * @param i the individual being evaluated
	 * @return the new fitness value
	 */
	
	public double eval (IIndividu i);

}
