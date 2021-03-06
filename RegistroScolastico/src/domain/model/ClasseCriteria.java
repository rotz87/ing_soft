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
	public final IntegerExpression ID;
	public final IntegerExpression _registroAppelliId;
	public final AssociationExpression _registroAppelli;
	public final StringExpression _nome;
	public final CollectionExpression _studenti;
	
	public ClasseCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_registroAppelliId = new IntegerExpression("_registroAppelli.ID", this);
		_registroAppelli = new AssociationExpression("_registroAppelli", this);
		_nome = new StringExpression("_nome", this);
		_studenti = new CollectionExpression("_studenti", this);
	}
	
	public ClasseCriteria(PersistentSession session) {
		this(session.createCriteria(Classe.class));
	}
	
	public ClasseCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public RegistroAppelliCriteria create_registroAppelliCriteria() {
		return new RegistroAppelliCriteria(createCriteria("_registroAppelli"));
	}
	
	public StudenteCriteria create_studentiCriteria() {
		return new StudenteCriteria(createCriteria("_studenti"));
	}
	
	public Classe uniqueClasse() {
		return (Classe) super.uniqueResult();
	}
	
	public Classe[] listClasse() {
		java.util.List list = super.list();
		return (Classe[]) list.toArray(new Classe[list.size()]);
	}
}

