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
	public final IntegerExpression votoId;
	public final AssociationExpression voto;
	public final IntegerExpression compitoInClasseId;
	public final AssociationExpression compitoInClasse;
	
	public LibrettoVotiLineItemCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		votoId = new IntegerExpression("voto.ID", this);
		voto = new AssociationExpression("voto", this);
		compitoInClasseId = new IntegerExpression("compitoInClasse.ID", this);
		compitoInClasse = new AssociationExpression("compitoInClasse", this);
	}
	
	public LibrettoVotiLineItemCriteria(PersistentSession session) {
		this(session.createCriteria(LibrettoVotiLineItem.class));
	}
	
	public LibrettoVotiLineItemCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public VotoCriteria createVotoCriteria() {
		return new VotoCriteria(createCriteria("voto"));
	}
	
	public CompitoInClasseCriteria createCompitoInClasseCriteria() {
		return new CompitoInClasseCriteria(createCriteria("compitoInClasse"));
	}
	
	public LibrettoVotiLineItem uniqueLibrettoVotiLineItem() {
		return (LibrettoVotiLineItem) super.uniqueResult();
	}
	
	public LibrettoVotiLineItem[] listLibrettoVotiLineItem() {
		java.util.List list = super.list();
		return (LibrettoVotiLineItem[]) list.toArray(new LibrettoVotiLineItem[list.size()]);
	}
}

