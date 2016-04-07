package pobj.util;

public class GeneratorMain {

	public static void main(String[] args) {		
		
		Generator.setSeed(10);
		
		for(int i = 0; i < 10; i++){
			System.out.println(Generator.getInstance().nextInt(21));
		}										
	}
}
