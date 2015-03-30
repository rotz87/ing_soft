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

public class RitardoCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _permessoId;
	public final AssociationExpression _permesso;
	public final IntegerExpression _appelloId;
	public final AssociationExpression _appello;
	
	public RitardoCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_permessoId = new IntegerExpression("_permesso.ID", this);
		_permesso = new AssociationExpression("_permesso", this);
		_appelloId = new IntegerExpression("_appello.ID", this);
		_appello = new AssociationExpression("_appello", this);
	}
	
	public RitardoCriteria(PersistentSession session) {
		this(session.createCriteria(Ritardo.class));
	}
	
	public RitardoCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public PermessoEntrataCriteria create_permessoCriteria() {
		return new PermessoEntrataCriteria(createCriteria("_permesso"));
	}
	
	public AppelloCriteria create_appelloCriteria() {
		return new AppelloCriteria(createCriteria("_appello"));
	}
	
	public Ritardo uniqueRitardo() {
		return (Ritardo) super.uniqueResult();
	}
	
	public Ritardo[] listRitardo() {
		java.util.List list = super.list();
		return (Ritardo[]) list.toArray(new Ritardo[list.size()]);
	}
}

