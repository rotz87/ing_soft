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
	public final IntegerExpression indirizzoId;
	public final AssociationExpression indirizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	public final DateExpression dataNascita;
	
	public PersonaDetachedCriteria() {
		super(domain.model.Persona.class, domain.model.PersonaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
	}
	
	public PersonaDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.PersonaCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria createIndirizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("indirizzo"));
	}
	
	public Persona uniquePersona(PersistentSession session) {
		return (Persona) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Persona[] listPersona(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Persona[]) list.toArray(new Persona[list.size()]);
	}
}

