package pobj.algogen;

import java.util.Arrays;

/** This class implements a PopulationArray */

public class PopulationArray {

	/** maximum array size */
	private static final int POP_SIZE = 20;

	/** array containg the individuals */
	private IIndividu[] individus;

	/** actual number of individuals */
	private int size = 0;

	/** Initialising the individuals array */

	public PopulationArray() {
		individus = new IIndividu[POP_SIZE];
	}

	/** @return current array size */

	public int size() {
		return size;
	}

	/**
	 * Add a individual to the current population if the array is full, raise
	 * ArrayIndexOutOfBoundsException
	 * 
	 * @param individu
	 */

	public void add(IIndividu individu) {
		if (size < individus.length) {
			individus[size] = individu;
			size++;
		} else {
			throw new ArrayIndexOutOfBoundsException("Plus de place !");
		}
	}

	/** @return a string representation of the individuals */

	@Override
	public String toString() {
		return Arrays.toString(individus);
	}
}
