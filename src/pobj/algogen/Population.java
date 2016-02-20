package pobj.algogen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pobj.algogen.arith.IndividuExpression;
import pobj.arith.EnvVal;

/**
 * The population container.
 * @author kuoa
 *
 */

public class Population {

	/** arrayList containig the individuals */	
	private ArrayList<IIndividu> individus;

	/** array size */
	private int size = 0;

	/** Initializing the individuals arrayList */
	public Population() {
		individus = new ArrayList<IIndividu>();
	}

	/**
	 * Returns the population size.
	 * @return the population size.
	 */
	public int size() {
		return size;
	}

	/**
	 * Adds a new individual to the current population.
	 * @param individual
	 */

	void add(IIndividu individu) {

		individus.add(individu);
		++size;
	}

	/**
	 * Returns a string representation of the individuals (IndividuDouble)
	 * @return a string representation 
	 */
	
	@Override
	public String toString() {

		String s = "";

		for (IIndividu i : individus) {
			s += i.toString() + "\n";
		}

		return s;
	}
	/**
	 * Returns a string representation of the individuals (IndividuExpression) 
	 * @param e the array of expression variables
	 * @return a string representation 	 
	 */
	
	public String toString(EnvVal e) {

		String s = "";

		for (IIndividu i : individus) {
			
			IndividuExpression ie = (IndividuExpression) i;
			s += ie.toString(e) + "\n";
		}
		return s;
	}

	/**
	 * Simulates the evolution of the current population, by creating a new
	 * generation. We use a environment that allows the calculation
	 * of the new fitness (survival of the fittest). 
	 * We keep the %20 of the most apt individuals and we allow them to reproduce 
	 * in order to create the next generation. 
	 * Mutations may also occur.
	 *
	 * @param e the evaluation environment
	 * @return a new population
	 */

	public Population evoluer(Environnement e) {

		Random r = new Random();
		int min = 5;
		int max = 15;

		double prob = (r.nextInt(max - min + 1) + min) / 100.0;
	
		System.out.println("Probabilty of mutation: " + prob + " %");

		evaluer(e);

		Population newPop = reproduire();

		newPop.muter(prob);

		newPop.evaluer(e); // In order to keep it sorted

		return newPop;
	}

	/**
	 * Updates the fitness of all the individuals present in the current
	 * environment. 
	 * @param e the evaluation environment
	 */

	public void evaluer(Environnement e) {

		for (IIndividu i : individus) {

			double newFitness = e.eval(i);
			i.setFitness(newFitness);
		}

		Collections.sort(individus, Collections.reverseOrder());

	}

	/**
	 * Creates a new mutation of the current individual, based on the probability of mutation. 
	 * @param probability of mutation
	 */

	private void muter(double probability) {

		Random r = new Random();

		for (int i = 1; i < individus.size(); i++) {

			double rand = r.nextDouble();

			// System.out.println("Mutation random: " + rand + "prob: " +
			// probabilite);

			if (rand <= probability) {

				IIndividu ind = individus.get(i);
				ind.muter();

				// System.out.println("Mutation done");

			} else {
				// System.out.println("Mutation not done");
			}
		}
	}

	/**
	 * Creates a new population by simulating a reproduction behavior. We keep
	 * the %20 of the most apt individuals and we allow them to reproduce in
	 * order to create the next generation. 
	 * @return the next generation after reproduction
	 */

	private Population reproduire() {

		Population newPop = new Population();
		Random r = new Random();

		int size = individus.size();
		int cloneSize = (int) (size * 0.2);
		int reprodSize = size - cloneSize;

		// less than 5 individuals
		if (cloneSize < 1) {
			cloneSize = 1;
		}

		for (int i = 0; i < cloneSize; i++) {

			IIndividu individu = individus.get(i);
			newPop.add(individu.clone());

			// System.out.println("New individual by clone: " +
			// individu.toString());

		}

		for (int i = 0; i < reprodSize; i++) {

			IIndividu mother = individus.get(i);

			int fatherIndex = r.nextInt(cloneSize);

			IIndividu father = individus.get(fatherIndex);
			IIndividu newIndividu = father.croiser(mother);

			newPop.add(newIndividu);

			// System.out.println("New individual by reproduction: " +
			// newIndividu.toString());
		}

		return newPop;
	}
}
