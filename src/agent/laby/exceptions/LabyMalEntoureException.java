package agent.laby.exceptions;

import java.awt.Point;

public class LabyMalEntoureException extends LabyErroneException {
	
	private static final long serialVersionUID = 1L;

	public LabyMalEntoureException(Point point){
		super(point);
	}

}
