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
package domain.model.compitoInClasse;

import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CompitoInClasseDetachedCriteria extends AbstractORMDetachedCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _insegnamentoId;
	public final AssociationExpression _insegnamento;
	public final DateExpression _data;
	public final TimeExpression _oraInizio;
	public final TimeExpression _oraFine;
	public final CollectionExpression _argomentiEsaminati;
	
	public CompitoInClasseDetachedCriteria() {
		super(domain.model.compitoInClasse.CompitoInClasse.class, domain.model.compitoInClasse.CompitoInClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_insegnamentoId = new IntegerExpression("_insegnamento.ID", this.getDetachedCriteria());
		_insegnamento = new AssociationExpression("_insegnamento", this.getDetachedCriteria());
		_data = new DateExpression("_data", this.getDetachedCriteria());
		_oraInizio = new TimeExpression("_oraInizio", this.getDetachedCriteria());
		_oraFine = new TimeExpression("_oraFine", this.getDetachedCriteria());
		_argomentiEsaminati = new CollectionExpression("_argomentiEsaminati", this.getDetachedCriteria());
	}
	
	public CompitoInClasseDetachedCriteria(DetachedCriteria aDetachedCriteria) {
		super(aDetachedCriteria, domain.model.compitoInClasse.CompitoInClasseCriteria.class);
		ID = new IntegerExpression("ID", this.getDetachedCriteria());
		_insegnamentoId = new IntegerExpression("_insegnamento.ID", this.getDetachedCriteria());
		_insegnamento = new AssociationExpression("_insegnamento", this.getDetachedCriteria());
		_data = new DateExpression("_data", this.getDetachedCriteria());
		_oraInizio = new TimeExpression("_oraInizio", this.getDetachedCriteria());
		_oraFine = new TimeExpression("_oraFine", this.getDetachedCriteria());
		_argomentiEsaminati = new CollectionExpression("_argomentiEsaminati", this.getDetachedCriteria());
	}
	
	public domain.model.RegistroDocenteDetachedCriteria create_insegnamentoCriteria() {
		return new domain.model.RegistroDocenteDetachedCriteria(createCriteria("_insegnamento"));
	}
	
	public domain.model.ArgomentoDetachedCriteria create_argomentiEsaminatiCriteria() {
		return new domain.model.ArgomentoDetachedCriteria(createCriteria("_argomentiEsaminati"));
	}
	
	public CompitoInClasse uniqueCompitoInClasse(PersistentSession session) {
		return (CompitoInClasse) super.createExecutableCriteria(session).uniqueResult();
	}
	
	public CompitoInClasse[] listCompitoInClasse(PersistentSession session) {
		List list = super.createExecutableCriteria(session).list();
		return (CompitoInClasse[]) list.toArray(new CompitoInClasse[list.size()]);
	}
}

