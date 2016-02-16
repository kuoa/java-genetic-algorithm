package pobj.arith;

public class Variable implements Expression {

	private int rang;		/** rank in the variables array */


	/** Constructs a variable of rank @param rang */
	
	public Variable(int rang) {		
		this.rang = rang;
	}

	/** Evaluates the Variable in the environment @param e */
	
	@Override
	public double eval(EnvVal e) {
	
		return e.getValue(rang);
	}

	/** toString method */
	
	@Override	
	public String toString() {
		return "Variable [X" + rang + "]";
	}	
}
