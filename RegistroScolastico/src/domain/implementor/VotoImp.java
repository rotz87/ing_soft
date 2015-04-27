package domain.implementor;

import domain.model.Voto;

public class VotoImp {

	public int compareTo(Voto that, Voto voto) {

		Byte thatByte;
		Byte votoByte;
		
		thatByte = that.getVoto();
		votoByte = voto.getVoto();

		return thatByte.compareTo(votoByte);
	}

}
