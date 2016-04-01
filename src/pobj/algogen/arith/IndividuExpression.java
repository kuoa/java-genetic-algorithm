package pobj.algogen.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;
import pobj.arith.Operator;

public class IndividuExpression extends AbstractIndividu<Expression> implements Comparable<IIndividu<Expression>>, IIndividu<Expression> {
		
	public static final int DEPTH = 10;
	
	public IndividuExpression() {		
		super(ExpressionFactory.createRandomExpression(DEPTH));		
	}

	public IndividuExpression(Expression valeurPropre) {		
		super(valeurPropre);
	}

	@Override
	public IIndividu<Expression> croiser(IIndividu<Expression> i) {

		
			Expression iValeurPropre = (Expression) i.getValeurPropre();

			Expression left = ExpressionFactory.createOperatorBinaire(
					Operator.PLUS, valeurPropre, iValeurPropre);
			Expression right = ExpressionFactory.createConstant(2.1);

			Expression newValeurPropre = ExpressionFactory
					.createOperatorBinaire(Operator.DIV, left, right);

			return new IndividuExpression(newValeurPropre);
	}

	@Override
	public void muter() {
		valeurPropre = ExpressionFactory.createRandomExpression(DEPTH);
	}

	@Override
	public int compareTo(IIndividu<Expression> i) {
				
		return Double.compare(this.fitness, i.getFitness());
	}

	@Override
	public IIndividu<Expression> clone() {
		
		IIndividu<Expression> newIndividu = new IndividuExpression(valeurPropre);
		newIndividu.setFitness(fitness);
		
		return newIndividu;						
	}

	@Override
	public Expression getValeurPropre() {
		return valeurPropre;
	}

	public String toString(EnvVal e) {
		return "IndividuExpression [valeurPropre=" + valeurPropre.eval(e)
				+ ", fitness=" + fitness + "]";
	}

}
