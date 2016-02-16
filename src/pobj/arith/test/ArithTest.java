package pobj.arith.test;

import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;

public class ArithTest {

	public static void main(String[] args) {

		EnvVal e = ExpressionFactory.createRandomEnvironment();

		/*
		System.out.println(e.toString());
		
		System.out.println(ExpressionFactory.createOperatorBinaire(
					Operator.MINUS, ExpressionFactory.createConstant(4),
					ExpressionFactory.createConstant(5)).toString());
		
		*/		
		
		for(int i = 0; i < 20; i++){
		
			Expression exp = ExpressionFactory.createRandomExpression(3);
			
			System.out.println(exp.toString());
			System.out.println(exp.eval(e));
			System.out.println("\n");
		}
	}

}
