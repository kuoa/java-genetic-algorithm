package pobj.algogen;

import java.util.Random;

import pobj.util.Generator;

public class NicheEvolution<T> implements IEvolution<T> {
	
	private IndivSelector<T> indivSelector;
	
	public NicheEvolution() {
		this.indivSelector = new FitnessSelector<>();
	}
	
	
	@Override
	public Population<T> reproduire(Population<T> pop) {

		Population<T> newPop = new Population<T>();
		newPop.setStrategy(pop.getStrategy());
		
		newPop.setIndividus(pop.getIndividus());
		newPop.setSize(pop.size());
		
		
		Random r = Generator.getInstance();

		int size = pop.size();
		int cloneSize = (int) (size * 0.2);		
		
		int min = 5;
		int max = 15;
		double prob = (r.nextInt(max - min + 1) + min) / 100.0;
				
		// less than 5 individuals
		if (cloneSize < 1) {
			cloneSize = 1;
		}
		

		IIndividu<T> mother = indivSelector.getRandom(pop);
		IIndividu<T> father = indivSelector.getRandom(pop);
		
		IIndividu<T> newIndividu = father.croiser(mother);
			
		newPop.removeLast();			
		newPop.add(newIndividu);

		// System.out.println("New individual by reproduction: " +
		// newIndividu.toString());
		

		System.out.println("Probabilty of mutation: " + prob + " %");
		newPop.muter(prob);
		
		return newPop;
	}	

}
