package pobj.algogen.arith;

import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.arith.FonctionCible;
import pobj.arith.EnvVal;
import pobj.arith.ExpressionFactory;

public class TestMainArith {

	public static void main(String[] args) {

		int size = 10; 						
		
		EnvVal e = ExpressionFactory.createRandomEnvironment();
						
		double targetValue = 4.231;
								
		FonctionCible funCible = new FonctionCible(e, targetValue); 		
		
		System.out.println(funCible);
		
		System.out.println("[** Creating the first generation **]\n");		
		Population population = PopulationFactory.randomPopulationIExpression(size);
		
		System.out.println("[** Generation : 0 **]\n");									
		System.out.println(population.toString(e));
	
		for (int i = 0; i < 1000; i++){
			
			System.out.println ("\n        [INFO]");
			System.out.println("[** Generation : " + (i + 1) + " **]\n");
			System.out.println ("Population size before :" + population.size());		
			
			population = population.evoluer(funCible);												
			
			System.out.println ("Population size after :" + population.size() + "\n");
			System.out.println(population.toString(e));
		}				
	}
}
