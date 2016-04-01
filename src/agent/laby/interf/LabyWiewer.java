package agent.laby.interf;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import agent.Simulation;
import agent.control.ControlFactory;
import agent.control.IControleur;
import agent.laby.ChargeurLabyrinthe;
import agent.laby.LabyActivePanel;
import agent.laby.Labyrinthe;


public class LabyWiewer extends JFrame {
	
	private static final long serialVersionUID = 1L;

	private Labyrinthe laby;
	private IControleur controller;
	private int nbSteps;

	private JPanel sidePanel;
	private LabyActivePanel centerPanel;
	
	private Thread thread;

	public LabyWiewer(Labyrinthe laby, IControleur controller, int nbSteps) {

		super("LabyViewer");

		this.laby = laby;
		this.controller = controller;
		this.nbSteps = nbSteps;

		createCenterPanel();
		createSidePanel();

		// Positionner la taille de la fenetre
		setSize(800, 758);
		setResizable(false);
		// traiter le clic sur la croix
		setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
		// rendre visible
		setVisible(true);
	}

	private void createSidePanel() {
		sidePanel = new JPanel();
		sidePanel.setLayout(new BoxLayout(sidePanel, BoxLayout.Y_AXIS));

		JButton playButton = new JButton("PLAY");
		// wallButton.setIcon(new ImageIcon("wall.jpg"));
		sidePanel.add(playButton);

		playButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {											
			
				thread = new Thread(new Runnable() {

					@Override
					public void run() {	

						Labyrinthe labyClone = laby.clone();

						Simulation sim = new Simulation(labyClone, controller);
						
						centerPanel.setLaby(labyClone);	
												
						sim.addObserver(centerPanel);																		
						
						sim.mesurePerf(nbSteps);						
						
						sim.deleteObserver(centerPanel);
						
					}
				});
				
				thread.start();
			}
		});	
		
		JButton stopButton = new JButton("STOP");
		sidePanel.add(stopButton);
		
		stopButton.addActionListener(new ActionListener() {
			
			@SuppressWarnings("deprecation")
			@Override
			public void actionPerformed(ActionEvent e) {
				thread.stop();				
			}
		});

		getContentPane().add(sidePanel, BorderLayout.EAST);
	}

	private void createCenterPanel() {
		centerPanel = new LabyActivePanel(laby);
		getContentPane().add(centerPanel, BorderLayout.CENTER);
	}

	public static void main(String args[]) {

		String labyFile = "goal.mze"; // args[0];
		int nbSteps = 50; // Integer.parseInt(args[1]);
		//int nbRules = 10; // Integer.parseInt(args[2]);

		try {
			Labyrinthe laby = ChargeurLabyrinthe.chargerLabyrinthe(labyFile);

			IControleur sc = ControlFactory.createControleurDroitier();
			
			new LabyWiewer(laby, sc, nbSteps);			
			
		} catch (IOException e) {
			System.out.println("Problème de chargement du labyrinthe" + e);
			System.exit(1);
		}
	}
}
