package domain.implementor;

import domain.model.Voto;

public class VotoImp {

	public int compareTo(Voto that, Voto voto) {

		Float thatFloat;
		Float votoFloat;
		
		thatFloat = that.getValore();
		votoFloat = voto.getValore();

		return thatFloat.compareTo(votoFloat);
	}

	public void inizialize(Voto voto, Float valore) {
		voto.setValore(valore);
		
	}

	public void setVoto(Voto that, Voto voto) {
		if(voto == null){
			that.setValore(null);
		}else{
			that.setValore(voto.getValore());
		}
	}

	public Float checkValore(Float valore) {
		if(valore != null){
			if(valore > Voto.MAX_VAL){
				valore = Voto.MAX_VAL;
			}
			if(valore < Voto.MIN_VAL){
				valore = Voto.MIN_VAL;
			}
		}
		return valore;
	}

}
