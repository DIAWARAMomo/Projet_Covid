package business;

import java.util.ArrayList;
import java.util.ListIterator;

public class Excursion {
	private ArrayList<Site> sites;
	private ArrayList<Path> path ;

	
	
	public Excursion(ArrayList<Site> sites, ArrayList<Path> path) {
		super();
		this.sites = sites;
		this.path = path;
	}
	public Excursion() {
		
		// TODO Auto-generated constructor stub
	}
	public ArrayList<Site> getSites() {
		return sites;
	}
	public void setSites(ArrayList<Site> sites) {
		this.sites = sites;
	}
	
	public ArrayList<Path> getPath() {
		return path;
	}
	public void setPath(ArrayList<Path> path) {
		this.path = path;
	}
    public void addExcursion(Path p){
	this.path.add(p);
    }
	
	//manque to String 
	
	
	
	

}
