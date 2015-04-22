package test.compito;

import java.sql.Time;
import java.util.Collection;
import java.util.LinkedList;

import org.apache.cassandra.thrift.Cassandra.AsyncProcessor.system_add_column_family;
import org.joda.time.LocalDate;

import controller.CompitoInClasseController;
import controller.DocenteController;
import presenter.CompitoInClassePresenter;
import service.Stampa;
import domain.model.Argomento;
import domain.model.compitoInClasse.CompitoInClasse;
import domain.model.compitoInClasse.CompitoInClasseStateEnum;

public class TestChiudiCompito {
	private static int idRegistroDocente = 1;
	private static int idClasse = 1;
	

	public static void main(String[] args) {
		CompitoInClasseController controllerCompito;
		DocenteController docenteController;
//		CompitoInClasse compito;
		int idCompitoProva = 1;
		
		LocalDate dataCompito = new LocalDate(2014,12,16);
		Time oraInizio = Time.valueOf("10:0:0");
		Time oraFine = Time.valueOf("12:0:0");	
		Collection<Argomento> argomenti = new LinkedList<Argomento>();
		
	try {
			
			try {
				controllerCompito = new CompitoInClasseController();
//				docenteController = new DocenteController();
//				
//				compito = controllerCompito.creaCompito(idRegistroDocente, docenteController.getIdDocenteProva());
//				java.sql.Date sqlDate = new java.sql.Date(dataCompito.toDate().getTime());
//				compito.setInfo(sqlDate, oraInizio, oraFine, argomenti);
//				
//				
//				controllerCompito.changeState(compito.getID(), CompitoInClasseStateEnum.SVOLTO);
	
				controllerCompito.chiudiCompito(idClasse, idRegistroDocente, idCompitoProva);
				
//				CompitoInClassePresenter presenteCompito = new CompitoInClassePresenter();
//				
//				presenteCompito.eliminaCompito(3);
				
				
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
