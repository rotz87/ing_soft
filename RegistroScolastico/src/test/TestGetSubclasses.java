package test;

import java.util.Set;

import org.reflections.Reflections;

import domain.model.mediaStrategy.IMediaStrategy;

public class TestGetSubclasses {

	
	public static void main(String[] args) {
		
		  String packageName = IMediaStrategy.class.getPackage().getName();
		
	      Reflections reflections = new Reflections(packageName);

	      Set<Class<? extends IMediaStrategy>> subTypes = reflections.getSubTypesOf(IMediaStrategy.class);
	      
	      for(Class class1 : subTypes){
	    	  System.out.println(class1.getSimpleName());
	      }

	}

}
