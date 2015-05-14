package domain.model.mediaStrategy;

import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;

import domain.model.LibrettoVotiLineItem;
import domain.model.Voto;

public class MediaScartaPeggioreStrategy implements IMediaStrategy {

	@Override
	public Voto calcolaMedia(Collection<LibrettoVotiLineItem> libVotiLineItems) {
		
		Voto min;
		Collection<Voto> votos = new LinkedList<Voto>();
		Collection<Voto> votosNull = new LinkedList<Voto>();
		
		for(LibrettoVotiLineItem libVotiLI: libVotiLineItems){
			if(libVotiLI.getCompitoInClasse().isChiuso()){
				votos.add(libVotiLI.getVoto());
			}
		}
//		votos.addAll(voti);
		for (Voto voto : votos){
			if(voto.getValore() == null){
				votosNull.add(voto);
			}
		}
		votos.removeAll(votosNull);
		if(votos.size()>1){
		
				min = Collections.min(votos);
				votos.remove(min);
			
		}
		
		Voto rit;
		float acc = 0;
		int count = 0;
		Float media;
		
		for(Voto voto: votos){
				acc +=voto.getValore();
				count++;
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
