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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class LibrettoAssenzeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final CollectionExpression giustificate;
	public final CollectionExpression nonGiustificate;
	public final CollectionExpression ritardi;
	public final CollectionExpression uscite;
	
	public LibrettoAssenzeDetachedCriteria() {
		super(domain.model.LibrettoAssenze.class, domain.model.LibrettoAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giustificate = new CollectionExpression("giustificate", this.getDetachedCriteria());
		nonGiustificate = new CollectionExpression("nonGiustificate", this.getDetachedCriteria());
		ritardi = new CollectionExpression("ritardi", this.getDetachedCriteria());
		uscite = new CollectionExpression("uscite", this.getDetachedCriteria());
	}
	
	public LibrettoAssenzeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.LibrettoAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giustificate = new CollectionExpression("giustificate", this.getDetachedCriteria());
		nonGiustificate = new CollectionExpression("nonGiustificate", this.getDetachedCriteria());
		ritardi = new CollectionExpression("ritardi", this.getDetachedCriteria());
		uscite = new CollectionExpression("uscite", this.getDetachedCriteria());
	}
	
	public AssenzaDetachedCriteria createGiustificateCriteria() {
		return new AssenzaDetachedCriteria(createCriteria("giustificate"));
	}
	
	public AssenzaDetachedCriteria createNonGiustificateCriteria() {
		return new AssenzaDetachedCriteria(createCriteria("nonGiustificate"));
	}
	
	public RitardoDetachedCriteria createRitardiCriteria() {
		return new RitardoDetachedCriteria(createCriteria("ritardi"));
	}
	
	public UscitaAnticipataDetachedCriteria createUsciteCriteria() {
		return new UscitaAnticipataDetachedCriteria(createCriteria("uscite"));
	}
	
	public LibrettoAssenze uniqueLibrettoAssenze(PersistentSession session) {
		return (LibrettoAssenze) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LibrettoAssenze[] listLibrettoAssenze(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LibrettoAssenze[]) list.toArray(new LibrettoAssenze[list.size()]);
	}
}

