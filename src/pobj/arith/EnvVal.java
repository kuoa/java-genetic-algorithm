package pobj.arith;

import java.util.Arrays;

public class EnvVal {

	/** variables array */	
	private double variables[];
	
	/** variables array size */
	private int size;

	/** Constructs a environment @param size */
	
	public EnvVal(int size) {

		variables = new double[size];
		this.size = size;
	}
	
	/** Sets a variable of @param value at @param index in the variables array */
	
	public void setVariable(int index, double value)
			throws ArrayIndexOutOfBoundsException {
		
		if (index < size){
			variables[index] = value;
		}
		else {
			throw new ArrayIndexOutOfBoundsException("[Size: " + size + " index: " + index + "]");
		}
		
	}
	
	/** Returns the value associated with the variable at @param index */
	
	public double getValue(int index) 
			throws ArrayIndexOutOfBoundsException {
		
		if (index < size){
			return variables[index];
		}
		else {
			throw new ArrayIndexOutOfBoundsException("[Size: " + size + " index: " + index + "]");
		}
	}

	@Override
	
	/** toString method */
	
	public String toString() {
		return "EnvVal [variables=" + Arrays.toString(variables) + ", size="
				+ size + "]";
	}		

}
