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
	public final IntegerExpression _giustificazioneId;
	public final AssociationExpression _giustificazione;
	public final CollectionExpression _appelli;
	
	public AssenzaDetachedCriteria() {
		super(domain.model.Assenza.class, domain.model.AssenzaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giustificazioneId = new IntegerExpression("_giustificazione.ID", this.getDetachedCriteria());
		_giustificazione = new AssociationExpression("_giustificazione", this.getDetachedCriteria());
		_appelli = new CollectionExpression("_appelli", this.getDetachedCriteria());
	}
	
	public AssenzaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.AssenzaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_giustificazioneId = new IntegerExpression("_giustificazione.ID", this.getDetachedCriteria());
		_giustificazione = new AssociationExpression("_giustificazione", this.getDetachedCriteria());
		_appelli = new CollectionExpression("_appelli", this.getDetachedCriteria());
	}
	
	public GiustificazioneDetachedCriteria create_giustificazioneCriteria() {
		return new GiustificazioneDetachedCriteria(createCriteria("_giustificazione"));
	}
	
	public AppelloDetachedCriteria create_appelliCriteria() {
		return new AppelloDetachedCriteria(createCriteria("_appelli"));
	}
	
	public Assenza uniqueAssenza(PersistentSession session) {
		return (Assenza) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Assenza[] listAssenza(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Assenza[]) list.toArray(new Assenza[list.size()]);
	}
}

