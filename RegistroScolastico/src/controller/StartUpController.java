package controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.joda.time.LocalDate;
import org.orm.PersistentException;

import service.SystemPropertiesHandler;
import controller.votoConverter.VotoConverterFactory;
import controller.votoConverter.VotoDecimalConverter;
import domain.model.Calendario;
import domain.model.GiornoFestivoCriteria;
import domain.model.GiornoSettimanaleFestivoCriteria;

public class StartUpController {
	
    public void start() {
		
		try {
			GiornoFestivoCriteria giornoFC = new GiornoFestivoCriteria();
			GiornoSettimanaleFestivoCriteria giornoSFC = new GiornoSettimanaleFestivoCriteria();
			Calendario.getInstance().getGiorniFestivi().addAll(giornoFC.list());
			Calendario.getInstance().getGiorniSettimanaliFestivi().addAll(giornoSFC.list());
			Calendario.getInstance().setInizioLezioni(new LocalDate(2014,12,01));
			Calendario.getInstance().setFineLezioni(new  LocalDate(2015,6,12));
			
			if(!existFileProperties()){
				initSysPropFile();
			}
			
			SystemPropertiesHandler.getInstance().loadProperties();
			
			
		} catch (PersistentException | IOException e) {
			// si potrebbe mettere un log 
			e.printStackTrace();
		}
	
    }
    
    
    /**
     * DEVELOP METHOD
     * @return
     */
    private boolean existFileProperties(){
    	
    	boolean exist;
    	FileInputStream propFileIn;
    	
    	exist = true;
    	try {
			propFileIn = new FileInputStream(SystemPropertiesHandler.getInstance().nomeFile);
			propFileIn.close();
		} catch (IOException e) {
			exist = false;
		}
    	
    	return exist;
    }
    
    
    /**
     * DEVELOP METHOD
     * @throws IOException
     */
    private static void initSysPropFile() throws IOException{
		//empty the file
		FileOutputStream propFileOut = null;
		Properties p = new Properties();
		try{
	         
			propFileOut = new FileOutputStream(SystemPropertiesHandler.getInstance().nomeFile);

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
		
		//set the properties 
		SystemPropertiesHandler.getInstance().storeProperty(VotoConverterFactory.getInstance().converterPropertyKey, VotoDecimalConverter.class.getSimpleName());
	}

}
