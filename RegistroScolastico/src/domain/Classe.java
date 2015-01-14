package domain;

import java.util.*;

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
	private RegistroAssenze registroAssenze;
	private Collection<Studente> studenti;
	
	public Classe(String nome){
		this.nome = nome;
		this.idClasse = Classe.generaId();
		this.studenti = new HashSet<Studente>();
	}
	
	public Classe(String nome, RegistroAssenze registroAssenze){
		this.nome = nome;
		this.idClasse = Classe.generaId();
		this.studenti = new TreeSet<Studente>();
		this.registroAssenze = registroAssenze;
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
	
	public RegistroAssenze getRegistroAssenze(){
		return this.registroAssenze;
	}
	
	public void setRegistroAssenze(RegistroAssenze registroAssenze){
		this.registroAssenze = registroAssenze;
	}
	
	public void setStudenti( Collection<Studente> studenti){
		this.studenti = studenti;
	}
	
	public Collection<Studente> getStudenti( ){
		return this.studenti;
	}

	private static long generaId(){
		contaId ++;
		return contaId;
		
	}
	
}
