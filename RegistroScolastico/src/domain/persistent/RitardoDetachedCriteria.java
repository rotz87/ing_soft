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
package domain.persistent;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class RitardoDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression permessoEntrataId;
	public final AssociationExpression permessoEntrata;
	public final IntegerExpression permessoId;
	public final AssociationExpression permesso;
	public final LongExpression appelloId;
	public final AssociationExpression appello;
	
	public RitardoDetachedCriteria() {
		super(domain.persistent.Ritardo.class, domain.persistent.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permessoEntrataId = new IntegerExpression("permessoEntrata.ID", this.getDetachedCriteria());
		permessoEntrata = new AssociationExpression("permessoEntrata", this.getDetachedCriteria());
		permessoId = new IntegerExpression("permesso.ID", this.getDetachedCriteria());
		permesso = new AssociationExpression("permesso", this.getDetachedCriteria());
		appelloId = new LongExpression("appello.idAppello", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
	}
	
	public RitardoDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.RitardoCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		permessoEntrataId = new IntegerExpression("permessoEntrata.ID", this.getDetachedCriteria());
		permessoEntrata = new AssociationExpression("permessoEntrata", this.getDetachedCriteria());
		permessoId = new IntegerExpression("permesso.ID", this.getDetachedCriteria());
		permesso = new AssociationExpression("permesso", this.getDetachedCriteria());
		appelloId = new LongExpression("appello.idAppello", this.getDetachedCriteria());
		appello = new AssociationExpression("appello", this.getDetachedCriteria());
	}
	
	public PermessoEntrataDetachedCriteria createPermessoEntrataCriteria() {
		return new PermessoEntrataDetachedCriteria(createCriteria("permessoEntrata"));
	}
	
	public PermessoEntrataDetachedCriteria createPermessoCriteria() {
		return new PermessoEntrataDetachedCriteria(createCriteria("permesso"));
	}
	
	public AppelloDetachedCriteria createAppelloCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appello"));
	}
	
	public Ritardo uniqueRitardo(PersistentSession session) {
		return (Ritardo) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Ritardo[] listRitardo(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Ritardo[]) list.toArray(new Ritardo[list.size()]);
	}
}

