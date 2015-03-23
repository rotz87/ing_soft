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

public class CompitoInClasseDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression insegnamentoId;
	public final AssociationExpression insegnamento;
	public final DateExpression data;
	public final TimeExpression oraInizio;
	public final TimeExpression oraFine;
	public final CollectionExpression argomentiEsaminati;
	
	public CompitoInClasseDetachedCriteria() {
		super(domain.model.CompitoInClasse.class, domain.model.CompitoInClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		insegnamentoId = new IntegerExpression("insegnamento.ID", this.getDetachedCriteria());
		insegnamento = new AssociationExpression("insegnamento", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		oraInizio = new TimeExpression("oraInizio", this.getDetachedCriteria());
		oraFine = new TimeExpression("oraFine", this.getDetachedCriteria());
		argomentiEsaminati = new CollectionExpression("argomentiEsaminati", this.getDetachedCriteria());
	}
	
	public CompitoInClasseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.CompitoInClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		insegnamentoId = new IntegerExpression("insegnamento.ID", this.getDetachedCriteria());
		insegnamento = new AssociationExpression("insegnamento", this.getDetachedCriteria());
		data = new DateExpression("data", this.getDetachedCriteria());
		oraInizio = new TimeExpression("oraInizio", this.getDetachedCriteria());
		oraFine = new TimeExpression("oraFine", this.getDetachedCriteria());
		argomentiEsaminati = new CollectionExpression("argomentiEsaminati", this.getDetachedCriteria());
	}
	
	public RegistroDocenteDetachedCriteria createInsegnamentoCriteria() {
		return new RegistroDocenteDetachedCriteria(createCriteria("insegnamento"));
	}
	
	public ArgomentoDetachedCriteria createArgomentiEsaminatiCriteria() {
		return new ArgomentoDetachedCriteria(createCriteria("argomentiEsaminati"));
	}
	
	public CompitoInClasse uniqueCompitoInClasse(PersistentSession session) {
		return (CompitoInClasse) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CompitoInClasse[] listCompitoInClasse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CompitoInClasse[]) list.toArray(new CompitoInClasse[list.size()]);
	}
}

