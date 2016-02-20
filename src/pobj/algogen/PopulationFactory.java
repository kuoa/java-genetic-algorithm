package pobj.algogen;

import pobj.algogen.arith.IndividuExpression;
import pobj.algogen.doubles.IndividuDouble;

/**
 * A factory of populations.
 * @author kuoa
 *
 */

public class PopulationFactory {

	/**
	 * Creates a PopulationArray containing individuals.
	 * @param size the population size
	 * @return a new PopulationArray
	 */

	public static PopulationArray createRandomPopulationArray(int size) {

		PopulationArray population = new PopulationArray();

		for (int i = 0; i < size; i++) {

			population.add(new IndividuDouble());
		}

		return population;
	}

	/**
	 * Creates a Population containing (IndividuDouble) individuals.
	 * @param size the population size
	 * @return a new Population
	 */

	public static Population randomPopulationIDouble(int size) {

		Population population = new Population();

		for (int i = 0; i < size; i++) {
			population.add(new IndividuDouble());
		}

		return population;
	}
	
	/**
	 * Creates a Population containing (IndividuExpression) individuals.
	 * @param size the population size
	 * @return a new Population
	 */

	public static Population randomPopulationIExpression(int size) {

		Population population = new Population();

		for (int i = 0; i < size; i++) {
			population.add(new IndividuExpression());
		}
		
		return population;
	}
}
