package domain.implementor;

import java.util.Collection;

import org.joda.time.LocalDate;

import domain.model.Appello;
import domain.model.Calendario;
import domain.model.LibrettoAssenze;
import domain.model.RegistroAssenze;
import domain.model.Studente;

public class RegistroAssenzeImp {

	// private MapAppelli appelli;
	// private Map <StudenteImp, LibrettoAssenzeImp> librettiAssenze;

	/**
	 * Costrurrore senza parametri.
	 */
	public RegistroAssenzeImp() {

	}

	public void inizialize(RegistroAssenze registroAsenze) {

	}

	/**
	 * Riceve un vettore di studenti per cui segnare le assenze
	 * 
	 * @param idStudenti
	 */
	public void registraAssenze(RegistroAssenze registroAssenze,
			Collection<Studente> studenti) {

		Appello appelloCorrente = getAppelloOdierno(registroAssenze);
		if (!(appelloCorrente.getAssenzePrese())) {
			for (Studente studente : studenti) {
				registroAssenze.getLibrettiAssenze().get(studente.getID())
						.segnaAssenza(appelloCorrente);

			}
			appelloCorrente.setAssenzePrese(true);
		} else {
			throw new IllegalStateException("ASSENZE GIA' PRESE!");
		}
	}

	public Appello getAppelloOdierno(RegistroAssenze registroAssenze) {

		Appello appelloOdierno = null;
		LocalDate dataDiRiferimento = Calendario.getInstance().getDataOdierna();
		if (this.esisteAppello(registroAssenze, dataDiRiferimento)) {

			appelloOdierno = registroAssenze.getAppelli().get(
					Calendario.getInstance().getDaysFromZero(
							dataDiRiferimento.toDate()));

		} else {
			throw new IllegalStateException("APPELLO ODIERNO INESISTENTE!");
		}
		return appelloOdierno;
	}

	public void avviaAppello(RegistroAssenze registroAssenze) {
		Appello appello;
		LocalDate dataRif = Calendario.getInstance().getDataOdierna();

		if (!(this.esisteAppello(registroAssenze, dataRif))) {
			if (!Calendario.getInstance().isOggiFestivo()) {
				// DA RIVEDERE E CAMBIARE
				// TODO
				appello = new Appello(dataRif);
				registroAssenze.getAppelli().put(
						Calendario.getInstance().getDaysFromZero(
								dataRif.toDate()), appello);
			} else {
				throw new IllegalStateException(
						" APPELLO NON AVVIABILE PER OGGI ");
			}
		} else {
			throw new IllegalStateException(
					" -- ATTENZIONE L'APPELLO ODIERNO E' GIA' STATO AVVIATO -- ");
		}

	}

	/**
	 * Metodo per restituire un appello specifico, avendo la data serve per
	 * visualizzare un appello già fatto bottone visualizza dell'interfaccia
	 * 
	 * @param data
	 */
	public Appello getAppelloByData(RegistroAssenze registroAssenze,
			org.joda.time.LocalDate data) {
		return registroAssenze.getAppelli().get(data);
	}

	public boolean esisteAppello(RegistroAssenze registroAssenze,
			LocalDate dataDiRiferimento) {

		return registroAssenze.getAppelli().containsKey(
				Calendario.getInstance().getDaysFromZero(
						dataDiRiferimento.toDate()));

	}

	public boolean esisteAppello(RegistroAssenze registroAssenze,
			Appello appello) {

		return registroAssenze.getAppelli().containsValue(appello);

	}

	public boolean isAppelloOdiernoAvviabile(RegistroAssenze registroAssenze) {
		Boolean festivo, esiste, avviabile;

		avviabile = false;
		festivo = Calendario.getInstance().isOggiFestivo();
		if (!festivo) {
			esiste = registroAssenze.esisteAppello(Calendario.getInstance()
					.getDataOdierna());
			if (!esiste) {
				avviabile = true;
			}
		}

		return avviabile;
	}

	public LibrettoAssenze getLibretto(RegistroAssenze registroAssenze,
			Studente studente) {
		return registroAssenze.getLibrettiAssenze().get(studente.getID());
	}

}