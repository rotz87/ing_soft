package test.compito;

import java.sql.Time;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;
import org.joda.time.LocalDate;

import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;

public class TestCambioStatiCompito {
	private static int idRegistroDocente = 1;

	public static void main(String[] args) {
		CompitoInClasseController controllerCompito;
		DocenteController docenteController;
		CompitoInClasse compito;
		CompitoInClasse compito2;
		CompitoInClasse compito3;
		CompitoInClasse compito4;
		
		LocalDate dataCompito = new LocalDate(2014,12,16);
//		Time oraInizio = new Time(10, 0, 0);
//		Time oraFine = new Time(12, 0, 0);
		Time oraInizio = Time.valueOf("10:0:0");
		Time oraFine = Time.valueOf("12:0:0");	
		Collection<Argomento> argomenti = new LinkedList<Argomento>();
		
	try {
			
			try {
				controllerCompito = new CompitoInClasseController();
				docenteController = new DocenteController();
				
				compito = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				java.sql.Date sqlDate = new java.sql.Date(dataCompito.toDate().getTime());
				compito.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				
				Stampa.stampaln();
				
				
				controllerCompito.svolgiCompito(compito.getID());
				Stampa.stampaln("ID del compito svolto: " + compito.getID());
				
				
				compito = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				
				controllerCompito.eliminaCompito(compito.getID());
				Stampa.stampaln("ID del compito eliminato: " + compito.getID());
				
				compito2 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				compito2.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.svolgiCompito(compito2.getID());
				Stampa.stampaln();
				controllerCompito.annullaCompito(compito2.getID());
				Stampa.stampaln("ID del compito annullato: " + compito2.getID());
				
				Stampa.stampaln();
				compito3 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				compito3.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.svolgiCompito(compito3.getID());
				Stampa.stampaln();
				controllerCompito.annullaCompito(compito3.getID());
				Stampa.stampaln();
				controllerCompito.disannullaCompito(compito3.getID());
				Stampa.stampaln("ID del compito disannullato: " + compito3.getID());
				
				Stampa.stampaln();
				compito4 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				compito4.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.svolgiCompito(compito4.getID());
				controllerCompito.chiudiCompito(compito4.getID());

				Stampa.stampaln("ID del compito chiuso: " + compito4.getID());
								
			}
			finally {
				domain.model.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
