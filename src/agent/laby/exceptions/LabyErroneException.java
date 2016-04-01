package agent.laby.exceptions;

import java.awt.Point;

public class LabyErroneException extends Exception {
	
	private Point point;
	
	private static final long serialVersionUID = 1L;
	
	
	public LabyErroneException (Point point){
		super("Construction error on x = " + point.getX() + " y = " + point.getY());
		this.point = point;
	}	
	
	public Point getPoint(){
		return point;
	}
}
