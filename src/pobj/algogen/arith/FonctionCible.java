package pobj.algogen.arith;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;
import pobj.arith.EnvVal;
import pobj.arith.Expression;

public class FonctionCible implements Environnement{
	
	private EnvVal enval;
	private double y;
	
	public FonctionCible(EnvVal enval, double valeurCible) {		
		this.enval = enval;
		y = valeurCible;
	}
		
	public double eval(IIndividu i) {
		
		IndividuExpression individu = (IndividuExpression) i;
		Expression valeurPropre = (Expression) individu.getValeurPropre();
		
		double fX = valeurPropre.eval(enval);
		
		return 1 / Math.pow((y - fX), 2);
		
	}		
}
