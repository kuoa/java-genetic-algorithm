package pobj.util;

import pobj.algogen.AlgoGenParameter;

public class ConfigurationMain implements AlgoGenParameter {

	public static void main(String[] args) {
		
		Configuration conf = new Configuration();
		
		int popSize = 50; 		// 100
		int nbRules = 6;								
		String labyFile = "goal.mze"; 
		int nbSteps = 100; 			
		int seed = 10;
		int nbGen = 10000;
		boolean generationalEvolution = true;
		
		conf.set(POP_SIZE, Integer.toString(popSize));
		conf.set(NB_RULES, Integer.toString(nbRules));
		conf.set(NB_STEPS, Integer.toString(nbSteps));
		conf.set(NB_GENERATIONS, Integer.toString(nbGen));
		conf.set(RAND_SEED, Integer.toString(seed));
		conf.set(LABY_FILE, labyFile);
		conf.set(GEN_EVOLUTION, Boolean.toString(generationalEvolution));
		
		conf.saveToFile(FILE_NAME);				
		
	}

}
