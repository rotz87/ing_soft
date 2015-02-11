package domain.model;

import java.util.Collection;
import java.util.HashSet;

import domain.implementor.ClasseImp;

/**
 * Conterrà il registro delle assenze.
 * Per il momento non verrà implementata in questo UC.
 * @author marco
 *
 */
public class Classe {
	private String nome;
	private long idClasse;
	private RegistroAssenze registroAssenze;
	private Collection<Studente> studenti;
	private ClasseImp implementor;
	
	public Classe(String nome){
		implementor = new ClasseImp();
		implementor.inizialize(this, nome);
	}
	
	public Classe(String nome, RegistroAssenze registroAssenze){
		implementor = new ClasseImp();
		implementor.inizialize(this, nome, registroAssenze);
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
	
}
