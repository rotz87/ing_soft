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

public class StudenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression indirizzoId;
	public final AssociationExpression indirizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	
	public StudenteDetachedCriteria() {
		super(domain.model.Studente.class, domain.model.StudenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
	}
	
	public StudenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.StudenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
	}
	
	public IndirizzoDetachedCriteria createIndirizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("indirizzo"));
	}
	
	public Studente uniqueStudente(PersistentSession session) {
		return (Studente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Studente[] listStudente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Studente[]) list.toArray(new Studente[list.size()]);
	}
}

