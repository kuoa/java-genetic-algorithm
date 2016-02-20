package pobj.algogen.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;
import pobj.arith.Operator;

/**
 * Class representing an individual [Expression].
 * 
 * This is a example of an Expression individual.
 * He has a proper value [valeurPropre], which is a mathematical function that evaluates to a value v.
 * The fittest individuals are the ones for who this evaluation value is the closest
 * to that of the environment [ValeurCible].
 * 
 * [Example] : let the [valeurCible] be [y]
 * 			   and the [valeurPropre] [val] be the evaluation of the function [f(x1, x2, x3, x4 .. xn) = val]
 * 
 * We are looking for a function for which v = y. 
 */


public class IndividuExpression extends AbstractIndividu implements IIndividu {
	
	/** value associated with a individual */
	private Expression valeurPropre;
	
	/** max depth of the expression tree */
	private int depth = 10;

	/** 
	 * Create a individual that has a random valeurPropre.
	 */
	
	public IndividuExpression() {
		valeurPropre = ExpressionFactory.createRandomExpression(depth);
	}
	
	/**
	 * Create a individual having the specified valeurPropre.
	 * @param valeurPropre the proper value
	 */
	
	public IndividuExpression(Expression valeurPropre) {
		this.valeurPropre = valeurPropre;
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#croiser(pobj.algogen.IIndividu)
	 */
	
	@Override
	public IIndividu croiser(IIndividu i) {

		if (i instanceof IndividuExpression) {
			
			Expression iValeurPropre = (Expression) i.getValeurPropre();

			Expression left = ExpressionFactory.createOperatorBinaire(
					Operator.PLUS, valeurPropre, iValeurPropre);
			Expression right = ExpressionFactory.createConstant(2.1);

			Expression newValeurPropre = ExpressionFactory
					.createOperatorBinaire(Operator.DIV, left, right);

			return new IndividuExpression(newValeurPropre);
		}

		else {
			System.out.println("Wrong type in <croiser>\n");
			return null;
		}
	}
	
	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#muter(pobj.algogen.IIndividu)
	 */
	
	@Override
	public void muter() {
		valeurPropre = ExpressionFactory.createRandomExpression(depth);
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#clone()
	 */
	
	@Override
	public IIndividu clone() {
		
		IIndividu newIndividu = new IndividuExpression(valeurPropre);
		newIndividu.setFitness(fitness);
		
		return newIndividu;						
	}
	
	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#getValeurPropre()
	 */

	@Override
	public Object getValeurPropre() {
		return valeurPropre;
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#toString()
	 */
	
	public String toString(EnvVal e) {
		return "IndividuExpression [valeurPropre=" + valeurPropre.eval(e)
				+ ", fitness=" + fitness + "]";
	}		
}
