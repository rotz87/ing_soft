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
	public final IntegerExpression _indirizzoId;
	public final AssociationExpression _indirizzo;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _codiceFiscale;
	public final DateExpression _dataNascita;
	public final CollectionExpression _registriDocente;
	
	public DocenteCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this);
		_indirizzo = new AssociationExpression("_indirizzo", this);
		_nome = new StringExpression("_nome", this);
		_cognome = new StringExpression("_cognome", this);
		_codiceFiscale = new StringExpression("_codiceFiscale", this);
		_dataNascita = new DateExpression("_dataNascita", this);
		_registriDocente = new CollectionExpression("_registriDocente", this);
	}
	
	public DocenteCriteria(PersistentSession session) {
		this(session.createCriteria(Docente.class));
	}
	
	public DocenteCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public RegistroDocenteCriteria create_registriDocenteCriteria() {
		return new RegistroDocenteCriteria(createCriteria("_registriDocente"));
	}
	
	public IndirizzoCriteria create_indirizzoCriteria() {
		return new IndirizzoCriteria(createCriteria("_indirizzo"));
	}
	
	public Docente uniqueDocente() {
		return (Docente) super.uniqueResult();
	}
	
	public Docente[] listDocente() {
		java.util.List list = super.list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

