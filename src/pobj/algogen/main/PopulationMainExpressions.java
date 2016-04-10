package pobj.algogen.main;

import pobj.algogen.IEvolution;
import pobj.algogen.NicheEvolution;
import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.arith.FonctionCible;
import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;

public class PopulationMainExpressions {

	public static void main(String[] args) {

		int size = 10; 
				
		//ValeurCible v = new ValeurCible(0.3);
						
		EnvVal e = ExpressionFactory.createRandomEnvironment();
		
		//System.out.println("EnvVal : " +e.toString());
		
		double valeurCible = 4.2;
		
		FonctionCible funCible = new FonctionCible(e, valeurCible); 
		
	
		Population<Expression> population = PopulationFactory.createRandomExpressionPopulation(size);
		IEvolution<Expression> strategy = new NicheEvolution<>();
		population.setStrategy(strategy);
	
		for (int i = 0; i < 1000; i++){			
			
			population = population.evoluer(funCible);																		
		}	
		
		System.out.println(population.toString(e));		
	}
}
