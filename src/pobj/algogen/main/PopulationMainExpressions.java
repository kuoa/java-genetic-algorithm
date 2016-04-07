package pobj.algogen.main;

import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.arith.FonctionCible;
import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;
import pobj.util.Generator;

public class PopulationMainExpressions {

	public static void main(String[] args) {

		int size = 10; 
				
		//ValeurCible v = new ValeurCible(0.3);
		
		Generator.setSeed(10);
		
		EnvVal e = ExpressionFactory.createRandomEnvironment();
		
		System.out.println("EnvVal : " +e.toString());
		
		double valeurCible = 4.231;
		
		FonctionCible funCible = new FonctionCible(e, valeurCible); 
		
	
		Population<Expression> population = PopulationFactory.createRandomExpressionPopulation(size);
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
