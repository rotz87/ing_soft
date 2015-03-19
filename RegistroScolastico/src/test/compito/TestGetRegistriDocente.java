package test.compito;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

import presenter.ClassePresenter;
import service.Stampa;
import domain.controller.ClasseController;
import domain.controller.CompitoInClasseController;
import domain.controller.DocenteController;
import domain.model.RegistroDocente;
import domain.model.Studente;
import domain.model.Voto;

public class TestGetRegistriDocente {

	public static void main(String[] args) {
		try {
			try {
				DocenteController docenteController;
				int idDocente;
				int idClasse;
				ClasseController classeController;
				Collection<RegistroDocente> registri;
				
				classeController = new ClasseController();
				docenteController = new DocenteController();
				idClasse = 1;//<----------------------------------------------------
				idDocente = docenteController.getIdDocenteProva();
				
				registri = classeController.getRegistriDocente(idClasse, idDocente);
				
				for(RegistroDocente regDoc : registri){
					Stampa.stampaln("____________________________________________________");
					Stampa.stampaln("Registro Docente ID = "+regDoc.getID()+" MAteria = " + regDoc.getMateria().getNome());
				}
				
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
