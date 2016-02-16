package pobj.arith;

import java.util.Random;

public class ExpressionFactory {

	private static final int MAXVARIABLE = 2;		/** Number of max variables */
	private static Random generator = new Random(); /** Random generator */

	/** Constructs a expression having as 
	 * @param op operator {@link Operator}, PLUS, MOINS, MULT, DIV
	 * @param left  left Expression
	 * @param right right Expression
	 */
	
	public static Expression createOperatorBinaire(Operator op,
			Expression left, Expression right) {

		return new OperateurBinaire(op, left, right);
	}
	
	/** Constructs a constant having the 
	 * @param value
	 */
	
	public static Expression createConstant(double value) {

		return new Constante(value);
	}
	
	/** Constructs a variable having rank 
	 * @param rang in the variables array
	 */

	public static Expression createVariable(int rang) {

		return new Variable(rang);
	}

	/** Constructs a random environment of size	 
	 */
	
	public static EnvVal createRandomEnvironment() {

		EnvVal e = new EnvVal(MAXVARIABLE);

		for (int i = 0; i < MAXVARIABLE; i++) {

			double value = generator.nextDouble();
			e.setVariable(i, value);
		}

		return e;
	}
	
	/** Constructs a random expression of maximum @param depth */

	public static Expression createRandomExpression(int depth) {

		final int CONSTANTE = 0;
		final int VARIABLE = 1;
		final int OPBIN = 2;

		int type = generator.nextInt(3); // generate the type of Expression
		int constBound = 0;
		
		Expression exp = null;

		
		if (depth > 0) {
			
			switch (type) {

			case CONSTANTE:

				constBound = MAXVARIABLE; // programmer's choice
				exp = createConstant(generator.nextDouble() * constBound);
				break;

			case VARIABLE:

				constBound = MAXVARIABLE;
				int rang = generator.nextInt(constBound);
				exp = createVariable(rang);
				break;

			case OPBIN:

				Operator availableOps[] = { Operator.PLUS, Operator.MINUS, Operator.MULT }; // NO DIV
				int index = generator.nextInt(availableOps.length); 						// index

				Operator op = availableOps[index];

				Expression left = createRandomExpression(depth - 1);
				Expression right = createRandomExpression(depth - 1);

				exp = createOperatorBinaire(op, left, right);
				break;

			default:
				System.out.println("UKNOWN OPTION");
				break;
			}
		}
		else {
			exp = createConstant(generator.nextDouble());
		}
		
		return exp;

	}
}
