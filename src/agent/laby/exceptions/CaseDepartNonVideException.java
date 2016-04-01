package agent.laby.exceptions;

import java.awt.Point;

public class CaseDepartNonVideException extends LabyErroneException {

	private static final long serialVersionUID = 1L;

	public CaseDepartNonVideException(Point point) {
		super(point);		
	}

}
