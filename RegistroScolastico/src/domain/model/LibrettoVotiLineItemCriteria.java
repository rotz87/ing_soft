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

public class LibrettoVotiLineItemCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _votoId;
	public final AssociationExpression _voto;
	public final IntegerExpression _compitoInClasseId;
	public final AssociationExpression _compitoInClasse;
	
	public LibrettoVotiLineItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_votoId = new IntegerExpression("_voto.ID", this);
		_voto = new AssociationExpression("_voto", this);
		_compitoInClasseId = new IntegerExpression("_compitoInClasse.ID", this);
		_compitoInClasse = new AssociationExpression("_compitoInClasse", this);
	}
	
	public LibrettoVotiLineItemCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoVotiLineItem.class));
	}
	
	public LibrettoVotiLineItemCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public VotoCriteria create_votoCriteria() {
		return new VotoCriteria(createCriteria("_voto"));
	}
	
	public domain.model.compitoInClasse.CompitoInClasseCriteria create_compitoInClasseCriteria() {
		return new domain.model.compitoInClasse.CompitoInClasseCriteria(createCriteria("_compitoInClasse"));
	}
	
	public LibrettoVotiLineItem uniqueLibrettoVotiLineItem() {
		return (LibrettoVotiLineItem) super.uniqueResult();
	}
	
	public LibrettoVotiLineItem[] listLibrettoVotiLineItem() {
		java.util.List list = super.list();
		return (LibrettoVotiLineItem[]) list.toArray(new LibrettoVotiLineItem[list.size()]);
	}
}

