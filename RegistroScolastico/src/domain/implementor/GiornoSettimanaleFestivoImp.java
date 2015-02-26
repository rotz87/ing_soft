package domain.implementor;

import domain.model.GiornoFestivo;
import domain.model.GiornoSettimanaleFestivo;

public class GiornoSettimanaleFestivoImp {

	public void inizialize(GiornoSettimanaleFestivo giornoSettimanale, int giorno) {
		giornoSettimanale.setGiorno(giorno);
		
	}
	
	public boolean equals(GiornoSettimanaleFestivo giornoSettimanale, Object obj) {
		Boolean ret = false;
		if(obj instanceof GiornoSettimanaleFestivo){
			GiornoSettimanaleFestivo gs = (GiornoSettimanaleFestivo) obj;
			ret = (giornoSettimanale.getGiorno() == gs.getGiorno());
		}
		return ret;
	}

	public int checkGiorno(int value) {
		if(value <1){value = 1;}
		else if(value >7){value = 7;}
		return value;
	}

	
}