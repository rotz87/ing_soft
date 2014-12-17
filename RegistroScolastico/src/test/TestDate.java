package test;

import java.util.GregorianCalendar;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;

public class TestDate {
	public static void main(String[] args){
		
		GregorianCalendar g = new GregorianCalendar(2014,1,5);
		System.out.println(g.getTime());
		
		 DateTime dt = new DateTime();
		 System.out.println(dt);
		 
		 LocalTime lt = new LocalTime();
		 System.out.println(lt);
		 
		 LocalDate ld = new LocalDate(2014,12,31);
		 System.out.println(ld);
		 LocalDate ldplus = ld.plusDays(1);
		 System.out.println(ldplus);
	}

}
