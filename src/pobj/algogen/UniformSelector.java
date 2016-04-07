package pobj.algogen;

import pobj.util.Generator;

public class UniformSelector<T> implements IndivSelector<T> {

	@Override
	public IIndividu<T> getRandom(Population<T> pop) {
		
		int size = pop.size();
		int index = Generator.nextInt(size);
		
		return pop.get(index);		
	}
	
	

}
