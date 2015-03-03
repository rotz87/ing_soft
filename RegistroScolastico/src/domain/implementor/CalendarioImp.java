package domain.implementor;





public class CalendarioImp {
	

	
//	public CalendarioImp(){
//		this.dataOdierna = calcolaDataOdierna();
//	}
//	
//	public void inizialize(Calendario calendario){
//		this.dataOdierna = calcolaDataOdierna();
//
//	}
	
//	
//	public LocalDate getDataOdierna(){
//
//		LocalDate data =  this.calcolaDataOdierna();
//		if(!(this.dataOdierna.isEqual(data))){
//			this.dataOdierna = data;
//		}
//		return this.dataOdierna;	
//
//	}
	
//	/**
//	 * Per la prove lasciamo la date 17/12/2014 a regime bisogna fargli prendere la data odierna
//	 */
//	private LocalDate calcolaDataOdierna(){
//		return new LocalDate(2014,12,17);//a regime deve prendere la data odierna affettiva per ora per i test prende la data de 17 12 2014
//	}
	
//	public boolean isFestivo(Calendario calendario, LocalDate data){
//		boolean festivo = false;
//		
//		festivo = calendario.getGiorniSettimanaliFestivi().contains(new Integer(data.dayOfWeek().get()));
//		
//		Stampa.stampaln();
//		Stampa.stampaln();
//		Stampa.stampaln(" festivo dopo il controllo dei giorni settimanali festivi:  " + festivo + "<<--------------------------------------------------------------------");
//		Stampa.stampaln();
//		Stampa.stampaln();
//		
//		Giorno g = new Giorno();
//		g.setData(data.toDate());
//		if (!festivo){
////			festivo = calendario.getGiorniFestivi().contains(data);
//			festivo = calendario.getGiorniFestivi().contains(g);
//		}
//		
//		for (domain.model.Giorno gg : Calendario.getInstance().getGiorniFestivi()){
//			Stampa.stampaln();
//			Stampa.stampaln();
//			Stampa.stampaln("data festiva:  " + gg.getData()+ "<<--------------------------------------------------------------------");
//			Stampa.stampaln();
//			Stampa.stampaln();
//		}
//		Stampa.stampaln();
//		Stampa.stampaln();
//		Stampa.stampaln(" data odierna:  " + calendario.getInstance().getDataOdierna().toDate()+ "<<--------------------------------------------------------------------");
//		Stampa.stampaln();
//		Stampa.stampaln();
//		
//		Stampa.stampaln();
//		Stampa.stampaln();
//		Stampa.stampaln(" festivo dopo il controllo dei giorni festivi:  " + festivo + "<<--------------------------------------------------------------------");
//		Stampa.stampaln();
//		Stampa.stampaln();
//		
//		return festivo;
//	}
//	
//	public boolean isOggiFestivo(Calendario calendario){
//		
//		return calendario.isFestivo(this.dataOdierna);
//	}
}
