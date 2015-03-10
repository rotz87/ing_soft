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

public class UscitaAnticipataCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression appelloId;
	public final AssociationExpression appello;
	public final IntegerExpression permessoId;
	public final AssociationExpression permesso;
	
	public UscitaAnticipataCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		appelloId = new IntegerExpression("appello.ID", this);
		appello = new AssociationExpression("appello", this);
		permessoId = new IntegerExpression("permesso.ID", this);
		permesso = new AssociationExpression("permesso", this);
	}
	
	public UscitaAnticipataCriteria(PersistentSession session) {
		this(session.createCriteria(UscitaAnticipata.class));
	}
	
	public UscitaAnticipataCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public AppelloCriteria createAppelloCriteria() {
		return new AppelloCriteria(createCriteria("appello"));
	}
	
	public PermessoUscitaCriteria createPermessoCriteria() {
		return new PermessoUscitaCriteria(createCriteria("permesso"));
	}
	
	public UscitaAnticipata uniqueUscitaAnticipata() {
		return (UscitaAnticipata) super.uniqueResult();
	}
	
	public UscitaAnticipata[] listUscitaAnticipata() {
		java.util.List list = super.list();
		return (UscitaAnticipata[]) list.toArray(new UscitaAnticipata[list.size()]);
	}
}

