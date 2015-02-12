/**
 * "Visual Paradigm: DO NOT MODIFY THIS FILE!"
 * 
 * This is an automatic generated file. It will be regenerated every time 
 * you generate persistence class.
 * 
 * Modifying its content may cause the program not work, or your work may lost.
 */

/**
 * Licensee: Universita degli Studi dell'Aquila
 * License Type: Academic
 */
package domain.model;

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class ClasseCriteria extends AbstractORMCriteria {
	public final IntegerExpression idClasse;
	public final IntegerExpression registroAssenzeId;
	public final AssociationExpression registroAssenze;
	public final StringExpression nome;
	public final CollectionExpression studenti;
	
	public ClasseCriteria(Criteria criteria) {
		super(criteria);
		idClasse = new IntegerExpression("idClasse", this);
		registroAssenzeId = new IntegerExpression("registroAssenze.ID", this);
		registroAssenze = new AssociationExpression("registroAssenze", this);
		nome = new StringExpression("nome", this);
		studenti = new CollectionExpression("studenti", this);
	}
	
	public ClasseCriteria(PersistentSession session) {
		this(session.createCriteria(Classe.class));
	}
	
	public ClasseCriteria() throws PersistentException {
		this(domain.model.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public RegistroAssenzeCriteria createRegistroAssenzeCriteria() {
		return new RegistroAssenzeCriteria(createCriteria("registroAssenze"));
	}
	
	public StudenteCriteria createStudentiCriteria() {
		return new StudenteCriteria(createCriteria("studenti"));
	}
	
	public Classe uniqueClasse() {
		return (Classe) super.uniqueResult();
	}
	
	public Classe[] listClasse() {
		java.util.List list = super.list();
		return (Classe[]) list.toArray(new Classe[list.size()]);
	}
}

