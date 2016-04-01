package agent.test.simulation;

import static org.junit.Assert.*;

import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.Labyrinthe;

public class SimulationTest {
	
	String labyFile = "goal.mze";
	int nbSteps = 50;
	Labyrinthe labyRight, labyWall;
	IControleur rightController, wallController;
	Simulation rightSim, wallSim;

	@Before
	public void setUp() throws Exception {
		

		try {
			labyRight = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			labyWall = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);
			

			rightController = ControlFactory.createControleurDroitier();
			wallController = ControlFactory.createControleurLongeMur();
					
			rightSim = new Simulation(labyRight, rightController);
			wallSim= new Simulation(labyWall, wallController);
			
			System.out.println("steps: " + wallSim.mesurePerf(nbSteps));

		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe" + e);
			System.exit(1);
		}
	}

	@Test
	public void testMesurePerf() {
		assertEquals(rightSim.mesurePerf(nbSteps), 4);		
	}

}
