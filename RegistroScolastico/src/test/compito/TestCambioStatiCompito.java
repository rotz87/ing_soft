package test.compito;

import java.sql.Time;
import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;
import org.joda.time.LocalDate;

import service.Stampa;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;

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
		Map<Integer, Byte> mapVotiGUI = new HashMap<Integer, Byte>();
		
	try {
			
			try {
				controllerCompito = new CompitoInClasseController();
				docenteController = new DocenteController();
				
				compito = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				java.sql.Date sqlDate = new java.sql.Date(dataCompito.toDate().getTime());
				compito.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				
				Stampa.stampaln();
				
				controllerCompito.changeState(compito.getID(), CompitoInClasseStateEnum.SVOLTO);
//				controllerCompito.svolgiCompito(compito.getID());
				Stampa.stampaln("ID del compito svolto: " + compito.getID());
				
				
				compito = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				
				controllerCompito.eliminaCompito(compito.getID());
				Stampa.stampaln("ID del compito eliminato: " + compito.getID());
				
				compito2 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				
				Stampa.stampaln();
				
				compito2.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.changeState(compito2.getID(), CompitoInClasseStateEnum.SVOLTO);
				Stampa.stampaln();
				controllerCompito.changeState(compito2.getID(), CompitoInClasseStateEnum.ANNULLATO);
				Stampa.stampaln("ID del compito annullato: " + compito2.getID());
				
				Stampa.stampaln();
				compito3 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				compito3.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.changeState(compito3.getID(), CompitoInClasseStateEnum.SVOLTO);;
				Stampa.stampaln();
				controllerCompito.changeState(compito3.getID(), CompitoInClasseStateEnum.ANNULLATO);
				Stampa.stampaln();
				controllerCompito.changeState(compito3.getID(), CompitoInClasseStateEnum.SVOLTO);
				Stampa.stampaln("ID del compito disannullato: " + compito3.getID());
				
				Stampa.stampaln();
				compito4 = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
				compito4.setInfo(sqlDate, oraInizio, oraFine, argomenti);
				controllerCompito.changeState(compito4.getID(), CompitoInClasseStateEnum.SVOLTO);
				mapVotiGUI.put(10, new Byte((byte) 5));
				controllerCompito.inserisciVoti(compito4.getID(), mapVotiGUI);
				controllerCompito.changeState(compito4.getID(), CompitoInClasseStateEnum.CHIUSO);

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
