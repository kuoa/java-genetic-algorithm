package pobj.algogen.doubles;

import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;

/**
 * Test the evolution of a population of 30 individuals.
 * @author kuoa
 *
 */
public class TestMainDouble {

	public static void main(String[] args) {

		int size = 30; 						
		
		ValeurCible targetValue = new ValeurCible(0.3);		
		System.out.println(targetValue);
		
		System.out.println("[** Creating the first generation **]\n");		
		Population population = PopulationFactory.randomPopulationIDouble(size);
		
		System.out.println("[** Generation : 0 **]\n");							
		System.out.println(population.toString());
	
		for (int i = 0; i < 10; i++){
			
			System.out.println ("\n        [INFO]");
			System.out.println("[** Generation : " + (i + 1) + " **]\n");
			System.out.println ("Population size before :" + population.size());		
			
			population = population.evoluer(targetValue);												
			
			System.out.println ("Population size after :" + population.size() + "\n");
			System.out.println(population.toString());
		}				
	}
}
