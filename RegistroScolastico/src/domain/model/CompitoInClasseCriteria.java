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

public class CompitoInClasseCriteria extends AbstractORMCriteria {
	public final IntegerExpression ID;
	public final IntegerExpression insegnamentoId;
	public final AssociationExpression insegnamento;
	public final DateExpression data;
	public final TimeExpression oraInizio;
	public final TimeExpression oraFine;
	public final CollectionExpression argomentiEsaminati;
	
	public CompitoInClasseCriteria(Criteria criteria) {
		super(criteria);
		ID = new IntegerExpression("ID", this);
		insegnamentoId = new IntegerExpression("insegnamento.ID", this);
		insegnamento = new AssociationExpression("insegnamento", this);
		data = new DateExpression("data", this);
		oraInizio = new TimeExpression("oraInizio", this);
		oraFine = new TimeExpression("oraFine", this);
		argomentiEsaminati = new CollectionExpression("argomentiEsaminati", this);
	}
	
	public CompitoInClasseCriteria(PersistentSession session) {
		this(session.createCriteria(CompitoInClasse.class));
	}
	
	public CompitoInClasseCriteria() throws PersistentException {
		this(domain.model.RSPersistentManager.instance().getSession());
	}
	
	public RegistroDocenteCriteria createInsegnamentoCriteria() {
		return new RegistroDocenteCriteria(createCriteria("insegnamento"));
	}
	
	public ArgomentoCriteria createArgomentiEsaminatiCriteria() {
		return new ArgomentoCriteria(createCriteria("argomentiEsaminati"));
	}
	
	public CompitoInClasse uniqueCompitoInClasse() {
		return (CompitoInClasse) super.uniqueResult();
	}
	
	public CompitoInClasse[] listCompitoInClasse() {
		java.util.List list = super.list();
		return (CompitoInClasse[]) list.toArray(new CompitoInClasse[list.size()]);
	}
}

