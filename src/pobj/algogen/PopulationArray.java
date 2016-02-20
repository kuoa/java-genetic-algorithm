package pobj.algogen;

import java.util.Arrays;

/** 
 * This class implements a PopulationArray 
 * @author kuoa
 */

public class PopulationArray {

	/** maximum array size */
	private static final int POP_SIZE = 20;

	/** array containg the individuals */
	private IIndividu[] individus;

	/** actual number of individuals */
	private int size = 0;

	/** Initializing the individuals array */

	public PopulationArray() {
		individus = new IIndividu[POP_SIZE];
	}

	/**
	 * Returns the population size.
	 * @return the population size.
	 */

	public int size() {
		return size;
	}

	/**
	 * Add a individual to the current population.
	 * If the array is full, raise ArrayIndexOutOfBoundsException.
	 * 
	 * @param individu, new individual
	 */

	public void add(IIndividu individu) {
		if (size < individus.length) {
			individus[size] = individu;
			size++;
		} else {
			throw new ArrayIndexOutOfBoundsException("Plus de place !");
		}
	}

	/**
	 * Returns a string representation of the individuals (IndividuDouble)
	 * @return a string representation 
	 */	

	@Override
	public String toString() {
		return Arrays.toString(individus);
	}
}
