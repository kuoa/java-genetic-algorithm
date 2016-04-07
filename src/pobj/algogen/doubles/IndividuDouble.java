package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;
import pobj.util.Generator;

/**
 * Class representing an individual
 */

public class IndividuDouble extends AbstractIndividu<Double> implements
		Comparable<IIndividu<Double>>, IIndividu<Double> {
		
	/** Make a individual associated with a random value */
	public IndividuDouble() {
		super(Generator.nextDouble());		
	}

	/** Make a individual associated with a given value @param valeurPropre */
	public IndividuDouble(double valeurPropre) {
		super(valeurPropre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#toString()
	 */

	@Override
	public String toString() {
		return "Individu [valeurPropre=" + valeurPropre + ", fitness="
				+ fitness + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#getValeurPropre()
	 */
	@Override
	public Double getValeurPropre() {

		return (valeurPropre);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#setValeurPropre(double)
	 */
	
	public void setValeurPropre(double newValue) {
		valeurPropre = newValue;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#compareTo(pobj.algogen.Individu)
	 */
	@Override
	public int compareTo(IIndividu<Double> i) {

		return Double.compare(this.fitness, i.getFitness());
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#croiser(pobj.algogen.IIndividu)
	 */
	@Override
	public IndividuDouble croiser(IIndividu<Double> i) {

		double newValeurPropre = (valeurPropre + (double) i.getValeurPropre()) / 2.1;
		return new IndividuDouble(newValeurPropre);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#muter(pobj.algogen.IIndividu)
	 */

	public void muter() {

		Random r = Generator.getInstance();
		fitness = r.nextDouble();
		System.out.println("new fitness: " + fitness);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#clone()
	 */
	@Override
	public IndividuDouble clone() {

		IndividuDouble newIndividu = new IndividuDouble(valeurPropre);
		newIndividu.setFitness(fitness);

		return newIndividu;
	}

}
