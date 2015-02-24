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
import org.orm.criteria.AbstractORMCriteria;
import org.orm.criteria.AssociationExpression;
import org.orm.criteria.IntegerExpression;

public class RitardoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression permessoEntrataId;
	public final AssociationExpression permessoEntrata;
	public final IntegerExpression appelloId;
	public final AssociationExpression appello;
	
	public RitardoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		permessoEntrataId = new IntegerExpression("permessoEntrata.ID", this);
		permessoEntrata = new AssociationExpression("permessoEntrata", this);
		appelloId = new IntegerExpression("appello.ID", this);
		appello = new AssociationExpression("appello", this);
	}
	
	public RitardoCriteria(PersistentSession session) {
		this(session.createCriteria(Ritardo.class));
	}
	
	public RitardoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public PermessoEntrataCriteria createPermessoEntrataCriteria() {
		return new PermessoEntrataCriteria(createCriteria("permessoEntrata"));
	}
	
	public AppelloCriteria createAppelloCriteria() {
		return new AppelloCriteria(createCriteria("appello"));
	}
	
	public Ritardo uniqueRitardo() {
		return (Ritardo) super.uniqueResult();
	}
	
	public Ritardo[] listRitardo() {
		java.util.List list = super.list();
		return (Ritardo[]) list.toArray(new Ritardo[list.size()]);
	}
}

