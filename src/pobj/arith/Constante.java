package pobj.arith;

public class Constante implements Expression {

	private final double value;		/** constant value */
		
	/** Creates a constant of @param value */
	
	public Constante(double value) {		
		this.value = value;
	}
	
	/** Evaluate the constant */
	
	@Override
	public double eval(EnvVal e) {
		return value;
	}
	
	/** toString method */
	
	@Override
	public String toString() {
		return "Constante [value=" + value + "]";
	}		
}
