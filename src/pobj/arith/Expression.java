package pobj.arith;

public interface Expression {
	
	/**
	 * Evaluate the current expression
	 * @param e the expression
	 * @return the value of the expression
	 */

	double eval(EnvVal e);
}
