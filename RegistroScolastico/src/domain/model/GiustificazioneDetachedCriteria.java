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

public class GiustificazioneDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final BooleanExpression confermata;
	
	public GiustificazioneDetachedCriteria() {
		super(domain.model.Giustificazione.class, domain.model.GiustificazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		confermata = new BooleanExpression("confermata", this.getDetachedCriteria());
	}
	
	public GiustificazioneDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.GiustificazioneCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		confermata = new BooleanExpression("confermata", this.getDetachedCriteria());
	}
	
	public Giustificazione uniqueGiustificazione(PersistentSession session) {
		return (Giustificazione) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Giustificazione[] listGiustificazione(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Giustificazione[]) list.toArray(new Giustificazione[list.size()]);
	}
}

