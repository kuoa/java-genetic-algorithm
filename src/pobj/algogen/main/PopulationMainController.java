package pobj.algogen.main;

import java.io.IOException;

import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;
import agent.laby.interf.LabyWiewer;
import pobj.algogen.IIndividu;
import pobj.algogen.Population;
import pobj.algogen.PopulationFactory;
import pobj.algogen.agent.SimulationCible;

public class PopulationMainController {

	public static void main(String[] args) {

		int popSize = 10; 
		int nbRules = 6;
								
		String labyFile = "goal.mze"; 
		int nbSteps = 50; 	
		Labyrinthe laby = null;
		
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
	
		for (int i = 0; i < 50000; i++){
			
			population = population.evoluer(simCible);												
			
		}	
		IIndividu<IControleur> bestIndividual = population.get(0);
		
		new LabyWiewer(laby, bestIndividual.getValeurPropre(), nbSteps);
		
	}
}
