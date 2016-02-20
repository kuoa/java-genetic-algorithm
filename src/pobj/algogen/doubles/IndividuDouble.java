package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;

/**
 * Class representing an individual
 */

public class IndividuDouble extends AbstractIndividu implements Comparable<IIndividu>, IIndividu {

	/** value associated with a individual */
	private double valeurPropre;

	/** Make a individual associated with a random value */
	public IndividuDouble() {

		Random r = new Random();
		valeurPropre = r.nextDouble();
	}

	/** Make a individual associated with a given value @param valeurPropre */
	public IndividuDouble(double valeurPropre) {

		this.valeurPropre = valeurPropre;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#toString()
	 */

	@Override
	public String toString() {
		return "Individu [valeurPropre=" + valeurPropre + ", fitness=" + fitness + "]";
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#getValeurPropre()
	 */
	@Override
	public Object getValeurPropre() {

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
	 * @see pobj.algogen.IIndividu#croiser(pobj.algogen.IIndividu)
	 */
	@Override
	public IndividuDouble croiser(IIndividu i) {

		double newValeurPropre = (valeurPropre + (double) i.getValeurPropre()) / 2.1;
		return new IndividuDouble(newValeurPropre);

	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see pobj.algogen.IIndividu#muter(pobj.algogen.IIndividu)
	 */

	public void muter() {

		Random r = new Random();
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
