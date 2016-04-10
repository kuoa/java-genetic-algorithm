package pobj.algogen;

import java.util.Random;

import pobj.util.Generator;

public class GenerationalEvolution<T> implements IEvolution<T> {

	private IndivSelector<T> indivSelector;
	
	public GenerationalEvolution() {
		this.indivSelector = new UniformSelector<>();
	}
	
	@Override
	public Population<T> reproduire(Population<T> pop) {

		Population<T> newPop = new Population<T>();
		newPop.setStrategy(pop.getStrategy());
		Random r = Generator.getInstance();

		int size = pop.size();
		int cloneSize = (int) (size * 0.2);
		int reprodSize = size - cloneSize;
		
		int min = 5;
		int max = 15;
		double prob = (r.nextInt(max - min + 1) + min) / 100.0;
				
		// less than 5 individuals
		if (cloneSize < 1) {
			cloneSize = 1;
		}

		for (int i = 0; i < cloneSize; i++) {

			IIndividu<T> individu = pop.get(i);
			newPop.add(individu.clone());

			// System.out.println("New individual by clone: " +
			// individu.toString());
		}

		for (int i = 0; i < reprodSize; i++) {

			IIndividu<T> mother = pop.get(i);

			//int fatherIndex = r.nextInt(cloneSize);

			IIndividu<T> father = indivSelector.getRandom(pop);
			IIndividu<T> newIndividu = father.croiser(mother);

			newPop.add(newIndividu);

			// System.out.println("New individual by reproduction: " +
			// newIndividu.toString());
		}

		System.out.println("Probabilty of mutation: " + prob + " %");
		newPop.muter(prob);
		
		return newPop;
	}	
}
