package pobj.util;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class Configuration {
	
	private Properties prop;
	
	public Configuration(){
		prop = new Properties();
	}
	
	public void set(String key, String value){
		prop.setProperty(key, value);		
	}
	
	public String get(String key){
		return prop.getProperty(key);
	}
	
	public void saveToFile(String file){
		
		OutputStream output = null;
		
		try {
			output = new FileOutputStream(file);
			prop.store(output, null);
		}
		catch(IOException io){
			io.printStackTrace();
		}
		finally {
			if (output != null){
				try {
					output.close();
				}
				catch (IOException e){
					e.printStackTrace();					
				}
			}
		}				
	}
	
	public void loadFromFile(String file){
		
		InputStream input = null;
		
		try {
			input = new FileInputStream(file);
			prop.load(input);
			
			
		} catch (IOException e) {			
			e.printStackTrace();
		}
		finally {
			
			if (input != null){
				try {
					input.close();
				}
				catch (IOException e){
					e.printStackTrace();					
				}
			}
		}
	}
}
