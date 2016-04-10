package pobj.algogen.main;

import java.io.IOException;

import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
import agent.laby.interf.LabyWiewer;
import pobj.algogen.AlgoGenParameter;
import pobj.algogen.GenerationalEvolution;
import pobj.algogen.IEvolution;
import pobj.algogen.IIndividu;
import pobj.algogen.NicheEvolution;
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
		int nbGen = Integer.parseInt(conf.get(NB_GENERATIONS));
		boolean genEvolution = Boolean.parseBoolean(conf.get(GEN_EVOLUTION));
						
		String labyFile = conf.get(LABY_FILE);
		
		Labyrinthe laby = null;
		
		IEvolution<IControleur> strategy = null;
		
		Generator.setSeed(seed);
												
		try {
			laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			
		} catch (IOException e) {			
		
			System.out.println("Could not charge labyrinth." + e);
			System.exit(1);
		}
		
		
		SimulationCible simCible = new SimulationCible(laby, nbSteps);				
		
		Population<IControleur> population = PopulationFactory.createRandomControllerPopulation(popSize, nbRules);

		if(genEvolution){
			strategy =  new GenerationalEvolution<>();
		}
		else{
			strategy = new NicheEvolution<>();
		}
		 
		population.setStrategy(strategy);
				
		for (int i = 0; i < nbGen; i++){
			
			population = population.evoluer(simCible);								
		}	
		
		IIndividu<IControleur> bestIndividual = population.get(0);
		
		new LabyWiewer(laby, bestIndividual.getValeurPropre(), nbSteps);
		
	}
}
