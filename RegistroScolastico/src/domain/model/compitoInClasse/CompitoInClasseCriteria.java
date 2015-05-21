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

import org.hibernate.Criteria;
import org.orm.PersistentException;
import org.orm.PersistentSession;
import org.orm.criteria.*;

public class CompitoInClasseCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression _insegnamentoId;
	public final AssociationExpression _insegnamento;
	public final DateExpression _data;
	public final TimeExpression _oraInizio;
	public final TimeExpression _oraFine;
	public final CollectionExpression _argomentiEsaminati;
	
	public CompitoInClasseCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		_insegnamentoId = new IntegerExpression("_insegnamento.ID", this);
		_insegnamento = new AssociationExpression("_insegnamento", this);
		_data = new DateExpression("_data", this);
		_oraInizio = new TimeExpression("_oraInizio", this);
		_oraFine = new TimeExpression("_oraFine", this);
		_argomentiEsaminati = new CollectionExpression("_argomentiEsaminati", this);
	}
	
	public CompitoInClasseCriteria(PersistentSession session) {
		this(session.createCriteria(CompitoInClasse.class));
	}
	
	public CompitoInClasseCriteria() throws PersistentException {
		this(service.RSPersistentManager.instance().getSession());
	}
	
	public domain.model.RegistroDocenteCriteria create_insegnamentoCriteria() {
		return new domain.model.RegistroDocenteCriteria(createCriteria("_insegnamento"));
	}
	
	public domain.model.ArgomentoCriteria create_argomentiEsaminatiCriteria() {
		return new domain.model.ArgomentoCriteria(createCriteria("_argomentiEsaminati"));
	}
	
	public CompitoInClasse uniqueCompitoInClasse() {
		return (CompitoInClasse) super.uniqueResult();
	}
	
	public CompitoInClasse[] listCompitoInClasse() {
		java.util.List list = super.list();
		return (CompitoInClasse[]) list.toArray(new CompitoInClasse[list.size()]);
	}
}

