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

public class AssenzaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression giustificazioneId;
	public final AssociationExpression giustificazione;
	public final CollectionExpression appelliAssenza;
	
	public AssenzaDetachedCriteria() {
		super(domain.model.Assenza.class, domain.model.AssenzaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giustificazioneId = new IntegerExpression("giustificazione.ID", this.getDetachedCriteria());
		giustificazione = new AssociationExpression("giustificazione", this.getDetachedCriteria());
		appelliAssenza = new CollectionExpression("appelliAssenza", this.getDetachedCriteria());
	}
	
	public AssenzaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.AssenzaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		giustificazioneId = new IntegerExpression("giustificazione.ID", this.getDetachedCriteria());
		giustificazione = new AssociationExpression("giustificazione", this.getDetachedCriteria());
		appelliAssenza = new CollectionExpression("appelliAssenza", this.getDetachedCriteria());
	}
	
	public GiustificazioneDetachedCriteria createGiustificazioneCriteria() {
		return new GiustificazioneDetachedCriteria(createCriteria("giustificazione"));
	}
	
	public AppelloDetachedCriteria createAppelliAssenzaCriteria() {
		return new AppelloDetachedCriteria(createCriteria("appelliAssenza"));
	}
	
	public Assenza uniqueAssenza(PersistentSession session) {
		return (Assenza) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Assenza[] listAssenza(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Assenza[]) list.toArray(new Assenza[list.size()]);
	}
}

