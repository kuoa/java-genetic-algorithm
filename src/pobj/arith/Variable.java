package pobj.arith;

public class Variable implements Expression {

	private int rang;		/** rank in the variables array */

	/**
	 *  Constructs a variable having the specified index 
	 * in the expression container.
	 * @param rang, index in the variables array
	 */
	
	public Variable(int rang) {		
		this.rang = rang;
	}

	/** 
	 * Evaluates the Variable in the environment.
	 * @param e, evaluation environment */
	
	@Override
	public double eval(EnvVal e) {
	
		return e.getValue(rang);
	}

	/**
	 * Redefinition of toString().
	 * @return a string representation
	 */
	
	@Override	
	public String toString() {
		return "Variable [X" + rang + "]";
	}	
}
