package pobj.algogen;

import java.util.Random;

/**
 * Class representing an individual
 */

public class Individu implements Comparable<Individu> {

	/** value associated with a individual */
	private double valeurPropre;

	/** value associated with his fitness */
	private double fitness = 0;

	/** Make a individual associated with a random value */
	public Individu() {

		Random r = new Random();
		valeurPropre = r.nextDouble();
	}

	/** Make a individual associated with a given value @param valeurPropre */
	public Individu(double valeurPropre) {

		this.valeurPropre = valeurPropre;
	}

	/** Redefinition of toString() */
	public String toString() {

		return "\nIndividu: " + valeurPropre + " fitness: " + fitness;
	}

	/** Access the value associated with the individual @return valeurPropre */
	public double getValeurPropre() {

		return valeurPropre;
	}

	/** Set a @param newValue associated with the individual */
	public void setValeurPropre(double newValue) {

		valeurPropre = newValue;
	}

	/** @return the fitness value */
	public double getFitness() {

		return fitness;
	}

	/** Set a @param newFitness value */
	public void setFitness(double newFitness) {

		fitness = newFitness;
	}

	/**
	 * Compares the fitness of the current individual with individual @param i, @return
	 * -1 | 0 | 1
	 */
	@Override
	public int compareTo(Individu i) {

		return Double.compare(this.fitness, i.getFitness());
	}

	/**
	 * @return a new individual with common traits of the current individual and @param
	 *         i
	 */
	public Individu croiser(Individu i) {

		double newValeurPropre = (valeurPropre + i.getValeurPropre()) / 2.1;
		return new Individu(newValeurPropre);

	}

	/** Mutates the current individual */
	public void muter() {

		Random r = new Random();
		fitness = r.nextDouble();
		System.out.println("new fitness: " + fitness);

	}

	/** @return a clone of the current individual */
	public Individu clone() {

		Individu newIndividu = new Individu(valeurPropre);
		newIndividu.setFitness(fitness);

		return newIndividu;
	}

}
