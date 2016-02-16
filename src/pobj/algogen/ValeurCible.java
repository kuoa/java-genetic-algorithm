package pobj.algogen;

import java.util.Random;

public class ValeurCible implements Environnement {

	private double value;

	/** Environment dependent value */

	/** @return ValeurCible with a random base value */
	public ValeurCible() {
		Random r = new Random();
		value = r.nextDouble();
	}

	/** @return ValeurCible with from a given @param value */
	public ValeurCible(double value) {
		this.value = value;
	}

	/** @return the current adaptation of the individual to the environment */
	@Override
	public double eval(Individu i) {

		double res = value - i.getValeurPropre();
		return 1 / (Math.pow(res, 2));

	}

	/** @return value */
	public double getValue() {
		return value;
	}

	/** @return a redefiniton of the toString method */
	public String toString() {
		return "Valeur cible: " + value;
	}

}
