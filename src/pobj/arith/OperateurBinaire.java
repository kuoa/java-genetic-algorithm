package pobj.arith;

public class OperateurBinaire implements Expression {

	private final Operator op;			/** operator {@link Operator */ 
	private final Expression left;		/** left Expression */
	private final Expression right;		/** right Expression */
						

	/** Constructs a OperateurBinaire having as 
	 * @param op operator {@link Operator}, PLUS, MOINS, MULT, DIV
	 * @param left  left Expression
	 * @param right right Expression
	 */
	
	public OperateurBinaire(Operator op, Expression left, Expression right) {		
		
		this.left = left;
		this.right = right;
		this.op = op;
	}

	/** Evaluates the current expressionn in the environment @parm e */
	
	@Override
	public double eval(EnvVal e) {
		
		double leftEval = left.eval(e);
		double rightEval = right.eval(e);
		double result;
		
		switch(op){
											
		case PLUS :
			result = leftEval + rightEval;
			break;
		
		case MINUS :
			result = leftEval - rightEval;
			break;
			
		case MULT :
			result = leftEval * rightEval;
			break;
			
		case DIV :
			result = leftEval / rightEval;
			break;
			
		default:
			result = -1;
			System.out.println("Unrecognized operator");			
			break;
		}
		
		return result;
	}
			
	/** @return left Expression */
		
	
	public Expression getLeft() {
		return left;
	}

	/** @return right Expression */
	
	public Expression getRight() {
		return right;
	}

	/** toString method */
	@Override
	public String toString() {
		return "OperateurBinaire [op=" + op + ", left=" + left + ", right="
				+ right + "]";
	}
		
}
