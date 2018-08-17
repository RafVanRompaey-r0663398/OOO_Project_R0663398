package model;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropertiesReader {

	Properties prop = new Properties();
	ClassLoader loader = Thread.currentThread().getContextClassLoader();
	InputStream input;
	String propFileName = "evaluation.properties";

	public PropertiesReader() {
		reader();
	}
	
	private void reader(){
		try {
			input = getClass().getClassLoader().getResourceAsStream(propFileName);
			
			if (input == null) {
				System.out.println("Sorry, unable to find " + propFileName);
				return;
			}

			prop.load(input);
			System.out.println(prop.getProperty("evaluation.mode"));

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public Properties getProperties(){
		return this.prop;
	}
}
