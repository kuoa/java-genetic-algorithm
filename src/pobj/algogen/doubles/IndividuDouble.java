package pobj.algogen.doubles;

import java.util.Random;

import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;

/**
 * Class representing an individual [Double].
 * 
 * This is a simple example of individual.
 * He has a proper value [valeurPropre], which he must match with that of his environment.
 * The fittest individuals are the ones who are closest to that value.
 * 
 * [Example] : the [valeurCible] can be the highest/lowest temperature of the environment,
 * 			   and the [valeurPropre] is the max/min bound that this particular individual can tolerate. 
 */

public class IndividuDouble extends AbstractIndividu implements Comparable<IIndividu>, IIndividu {

	/** value associated with a individual */
	private double valeurPropre;

	/** 
	 * Create a individual that has a random valeurPropre.
	 */
	
	public IndividuDouble() {

		Random r = new Random();
		valeurPropre = r.nextDouble();
	}

	/**
	 * Create a individual having the specified valeurPropre.
	 * @param valeurPropre the proper value
	 */
	
	public IndividuDouble(double valeurPropre) {

		this.valeurPropre = valeurPropre;
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#croiser(pobj.algogen.IIndividu)
	 */
	
	@Override
	public IndividuDouble croiser(IIndividu i) {

		double newValeurPropre = (valeurPropre + (double) i.getValeurPropre()) / 2.1;
		return new IndividuDouble(newValeurPropre);

	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#muter(pobj.algogen.IIndividu)
	 */

	public void muter() {

		Random r = new Random();
		fitness = r.nextDouble();

		//System.out.println("new fitness: " + fitness);
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#clone()
	 */
	
	@Override
	public IndividuDouble clone() {

		IndividuDouble newIndividu = new IndividuDouble(valeurPropre);
		newIndividu.setFitness(fitness);

		return newIndividu;
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#getValeurPropre()
	 */
	
	@Override
	public Object getValeurPropre() {

		return (valeurPropre);
	}

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#setValeurPropre(double)
	 */

	public void setValeurPropre(double newValue) {
		valeurPropre = newValue;
	}		

	/*
	 * (non-Javadoc)
	 * @see pobj.algogen.IIndividu#toString()
	 */

	@Override
	public String toString() {
		return "Individu [valeurPropre=" + valeurPropre + ", fitness=" + fitness + "]";
	}

}
