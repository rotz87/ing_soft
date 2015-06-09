package service;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

public class SystemPropertiesHandler {
	public final String nomeFile = "sysProperties.txt";
	static private SystemPropertiesHandler instance;

	private SystemPropertiesHandler() {
	}

	static public SystemPropertiesHandler getInstance() {
		if (SystemPropertiesHandler.instance == null) {
			SystemPropertiesHandler.instance = new SystemPropertiesHandler();
		}
		return SystemPropertiesHandler.instance;
	}
	
	/**
	 * Legge le proprietà dal file e le scrive in System.properties
	 * @throws IOException
	 */
	public void loadProperties() throws IOException{
		FileInputStream propFile = null;
		 try {
            // set up new properties object from file
        propFile = new FileInputStream(nomeFile);
        Properties p = new Properties(System.getProperties());
        p.load(propFile);


        System.setProperties(p);
        
	    } catch (java.io.FileNotFoundException e) {
	   	 throw e;
	    } catch (java.io.IOException e) {
	   	 throw e;
	    }finally{
	    	if (propFile != null){
	   		 try {
					propFile.close();
				} catch (IOException e) {
					throw e;
				}
	   	 	}
	    }
	}
	
	/**
	 * Scrive le proprietà in System.properties e le memorizza nel file
	 * @param input
	 * @throws IOException
	 */
	public void storeProperties(Map<String, String> input) throws IOException{
		FileInputStream propFileIn = null;
		FileOutputStream propFileOut = null;
		Properties p = new Properties();
		 try {
	         propFileIn = new FileInputStream(nomeFile);

	         p.load(propFileIn);
	         
	         for(String key : input.keySet()){
	        	 p.setProperty(key, input.get(key));
	        	 System.setProperty(key, input.get(key));
	         }
			 
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}finally{
			 if (propFileIn != null){
	    		 try {
					propFileIn.close();
				} catch (IOException e) {
					throw e;
				}
	    	 }
		}
		 
		 
		try{
	         
			propFileOut = new FileOutputStream(nomeFile);

            p.store(propFileOut, "");
            
		} catch (FileNotFoundException e) {
			throw e;
		} catch (IOException e) {
			throw e;
		}finally{
			 if (propFileOut != null){
	    		 try {
					propFileOut.close();
				} catch (IOException e) {
					throw e;
				}
	    	 }
		}
	}
	
	public void storeProperty(String key, String value) throws IOException{
		Map<String, String> input = new HashMap<String, String>();
		input.put(key, value);
		storeProperties(input);
	}
	
}
