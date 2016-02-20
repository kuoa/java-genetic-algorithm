package pobj.arith.test;

import pobj.arith.EnvVal;
import pobj.arith.Expression;
import pobj.arith.ExpressionFactory;

public class ArithTest {

	public static void main(String[] args) {

		EnvVal e = ExpressionFactory.createRandomEnvironment();	
		
		for(int i = 0; i < 20; i++){
		
			Expression exp = ExpressionFactory.createRandomExpression(3);
			
			System.out.println(exp.toString());
			System.out.println(exp.eval(e) + "\n");			
		}
	}

}
