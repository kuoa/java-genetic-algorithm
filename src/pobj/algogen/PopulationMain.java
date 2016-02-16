package pobj.algogen;

public class PopulationMain {

	public static void main(String[] args) {

		int size = 30; 
				
		ValeurCible v = new ValeurCible(0.3);
	
		Population population = PopulationFactory.createRandomPopulation(size);
		System.out.println(population.toString());
	
		for (int i = 0; i < 10; i++){
			
			System.out.println ("\n[INFO]");
			System.out.println ("Population size before :" + population.size());		
			
			population = population.evoluer(v);												
			
			System.out.println ("Population size after :" + population.size());
			System.out.println(population.toString());
		}				
	}
}
