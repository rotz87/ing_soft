package domain.model.mediaStrategy;

import java.util.Collection;

import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;

public class MediaAritmeticaStrategy implements IMediaStrategy{

	@Override
	public Voto calcolaMedia(Collection<LibrettoVotiLineItem> libVotiLineItems) {
		Voto rit;
		Voto voto;
		Float acc = 0f;
		int count = 0;
		Float media;
		
		for(LibrettoVotiLineItem libVotiLI: libVotiLineItems){
			if(libVotiLI.getCompitoInClasse().isChiuso()){
				voto = libVotiLI.getVoto();
				if(voto.getValore() != null){
					acc +=voto.getValore();
					count++;
				}
			}
		}
		
		if(count != 0){
			media = acc / count;
		}else{
			media = null;
		}
		rit = new Voto(); 
		rit.setValore(media);
		
		return rit;
	}

}
