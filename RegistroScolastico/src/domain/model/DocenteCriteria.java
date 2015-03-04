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

public class DocenteCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression indirizzoId;
	public final AssociationExpression indirizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	public final DateExpression dataNascita;
	public final CollectionExpression registriDocente;
	
	public DocenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		indirizzoId = new IntegerExpression("indirizzo.ID", this);
		indirizzo = new AssociationExpression("indirizzo", this);
		nome = new StringExpression("nome", this);
		cognome = new StringExpression("cognome", this);
		codiceFiscale = new StringExpression("codiceFiscale", this);
		dataNascita = new DateExpression("dataNascita", this);
		registriDocente = new CollectionExpression("registriDocente", this);
	}
	
	public DocenteCriteria(PersistentSession session) {
		this(session.createCriteria(Docente.class));
	}
	
	public DocenteCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public RegistroDocenteCriteria createRegistriDocenteCriteria() {
		return new RegistroDocenteCriteria(createCriteria("registriDocente"));
	}
	
	public IndirizzoCriteria createIndirizzoCriteria() {
		return new IndirizzoCriteria(createCriteria("indirizzo"));
	}
	
	public Docente uniqueDocente() {
		return (Docente) super.uniqueResult();
	}
	
	public Docente[] listDocente() {
		java.util.List list = super.list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

