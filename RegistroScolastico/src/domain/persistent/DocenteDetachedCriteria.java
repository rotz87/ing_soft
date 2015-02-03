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

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class DocenteDetachedCriteria extends AbstractORMDetachedCriteria {
	public final LongExpression idDocente;
	public final StringExpression nome;
	public final StringExpression cognome;
	public final CollectionExpression classi;
	
	public DocenteDetachedCriteria() {
		super(domain.persistent.Docente.class, domain.persistent.DocenteCriteria.class);
		idDocente = new LongExpression("idDocente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
	}
	
	public DocenteDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.persistent.DocenteCriteria.class);
		idDocente = new LongExpression("idDocente", this.getDetachedCriteria());
		nome = new StringExpression("nome", this.getDetachedCriteria());
		cognome = new StringExpression("cognome", this.getDetachedCriteria());
		classi = new CollectionExpression("classi", this.getDetachedCriteria());
	}
	
	public ClasseDetachedCriteria createClassiCriteria() {
		return new ClasseDetachedCriteria(createCriteria("classi"));
	}
	
	public Docente uniqueDocente(PersistentSession session) {
		return (Docente) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public Docente[] listDocente(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (Docente[]) list.toArray(new Docente[list.size()]);
	}
}

