package pobj.algogen;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import pobj.algogen.arith.IndividuExpression;
import pobj.arith.EnvVal;
import pobj.util.Generator;

public class Population<T> {

	/** arrayList containg the individuals */
	private ArrayList<IIndividu<T>> individus;

	/** array size */
	private int size = 0;
	
	private IEvolution<T> strategy = null;

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

		evaluer(e);

		Population<T> newPop = reproduire();
	
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

	public void muter(double probability) {

		Random r = Generator.getInstance();

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
		
		if(this.strategy == null){			
			this.strategy = new GenerationalEvolution<>();		
			
			System.out.println(this.strategy);
			
			System.out.println("No strategy provided, selecting [GenerationalEvolution] by default");
			
		}
		
		return strategy.reproduire(this);

	}
	
	public double getFitnessSum(){
		double sum = 0;
		
		for (IIndividu<T> i : individus){
			sum += i.getFitness();
		}
		
		return sum;
	}
	
	public IEvolution<T> getStrategy(){
		return strategy;
	}
	
	public void setStrategy(IEvolution<T> strategy){
		this.strategy = strategy;
	}
	
	public void removeLast(){
		individus.remove(size - 1);
		size--;
	}

	public void setSize(int size){
		this.size = size;
	}
	public ArrayList<IIndividu<T>> getIndividus(){
		return individus;
	}
	
	public void setIndividus(ArrayList<IIndividu<T>> newIndividus){
		this.individus = newIndividus;
	}
	
}
