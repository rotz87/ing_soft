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
	public final CollectionExpression _giustificate;
	public final CollectionExpression _nonGiustificate;
	public final CollectionExpression _ritardi;
	public final CollectionExpression _uscite;
	
	public LibrettoAssenzeDetachedCriteria() {
		super(domain.model.LibrettoAssenze.class, domain.model.LibrettoAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giustificate = new CollectionExpression("_giustificate", this.getDetachedCriteria());
		_nonGiustificate = new CollectionExpression("_nonGiustificate", this.getDetachedCriteria());
		_ritardi = new CollectionExpression("_ritardi", this.getDetachedCriteria());
		_uscite = new CollectionExpression("_uscite", this.getDetachedCriteria());
	}
	
	public LibrettoAssenzeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.LibrettoAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giustificate = new CollectionExpression("_giustificate", this.getDetachedCriteria());
		_nonGiustificate = new CollectionExpression("_nonGiustificate", this.getDetachedCriteria());
		_ritardi = new CollectionExpression("_ritardi", this.getDetachedCriteria());
		_uscite = new CollectionExpression("_uscite", this.getDetachedCriteria());
	}
	
	public AssenzaDetachedCriteria create_giustificateCriteria() {
		return new AssenzaDetachedCriteria(createCriteria("_giustificate"));
	}
	
	public AssenzaDetachedCriteria create_nonGiustificateCriteria() {
		return new AssenzaDetachedCriteria(createCriteria("_nonGiustificate"));
	}
	
	public RitardoDetachedCriteria create_ritardiCriteria() {
		return new RitardoDetachedCriteria(createCriteria("_ritardi"));
	}
	
	public UscitaAnticipataDetachedCriteria create_usciteCriteria() {
		return new UscitaAnticipataDetachedCriteria(createCriteria("_uscite"));
	}
	
	public LibrettoAssenze uniqueLibrettoAssenze(PersistentSession session) {
		return (LibrettoAssenze) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public LibrettoAssenze[] listLibrettoAssenze(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (LibrettoAssenze[]) list.toArray(new LibrettoAssenze[list.size()]);
	}
}

