package agent.laby;

import java.awt.Point;

import agent.laby.exceptions.CaseDepartNonVideException;
import agent.laby.exceptions.LabyMalEntoureException;

public class VerificationLaby {

	private static void estEntourerDeMurs(Labyrinthe l)
			throws LabyMalEntoureException {

		int cols = l.Ysize(); 
		int rows = l.Xsize();
				
		for (int i = 0; i < rows; i++) {
			
			ContenuCase leftWallCell = l.getContenuCase(i, 0);
			
			if (leftWallCell != ContenuCase.MUR) {
				throw new LabyMalEntoureException(new Point(i, 0));
			}
			
			ContenuCase rightWallCell = l.getContenuCase(i, cols - 1);

			if (rightWallCell != ContenuCase.MUR) {
				throw new LabyMalEntoureException(new Point(i, cols - 1));
			}
		}
		
		
		for (int i = 0; i < cols; i++){
			
			ContenuCase topWallCell = l.getContenuCase(0, i);
			
			if (topWallCell != ContenuCase.MUR){
				throw new LabyMalEntoureException(new Point(0, i));
			}			
			
			ContenuCase buttomWallCell = l.getContenuCase(rows - 1, i);
			
			if (buttomWallCell != ContenuCase.MUR){
				throw new LabyMalEntoureException(new Point(rows - 1, i));
			}
		}		
	}
	
	private static void estCaseInitialeVide(Labyrinthe l) throws CaseDepartNonVideException{
		
		ContenuCase cellStart = l.getContenuCase(1, 1);
		
		if (cellStart != ContenuCase.VIDE){
			throw new CaseDepartNonVideException(new Point(1, 1));
		}
	}
	
	public static void verifierConditions (Labyrinthe l) throws LabyMalEntoureException, CaseDepartNonVideException {
		
		estCaseInitialeVide(l);
		estEntourerDeMurs(l);
	}
	
	public static int corrigerConditions(Labyrinthe l){
		
		int times = 0 ;
		
		while (true){
			
			try {
				verifierConditions(l);
			}
			catch (LabyMalEntoureException e){
				Point p = e.getPoint();				
				l.setContenuCase(p, ContenuCase.MUR);
				times ++;
				continue;
			}
			catch (CaseDepartNonVideException e){
				Point p = e.getPoint();
				l.setContenuCase(p, ContenuCase.VIDE);
				times ++;
				continue;
			}		
			
			return times;
		}
				
	}
	
	
}
