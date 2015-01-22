package domain.model;

public class Studente {
	
	private long id;
	private static long contaId = 0;
	private String nome;
	private String cognome;
	private Indirizzo indrizzo;
	private String codiceFiscale;
	
	public Studente(String nome, String cognome){
		this.id = Studente.generaId();
		this.nome = nome;
		this.cognome = cognome;
//		System.out.println("<><><><> costruisco lo studente: " + this.nome +", "+this.cognome+ " con id: "+this.id);
	}
	
	
	
	public Studente(long id, String nome, String cognome, Indirizzo indrizzo, String codiceFiscale) {
		this.id = Studente.generaId();
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

	public Indirizzo getIndrizzo() {
		return indrizzo;
	}

	public void setIndrizzo(Indirizzo indrizzo) {
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