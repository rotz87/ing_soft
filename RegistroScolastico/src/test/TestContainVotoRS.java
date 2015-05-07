package test;

import java.util.Collection;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import org.apache.solr.common.util.Hash;

import sviluppo.Stampa;

public class TestContainVotoRS {
	public static void main(String[] args){
		Map<Integer, String> unaLabel;
		Map<Integer, String> label;
		Collection<Map<Integer, String>> unaCollection;
		unaCollection = new LinkedList<Map<Integer, String>>();
		
		unaLabel = new TreeMap<Integer, String>();
		unaLabel.put(1, "A");
		unaLabel.put(2, "++");
		
		label = new HashMap<Integer, String>();
		label.put(1, "A");
		label.put(2, "++");
		unaCollection.add(label);
		
		label = new HashMap<Integer, String>();
		label.put(1, "F");
		label.put(2, "--");
		unaCollection.add(label);
		
		boolean contain;
		contain = unaCollection.contains(unaLabel);
		
		Stampa.stampaln("contain: " + contain);
	}
}
