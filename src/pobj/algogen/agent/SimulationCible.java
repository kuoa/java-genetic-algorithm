package pobj.algogen.agent;

import agent.Simulation;
import agent.control.IControleur;
import agent.laby.Labyrinthe;
import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;

public class SimulationCible implements Environnement<IControleur> {
	
	private Labyrinthe laby;
	private int steps;
	
	public SimulationCible(Labyrinthe laby, int steps){
		this.laby = laby;
		this.steps = steps;
	
	}
	
	@Override
	public double eval(IIndividu<IControleur> i) {
		
		Labyrinthe labyClone = laby.clone();

		Simulation sim = new Simulation(labyClone, i.getValeurPropre());																	
		
		return sim.mesurePerf(steps);						
	}

}
