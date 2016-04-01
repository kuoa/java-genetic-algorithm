package pobj.algogen;

import java.util.ArrayList;

/** This class implements a PopulationArray */

public class PopulationArray<T> {
		
	/** array containg the individuals */
	private ArrayList<IIndividu<T>> individus;

	/** Initialising the individuals array */

	public PopulationArray() {
		individus = new ArrayList<IIndividu<T>>();
	}

	/** @return current array size */

	public int size() {
		return individus.size();
	}

	/**
	 * Add a individual to the current population if the array is full, raise
	 * ArrayIndexOutOfBoundsException
	 * 
	 * @param individu
	 */

	public void add(IIndividu<T> individu) {
		individus.add(individu);
	}

	/** @return a string representation of the individuals */

	@Override
	public String toString() {
		String s = "";
		
		for(IIndividu<T> i : individus){
			s += i.toString() + "\n";
		}
		
		return s;
	}
}
