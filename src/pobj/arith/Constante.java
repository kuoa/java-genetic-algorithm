package pobj.arith;

public class Constante implements Expression {

	/** constant value */
	private final double value;
		
	/**
	 * Creates a constant value. 
	 * @param value, the constant value
	 */
	
	public Constante(double value) {		
		this.value = value;
	}
	
	/** 
	 * Evaluate the constant
	 * @return the value of the constant
	 */
	
	@Override
	public double eval(EnvVal e) {
		return value;
	}
	
	/**
	 * Redefinition of toString().
	 * @return a string representation
	 */	
	
	@Override
	public String toString() {
		return "Constante [value=" + value + "]";
	}		
}
