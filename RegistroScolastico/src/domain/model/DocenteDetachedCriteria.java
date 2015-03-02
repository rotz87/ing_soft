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

public class DocenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression indirizzoId;
	public final AssociationExpression indirizzo;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final StringExpression codiceFiscale;
	public final DateExpression dataNascita;
	public final CollectionExpression classi;
	
	public DocenteDetachedCriteria() {
		super(domain.model.Docente.class, domain.model.DocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
	}
	
	public DocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.DocenteCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		indirizzoId = new IntegerExpression("indirizzo.ID", this.getDetachedCriteria());
		indirizzo = new AssociationExpression("indirizzo", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		codiceFiscale = new StringExpression("codiceFiscale", this.getDetachedCriteria());
		dataNascita = new DateExpression("dataNascita", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria createClassiCriteria() {
		return new ClasseDetachedCriteria(createCriteria("classi"));
	}
	
	public IndirizzoDetachedCriteria createIndirizzoCriteria() {
		return new IndirizzoDetachedCriteria(createCriteria("indirizzo"));
	}
	
	public Docente uniqueDocente(PersistentSession session) {
		return (Docente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Docente[] listDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

