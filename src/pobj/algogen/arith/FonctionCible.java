package pobj.algogen.arith;

import pobj.algogen.Environnement;
import pobj.algogen.IIndividu;
import pobj.arith.EnvVal;
import pobj.arith.Expression;

public class FonctionCible implements Environnement{
	
	
	/** The variable container */
	private EnvVal enval;
	
	/** Target value for the function */
	private double y;
	
	/**
	 * Create a new evaluation environment.
	 * @param enval the variables container
	 * @param valeurCible the target value	 
	 */
	
	public FonctionCible(EnvVal enval, double valeurCible) {		
		this.enval = enval;
		y = valeurCible;
	}
	
	
	/**
	 * Evaluates the individual on the current environment.
	 * @param i the individual being evaluated
	 * @return the new fitness value
	 */
	
	@Override	
	public double eval(IIndividu i) {
		
		IndividuExpression individu = (IndividuExpression) i;
		Expression valeurPropre = (Expression) individu.getValeurPropre();
		
		double fX = valeurPropre.eval(enval);
		
		return 1 / Math.pow((y - fX), 2);
		
	}
	
	/**
	 * Redefinition of toString().
	 * @return a string representation
	 */
	
	public String toString(){
		return "[** Target Value : " + y + " **]\n" +		
			   "[** Variables container  **]\n" + enval.toString() + "\n";
	}
}
