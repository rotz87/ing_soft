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

public class PersonaDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _indirizzoId;
	public final AssociationExpression _indirizzo;
	public final StringExpression _nome;
	public final StringExpression _cognome;
	public final StringExpression _codiceFiscale;
	public final DateExpression _dataNascita;
	
	public PersonaDetachedCriteria() {
		super(domain.model.Persona.class, domain.model.PersonaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this.getDetachedCriteria());
		_indirizzo = new AssociationExpression("_indirizzo", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_codiceFiscale = new StringExpression("_codiceFiscale", this.getDetachedCriteria());
		_dataNascita = new DateExpression("_dataNascita", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.PersonaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_indirizzoId = new IntegerExpression("_indirizzo.ID", this.getDetachedCriteria());
		_indirizzo = new AssociationExpression("_indirizzo", this.getDetachedCriteria());
		_nome = new StringExpression("_nome", this.getDetachedCriteria());
		_cognome = new StringExpression("_cognome", this.getDetachedCriteria());
		_codiceFiscale = new StringExpression("_codiceFiscale", this.getDetachedCriteria());
		_dataNascita = new DateExpression("_dataNascita", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria create_indirizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("_indirizzo"));
	}
	
	public Persona uniquePersona(PersistentSession session) {
		return (Persona) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Persona[] listPersona(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

