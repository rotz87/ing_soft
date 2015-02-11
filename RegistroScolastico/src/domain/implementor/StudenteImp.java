package domain.implementor;

public class StudenteImp {
	
	private long id;
	private static long contaId = 0;
	private String nome;
	private String cognome;
	private IndirizzoImp indrizzo;
	private String codiceFiscale;
	
	public StudenteImp(String nome, String cognome){
		this.id = StudenteImp.generaId();
		this.nome = nome;
		this.cognome = cognome;
//		Stempa.stampaln("<><><><> costruisco lo studente: " + this.nome +", "+this.cognome+ " con id: "+this.id);
	}
	
	
	
	public StudenteImp(long id, String nome, String cognome, IndirizzoImp indrizzo, String codiceFiscale) {
		this.id = StudenteImp.generaId();
//		setId(id);
		setNome(nome);
		setCognome(cognome);
		setIndrizzo(indrizzo);
		setCodiceFiscale(codiceFiscale);
	}



	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}
	
	public String getNome(){
		return this.nome;
	}

	public String getCognome() {
		return cognome;
	}

	public void setCognome(String cognome) {
		this.cognome = cognome;
	}

	public IndirizzoImp getIndrizzo() {
		return indrizzo;
	}

	public void setIndrizzo(IndirizzoImp indrizzo) {
		this.indrizzo = indrizzo;
	}

	public String getCodiceFiscale() {
		return codiceFiscale;
	}

	public void setCodiceFiscale(String codiceFiscale) {
		this.codiceFiscale = codiceFiscale;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
	
	private static long generaId(){
		contaId ++;
		return contaId;
		
	}


	
}