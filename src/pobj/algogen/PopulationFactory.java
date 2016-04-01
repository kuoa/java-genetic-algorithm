package pobj.algogen;

import agent.control.IControleur;
import pobj.algogen.agent.IndividuControler;
import pobj.algogen.arith.IndividuExpression;
import pobj.algogen.doubles.IndividuDouble;
import pobj.arith.Expression;

public class PopulationFactory {

	/**
	 * Creates a @return PopulationArray containing individuals in an array of @param
	 * size
	 */

	public static Population<Double> createRandomPopulationArray(int size) {

		Population<Double> population = new Population<Double>();

		for (int i = 0; i < size; i++) {

			population.add(new IndividuDouble());
		}

		return population;
	}

	/**
	 * Creates a @return Population containing individuals in an arrayList of @param
	 * size
	 */

	public static Population<Expression> createRandomExpressionPopulation(int size) {

		Population<Expression> population = new Population<Expression>();

		for (int i = 0; i < size; i++) {
			population.add(new IndividuExpression());
		}

		return population;
	}
	
	public static Population<IControleur> createRandomControllerPopulation(int size, int nbRules) {

		Population<IControleur> population = new Population<IControleur>();

		for (int i = 0; i < size; i++) {
			population.add(new IndividuControler(nbRules));
		}

		return population;
	}
	
	
}
