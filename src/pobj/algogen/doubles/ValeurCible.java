package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;
import pobj.util.Generator;

public class ValeurCible implements Environnement<Double> {

	private double value;

	/** Environment dependent value */

	/** @return ValeurCible with a random base value */
	public ValeurCible() {
		Random r = Generator.getInstance();
		value = r.nextDouble();
	}

	/** @return ValeurCible with from a given @param value */
	public ValeurCible(double value) {
		this.value = value;
	}

	/** @return the current adaptation of the individual to the environment */
	@Override
	public double eval(IIndividu<Double> i) {

		double res = value - (double)i.getValeurPropre();
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
