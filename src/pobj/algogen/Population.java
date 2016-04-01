package pobj.algogen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pobj.algogen.arith.IndividuExpression;
import pobj.arith.EnvVal;

public class Population<T> {

	/** arrayList containg the individuals */
	private ArrayList<IIndividu<T>> individus;

	/** array size */
	private int size = 0;

	/** Initializing the individuals arrayList */

	public Population() {
		individus = new ArrayList<IIndividu<T>>();
	}

	/** @return ArrayList size */
	public int size() {
		return size;
	}
	
	public IIndividu<T> get (int i){
		return individus.get(i);
	}

	/**
	 * Add a @param individu to the current population
	 */

	void add(IIndividu<T> individu) {

		individus.add(individu);
		++size;
	}

	/** @return a string representation of the individuals */
	@Override
	public String toString() {

		String s = "";

		for (IIndividu<T> i : individus) {
			s += i.toString() + "\n";
		}

		return s;
	}
	
	public String toString(EnvVal e) {

		String s = "";

		for (IIndividu<T> i : individus) {
						
			IndividuExpression ie = (IndividuExpression) i;
			s += ie.toString(e) + "\n";
		}

		return s;
	}
	

	/**
	 * Simulates the evolution of the current population, by creating a new @return
	 * generation. We use a environnement @param e that allows the calculation
	 * of the new fitness (survival of the fittest). We keep the %20 of the most
	 * apt individuals and we allow them to reproduce in order to create the
	 * next generation. Random mutations may also occur.
	 */

	public Population<T> evoluer(Environnement<T> e) {

		Random r = new Random();
		int min = 5;
		int max = 15;

		double prob = (r.nextInt(max - min + 1) + min) / 100.0;
		System.out.println("Probabilty of mutation: " + prob + " %");

		evaluer(e);

		Population<T> newPop = reproduire();

		newPop.muter(prob);

		newPop.evaluer(e); // In order to keep it sorted

		return newPop;
	}

	/**
	 * Updates the fitness of all the individuals present in the current
	 * environment @param e
	 */

	public void evaluer(Environnement<T> e) {

		for (IIndividu<T> i : individus) {

			double newFitness = e.eval(i);
			i.setFitness(newFitness);
		}

		Collections.sort(individus, Collections.reverseOrder());

	}

	/**
	 * Creates a new mutation of the current individual, based on a @param
	 * probability
	 */

	private void muter(double probability) {

		Random r = new Random();

		for (int i = 1; i < individus.size(); i++) {

			double rand = r.nextDouble();

			// System.out.println("Mutation random: " + rand + "prob: " +
			// probabilite);

			if (rand <= probability) {

				IIndividu<T> ind = individus.get(i);
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
	 * order to create the @return next generation.
	 */

	private Population<T> reproduire() {

		Population<T> newPop = new Population<T>();
		Random r = new Random();

		int size = individus.size();
		int cloneSize = (int) (size * 0.2);
		int reprodSize = size - cloneSize;

		// less than 5 individuals
		if (cloneSize < 1) {
			cloneSize = 1;
		}

		for (int i = 0; i < cloneSize; i++) {

			IIndividu<T> individu = individus.get(i);
			newPop.add(individu.clone());

			// System.out.println("New individual by clone: " +
			// individu.toString());

		}

		for (int i = 0; i < reprodSize; i++) {

			IIndividu<T> mother = individus.get(i);

			int fatherIndex = r.nextInt(cloneSize);

			IIndividu<T> father = individus.get(fatherIndex);
			IIndividu<T> newIndividu = father.croiser(mother);

			newPop.add(newIndividu);

			// System.out.println("New individual by reproduction: " +
			// newIndividu.toString());
		}

		return newPop;
	}
}
