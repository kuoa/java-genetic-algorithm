package pobj.algogen.main;

import java.io.IOException;

import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
import agent.laby.interf.LabyWiewer;
import pobj.algogen.AlgoGenParameter;
import pobj.algogen.IIndividu;
import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.agent.SimulationCible;
import pobj.util.Configuration;
import pobj.util.Generator;

public class PopulationMainController implements AlgoGenParameter {

	public static void main(String[] args) {	
		
		Configuration conf = new Configuration();		
		conf.loadFromFile(FILE_NAME);
				
		int popSize = Integer.parseInt(conf.get(POP_SIZE));		
		int nbRules = Integer.parseInt(conf.get(NB_RULES));
		int nbSteps = Integer.parseInt(conf.get(NB_STEPS));
		int seed = Integer.parseInt(conf.get(RAND_SEED)); 
		
		String labyFile = conf.get(LABY_FILE);

		Labyrinthe laby = null;
		
		Generator.setSeed(seed);
				
		try {
			laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			
		} catch (IOException e) {			
		
			System.out.println("Could not charge labyrinth." + e);
			System.exit(1);
		}
		
		
		SimulationCible simCible = new SimulationCible(laby, nbSteps);		
		System.out.println("EnvVal : " + simCible.toString());
		
		Population<IControleur> population = PopulationFactory.createRandomControllerPopulation(popSize, nbRules);
	
		System.out.println(population.toString());
	
		for (int i = 0; i < 10000; i++){
			
			population = population.evoluer(simCible);												
			
		}	
		IIndividu<IControleur> bestIndividual = population.get(0);
		
		new LabyWiewer(laby, bestIndividual.getValeurPropre(), nbSteps);
		
	}
}
