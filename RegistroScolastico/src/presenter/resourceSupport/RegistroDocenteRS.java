package presenter.resourceSupport;

import org.springframework.hateoas.ResourceSupport;

import domain.model.RegistroDocente;

public class RegistroDocenteRS extends ResourceSupport {
	private Integer idRegistroDocente;
	private String materia;
	
	public RegistroDocenteRS(){
		
	}
	
public RegistroDocenteRS(RegistroDocente registroDocente){
		setIdRegistroDocente(registroDocente.getID());
		setMateria(registroDocente.getMateria().getNome());
	}

public Integer getIdRegistroDocente() {
	return idRegistroDocente;
}

public void setIdRegistroDocente(Integer idRegistroDocente) {
	this.idRegistroDocente = idRegistroDocente;
}

public String getMateria() {
	return materia;
}

public void setMateria(String materia) {
	this.materia = materia;
}


}
