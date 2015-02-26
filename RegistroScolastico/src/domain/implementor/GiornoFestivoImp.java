package domain.implementor;

import java.util.Date;

import domain.model.GiornoFestivo;

public class GiornoFestivoImp {
	
	public void inizialize(GiornoFestivo giorno, Date data){
		giorno.setData(data);
	}
	
	public boolean equals(GiornoFestivo giorno, java.lang.Object obj) {
		Boolean ret = false;
		if(obj instanceof GiornoFestivo){
			GiornoFestivo g = ((GiornoFestivo) obj);
			ret =  giorno.getData().equals(g.getData());
		}
		return ret;
	}
}
