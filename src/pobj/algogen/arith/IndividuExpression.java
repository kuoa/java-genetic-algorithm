package pobj.algogen.arith;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;
import pobj.arith.Operator;

public class IndividuExpression extends AbstractIndividu implements IIndividu {

	private Expression valeurPropre;
	private int depth = 10;

	public IndividuExpression() {
		valeurPropre = ExpressionFactory.createRandomExpression(depth);
	}

	public IndividuExpression(Expression valeurPropre) {
		this.valeurPropre = valeurPropre;
	}

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

	@Override
	public void muter() {
		valeurPropre = ExpressionFactory.createRandomExpression(depth);
	}


	@Override
	public IIndividu clone() {
		
		IIndividu newIndividu = new IndividuExpression(valeurPropre);
		newIndividu.setFitness(fitness);
		
		return newIndividu;						
	}

	@Override
	public Object getValeurPropre() {
		return valeurPropre;
	}

	public String toString(EnvVal e) {
		return "IndividuExpression [valeurPropre=" + valeurPropre.eval(e)
				+ ", fitness=" + fitness + "]";
	}
	
	

}
