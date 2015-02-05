package domain.model;

import domain.persistent.Studente;

public class MStudente extends AModel<Studente> {
	
//	private long id;
//	private static long contaId = 0;
//	private String nome;
//	private String cognome;
//	private MIndirizzo indrizzo;
//	private String codiceFiscale;
	
	public MStudente(String nome, String cognome){
//		this.id = MStudente.generaId();
//		this.nome = nome;
//		this.cognome = cognome;
		getPersistentModel().setNome(nome);
		getPersistentModel().setCognome(cognome);
//		Stempa.stampaln("<><><><> costruisco lo studente: " + this.nome +", "+this.cognome+ " con id: "+this.id);
	}
	
	
	
	public MStudente(long id, String nome, String cognome, MIndirizzo indrizzo, String codiceFiscale) {

		this(nome, cognome);
		
		getPersistentModel().setIndrizzo(indrizzo.getPersistentModel());
		getPersistentModel().setCodiceFiscale(codiceFiscale);
	}



//	public long getId() {
//		return id;
//	}
//
//	public void setId(long id) {
//		this.id = id;
//	}
//	
//	public String getNome(){
//		return this.nome;
//	}
//
//	public String getCognome() {
//		return cognome;
//	}

//	public void setCognome(String cognome) {
//		this.cognome = cognome;
//	}
//
//	public MIndirizzo getIndrizzo() {
//		return indrizzo;
//	}
//
//	public void setIndrizzo(MIndirizzo indrizzo) {
//		this.indrizzo = indrizzo;
//	}
//
//	public String getCodiceFiscale() {
//		return codiceFiscale;
//	}
//
//	public void setCodiceFiscale(String codiceFiscale) {
//		this.codiceFiscale = codiceFiscale;
//	}

//	public void setNome(String nome) {
//		this.nome = nome;
//	}
//	
//	private static long generaId(){
//		contaId ++;
//		return contaId;
//		
//	}


	
}