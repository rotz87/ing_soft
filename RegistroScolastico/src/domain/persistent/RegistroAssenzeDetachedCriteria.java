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

public class RegistroAssenzeDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final LongExpression appelloOdiernoId;
	public final AssociationExpression appelloOdierno;
	public final CollectionExpression librettiAssenze;
	public final CollectionExpression appelli;
	
	public RegistroAssenzeDetachedCriteria() {
		super(domain.persistent.RegistroAssenze.class, domain.persistent.RegistroAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		appelloOdiernoId = new LongExpression("appelloOdierno.idAppello", this.getDetachedCriteria());
		appelloOdierno = new AssociationExpression("appelloOdierno", this.getDetachedCriteria());
		librettiAssenze = new CollectionExpression("librettiAssenze", this.getDetachedCriteria());
		appelli = new CollectionExpression("appelli", this.getDetachedCriteria());
	}
	
	public RegistroAssenzeDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.RegistroAssenzeCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		appelloOdiernoId = new LongExpression("appelloOdierno.idAppello", this.getDetachedCriteria());
		appelloOdierno = new AssociationExpression("appelloOdierno", this.getDetachedCriteria());
		librettiAssenze = new CollectionExpression("librettiAssenze", this.getDetachedCriteria());
		appelli = new CollectionExpression("appelli", this.getDetachedCriteria());
	}
	
	public AppelloDetachedCriteria createAppelloOdiernoCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appelloOdierno"));
	}
	
	public LibrettoAssenzeDetachedCriteria createLibrettiAssenzeCriteria() {
		return new LibrettoAssenzeDetachedCriteria(createCriteria("librettiAssenze"));
	}
	
	public AppelloDetachedCriteria createAppelliCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appelli"));
	}
	
	public RegistroAssenze uniqueRegistroAssenze(PersistentSession session) {
		return (RegistroAssenze) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public RegistroAssenze[] listRegistroAssenze(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (RegistroAssenze[]) list.toArray(new RegistroAssenze[list.size()]);
	}
}

