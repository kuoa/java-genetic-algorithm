package pobj.algogen;

import pobj.algogen.arith.FonctionCible;
import pobj.arith.EnvVal;
import pobj.arith.ExpressionFactory;

public class PopulationMain {

	public static void main(String[] args) {

		int size = 10; 						
		
		EnvVal e = ExpressionFactory.createRandomEnvironment();
		
		System.out.println("EnvVal : " +e.toString());
		
		double valeurCible = 4.231;
		
		FonctionCible funCible = new FonctionCible(e, valeurCible); 
		
	
		Population population = PopulationFactory.createRandomPopulation(size);
		System.out.println(population.toString(e));
	
		for (int i = 0; i < 1000; i++){
			
			System.out.println ("\n[INFO]");
			System.out.println ("Population size before :" + population.size());		
			
			population = population.evoluer(funCible);												
			
			System.out.println ("Population size after :" + population.size());
			System.out.println(population.toString(e));
		}				
	}
}
