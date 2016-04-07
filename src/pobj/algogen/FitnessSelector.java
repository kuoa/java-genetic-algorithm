package pobj.algogen;

import pobj.util.Generator;

public class FitnessSelector<T> implements IndivSelector<T>{
	
	public IIndividu<T> getRandom(Population<T> pop) {
		
		double fitnessSum = pop.getFitnessSum();
		double r = Generator.nextDouble();		
		double chosenFitness = r * fitnessSum;		
		double currentFitness = 0;
		
		IIndividu<T> chosen = null;
		
		for(int i = 0; i < pop.size(); i++){
			IIndividu<T> ind = pop.get(i);
			
			currentFitness += ind.getFitness();
			if(currentFitness >= chosenFitness){
				chosen = ind;
				break;
			}
		}
		
		return chosen;
	}
	
}
