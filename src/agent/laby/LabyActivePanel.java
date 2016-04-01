package agent.laby;

import java.awt.event.ActionEvent;

import pobj.obs.ISimpleObserver;
import agent.laby.interf.LabyPanel;


public class LabyActivePanel extends LabyPanel implements ISimpleObserver{

	private static final long serialVersionUID = 1L;

	public LabyActivePanel(Labyrinthe laby) {
		super(laby);
	}
	
	@Override
	
	public void actionPerformed(ActionEvent e) {
		// Clicks have no effect;
	}

	@Override
	public void update() {
		try {
			// force update when laby-state has changed		
			System.out.println("Update Graphics");
			updateGraphics();
			
			Thread.sleep(100);
		} catch (InterruptedException e){
			e.printStackTrace();
		}				
	}

}
