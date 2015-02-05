package domain.model;

import java.util.Collection;
import java.util.HashSet;

import domain.persistent.Classe;
import domain.persistent.RegistroAssenze;
import domain.persistent.Studente;

/**
 * Conterrà il registro delle assenze.
 * Per il momento non verrà implementata in questo UC.
 * @author marco
 *
 */
public class MClasse  extends AModel<Classe>{
//	private String nome;
//	private long idClasse;
//	private static long contaId = 0;
//	private MRegistroAssenze registroAssenze;
//	private Collection<MStudente> studenti;
	
	public MClasse(String nome){
//		this.nome = nome;
//		this.idClasse = MClasse.generaId();
//		this.studenti = new HashSet<MStudente>();
		getPersistentModel().setNome(nome);
		getPersistentModel().setStudenti(new HashSet<Studente>());
	}
	
	public MClasse(String nome, MRegistroAssenze registroAssenze){
//		this.nome = nome;
//		this.idClasse = MClasse.generaId();
//		this.studenti = new HashSet<MStudente>();
//		this.registroAssenze = registroAssenze;
		this(nome);
		getPersistentModel().setRegistroAssenze(registroAssenze.getPersistentModel());
	}

//	public String getNome() {
//		return nome;
//	}


//	public void setNome(String nome) {
//		this.nome = nome;
//	}


//	public long getIdClasse() {
//		return idClasse;
//	}

//	public void setIdClasse(long idClasse) {
//		this.idClasse = idClasse;
//	} 
	
//	public MRegistroAssenze getRegistroAssenze(){
//		return this.registroAssenze;
//	}
	
//	public void setRegistroAssenze(MRegistroAssenze registroAssenze){
//		this.registroAssenze = registroAssenze;
//	}
	
//	public void setStudenti( Collection<MStudente> studenti){
//		this.studenti = studenti;
//	}
	
//	public Collection<MStudente> getStudenti( ){
//		return this.studenti;
//	}

//	private static long generaId(){
//		contaId ++;
//		return contaId;
//		
//	}
	
}
