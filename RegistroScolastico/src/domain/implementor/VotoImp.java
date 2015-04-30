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

	public void inizialize(Voto voto, float valore) {
		voto.setValore(valore);
		
	}

	public void setVoto(Voto that, Voto voto) {
		that.setValore(voto.getValore());
		
	}

	public float checkValore(float valore) {
		if(valore > Voto.MAX_VAL){
			valore = Voto.MAX_VAL;
		}
		if(valore < Voto.MIN_VAL){
			valore = Voto.MIN_VAL;
		}
		return valore;
	}

}
