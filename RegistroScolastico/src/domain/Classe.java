package domain;

/**
 * Conterrà il registro delle assenze.
 * Per il momento non verrà implementata in questo UC.
 * @author marco
 *
 */
public class Classe {
	private String nome;
	private long idClasse;
	private static long contaId = 0;
	
	public Classe(String nome){
		this.nome = nome;
		this.idClasse = Classe.generaId();
	}

	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public long getIdClasse() {
		return idClasse;
	}

	public void setIdClasse(long idClasse) {
		this.idClasse = idClasse;
	} 

	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
	
}
