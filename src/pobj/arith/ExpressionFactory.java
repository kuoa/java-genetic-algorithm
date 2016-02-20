package pobj.arith;

import java.util.Random;

public class ExpressionFactory {

	/** Number of max variables */
	private static final int MAXVARIABLE = 2;
	
	/** Random generator */
	private static Random generator = new Random(); 

	/** Constructs a expression having as 
	 * @param op operator {@link Operator}, PLUS, MOINS, MULT, DIV
	 * @param left  left Expression
	 * @param right right Expression
	 * @return a new expression
	 */
	
	public static Expression createOperatorBinaire(Operator op,
			Expression left, Expression right) {

		return new OperateurBinaire(op, left, right);
	}
	
	/** Constructs a constant.
	 * @param value, constant value
	 * @return a constant Expression
	 */
	
	public static Expression createConstant(double value) {

		return new Constante(value);
	}
	
	/** Constructs a variable having the specified index 
	 * in the expression container.
	 * @param rang, index in the variables array
	 * @return a new variable Expression
	 */

	public static Expression createVariable(int rang) {

		return new Variable(rang);
	}

	/** Constructs a random evaluation environment.
	 * @return a new evaluation environment	 
	 */
	
	public static EnvVal createRandomEnvironment() {

		EnvVal e = new EnvVal(MAXVARIABLE);

		for (int i = 0; i < MAXVARIABLE; i++) {

			double value = generator.nextDouble();
			e.setVariable(i, value);
		}

		return e;
	}
	
	/** Constructs a random expression having a maximum tree depth. 
	 * @param depth, maximum depth
	 * @return a random Expression
	 */

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
