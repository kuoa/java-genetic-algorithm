package pobj.algogen;

import pobj.algogen.arith.IndividuExpression;
import pobj.algogen.doubles.IndividuDouble;

public class PopulationFactory {

	/**
	 * Creates a @return PopulationArray containing individuals in an array of @param
	 * size
	 */

	public static PopulationArray createRandomPopulationArray(int size) {

		PopulationArray population = new PopulationArray();

		for (int i = 0; i < size; i++) {

			population.add(new IndividuDouble());
		}

		return population;
	}

	/**
	 * Creates a @return Population containing individuals in an arrayList of @param
	 * size
	 */

	public static Population createRandomPopulation(int size) {

		Population population = new Population();

		for (int i = 0; i < size; i++) {
			population.add(new IndividuExpression());
		}

		return population;
	}
}