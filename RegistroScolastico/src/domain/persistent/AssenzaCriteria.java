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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class AssenzaCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression giustificazioneId;
	public final AssociationExpression giustificazione;
	public final CollectionExpression appello;
	public final CollectionExpression appelliAssenza;
	public final CollectionExpression appelli;
	
	public AssenzaCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		giustificazioneId = new IntegerExpression("giustificazione.ID", this);
		giustificazione = new AssociationExpression("giustificazione", this);
		appello = new CollectionExpression("appello", this);
		appelliAssenza = new CollectionExpression("appelliAssenza", this);
		appelli = new CollectionExpression("appelli", this);
	}
	
	public AssenzaCriteria(PersistentSession session) {
		this(session.createCriteria(Assenza.class));
	}
	
	public AssenzaCriteria() throws PersistentException {
		this(domain.persistent.RegistroScolasticoPersistentManager.instance().getSession());
	}
	
	public GiustificazioneCriteria createGiustificazioneCriteria() {
		return new GiustificazioneCriteria(createCriteria("giustificazione"));
	}
	
	public AppelloCriteria createAppelloCriteria() {
		return new AppelloCriteria(createCriteria("appello"));
	}
	
	public AppelloCriteria createAppelliAssenzaCriteria() {
		return new AppelloCriteria(createCriteria("appelliAssenza"));
	}
	
	public AppelloCriteria createAppelliCriteria() {
		return new AppelloCriteria(createCriteria("appelli"));
	}
	
	public Assenza uniqueAssenza() {
		return (Assenza) super.uniqueResult();
	}
	
	public Assenza[] listAssenza() {
		java.util.List list = super.list();
		return (Assenza[]) list.toArray(new Assenza[list.size()]);
	}
}

