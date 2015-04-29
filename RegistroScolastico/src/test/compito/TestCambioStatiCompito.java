package test.compito;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;
import org.joda.time.LocalDate;

import controller.CompitoInClasseController;
import controller.DocenteController;
import sviluppo.Stampa;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoAnnullato;
import domain.model.compitoInClasse.CompitoChiuso;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoSvolto;

public class TestCambioStatiCompito {
	private static int idRegistroDocente = 1;
	private static int idClasse = 1;

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
		Map<Integer, Float> mapVotiGUI = new HashMap<Integer, Float>();
		
	try {
			
			try {
				controllerCompito = new CompitoInClasseController();
				docenteController = new DocenteController();
				
				compito = controllerCompito.creaCompito(idClasse, idRegistroDocente, docenteController.getIdDocenteProva());
				java.sql.Date sqlDate = new java.sql.Date(dataCompito.toDate().getTime());
				compito.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				
				Stampa.stampaln();
				
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito.getID(), CompitoSvolto.getInstance());
//				controllerCompito.svolgiCompito(compito.getID());
				Stampa.stampaln("ID del compito svolto: " + compito.getID());
				
				
				compito = controllerCompito.creaCompito(idClasse, idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				
				controllerCompito.eliminaCompito(idClasse, idRegistroDocente, compito.getID());
				Stampa.stampaln("ID del compito eliminato: " + compito.getID());
				
				compito2 = controllerCompito.creaCompito(idClasse, idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				compito2.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito2.getID(), CompitoSvolto.getInstance());
				Stampa.stampaln();
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito2.getID(), CompitoAnnullato.getInstance());
				Stampa.stampaln("ID del compito annullato: " + compito2.getID());
				
				Stampa.stampaln();
				compito3 = controllerCompito.creaCompito(idClasse, idRegistroDocente, docenteController.getIdDocenteProva());
				compito3.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito3.getID(), CompitoSvolto.getInstance());
				Stampa.stampaln();
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito3.getID(), CompitoAnnullato.getInstance());
				Stampa.stampaln();
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito3.getID(), CompitoSvolto.getInstance());
				Stampa.stampaln("ID del compito disannullato: " + compito3.getID());
				
				Stampa.stampaln();
				compito4 = controllerCompito.creaCompito(idClasse, idRegistroDocente, docenteController.getIdDocenteProva());
				compito4.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito4.getID(), CompitoSvolto.getInstance());
				mapVotiGUI.put(10, 5f);
				controllerCompito.inserisciVoti(idClasse, idRegistroDocente, compito4.getID(), mapVotiGUI);
				controllerCompito.cambiaStatoCompito(idClasse, idRegistroDocente, compito4.getID(), CompitoChiuso.getInstance());

				Stampa.stampaln("ID del compito chiuso: " + compito4.getID());
								
			}
			finally {
				service.RSPersistentManager.instance().disposePersistentManager();
			}
		}
		catch (Exception e) {
			e.printStackTrace();
		}

	}

}
