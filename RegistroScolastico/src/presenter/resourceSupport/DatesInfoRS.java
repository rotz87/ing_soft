package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

public class DatesInfoRS extends ResourceSupport{
	
	
	private Long inizioAnno;
	private Long fineAnno;
	private Long oggi;
	
	
	
	public DatesInfoRS(){}

	public Long getInizioAnno() {
		return inizioAnno;
	}

	public void setInizioAnno(Long inizioAnno) {
		this.inizioAnno = inizioAnno;
	}

	public Long getFineAnno() {
		return fineAnno;
	}

	public void setFineAnno(Long fineAnno) {
		this.fineAnno = fineAnno;
	}

	public Long getOggi() {
		return oggi;
	}

	public void setOggi(Long oggi) {
		this.oggi = oggi;
	}
	
	
}
