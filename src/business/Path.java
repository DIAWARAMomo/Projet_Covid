package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

import java.util.ArrayList;

public class Path {
    private static ArrayList<Place>tab;
    
    public Path(ArrayList<Place> tab) {
     	this.tab = tab;
    }
    
    public Path() {
	tab = new ArrayList<Place>();
    }

    public ArrayList<Place> getTab() {
	return tab;
    }
    
    public void setTab(ArrayList<Place> tab) {
	this.tab = tab;
    }
    
    @Override
    public String toString() {
	return "Path [tab=" + tab + "]";
    }
    public static void addListe(Place p){
	tab.add(p);
    }
    public static void deletListe(Place p){
	if (tab.isEmpty())
	    tab.remove(p);
    }
 

}
