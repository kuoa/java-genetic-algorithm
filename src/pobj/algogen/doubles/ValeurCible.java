package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;

public class ValeurCible implements Environnement {

	/** target value */
	private double value;
	
	/**
	 * Create a new evaluation environment.
	 */
	
	public ValeurCible() {
		Random r = new Random();
		value = r.nextDouble();
	}

	/**
	 * Create a new evaluation environment.
	 * @param value the target value
	 */
	public ValeurCible(double value) {
		this.value = value;
	}

	/**
	 * Evaluates the individual on the current environment.
	 * @param i the individual being evaluated
	 * @return the new fitness value
	 */
	
	@Override
	public double eval(IIndividu i) {

		double res = value - (double)i.getValeurPropre();
		return 1 / (Math.pow(res, 2));

	}

	/**
	 * Returns the target value.
	 * @return target value
	 */
	public double getValue() {
		return value;
	}

	/**
	 * Redefinition of toString().
	 * @return a string representation
	 */
	public String toString() {
		return "[** Target Value : " + value + " **]\n";
	}

}
