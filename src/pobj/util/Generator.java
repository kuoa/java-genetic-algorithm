package pobj.util;

import java.util.Random;

public class Generator {
	
	public static final Random r = new Random();
		
	public static Random getInstance(){
		return r;
	}	
	
	public static int nextInt(int bound){
		return r.nextInt(bound);
	}
	
	public static int nextInt(){
		return r.nextInt();
	}
			
	public static double nextDouble(){
		return r.nextDouble();
	}
	
	public static void setSeed(long seed){
		r.setSeed(seed);
	}
	
}
