package pobj.algogen.agent;

import agent.control.ControlFactory;
import agent.control.IControleur;
import pobj.algogen.AbstractIndividu;
import pobj.algogen.IIndividu;

public class IndividuControler extends AbstractIndividu<IControleur> implements Comparable<IIndividu<IControleur>>, IIndividu<IControleur> {

	
	public IndividuControler(int nbRules) {
		super(ControlFactory.createControleur(nbRules));
	}
	
	public IndividuControler(IControleur valeurPropre){
		super(valeurPropre);
	}

	@Override
	public int compareTo(IIndividu<IControleur> i) {
		return Double.compare(this.fitness, i.getFitness());
	}

	@Override
	public IIndividu<IControleur> croiser(IIndividu<IControleur> i) {
		
		IControleur newValeurPropre = valeurPropre.creeFils(i.getValeurPropre(), 0.5);
		return  new IndividuControler(newValeurPropre);			
	}

	@Override
	public void muter() {
		valeurPropre.muter(1);
		
	}

	@Override
	public IIndividu<IControleur> clone() {
		
		IndividuControler clone = new IndividuControler(valeurPropre.clone());
		clone.setFitness(fitness);
		
		return clone;
		
	}
}
