package business;

import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeMap;
import java.util.Set;
import java.util.Map;

import java.util.ArrayList;

public class Voyage {
	private ArrayList<Hotel>hotels;
	private ArrayList<Excursion>excursions;
	private double prixTotal;
	private int days;
    public Voyage(ArrayList<Hotel> hotels,
		  ArrayList<Excursion> excursions,
		  double prixTotal, int days
		  ){
	super();
	this.hotels = hotels;
	this.excursions = excursions;
	this.prixTotal = prixTotal;
	this.days = days;
    }
    public Voyage() {
	
    }
    public ArrayList<Hotel> getHotels() {
	return hotels;
    }
    public void setHotels(ArrayList<Hotel> hotels) {
	this.hotels = hotels;
    }
    public ArrayList<Excursion> getExcursions() {
	return excursions;
    }
    public void setExcursions(ArrayList<Excursion> excursions) {
	this.excursions = excursions;
    }
    public double getPrixTotal() {
	return prixTotal;
    }
    public void setPrixTotal(double prixTotal) {
	this.prixTotal = prixTotal;
    }
    public int getDays() {
	return days;
    }
    public void setDays(int days) {
	this.days = days;
    }
    @Override
    public String toString() {
	return "Travel [hotels=" + hotels + ", excursions=" + excursions + ", prixTotal=" + prixTotal + ", days=" + days
	    + "]";
    }
	
    public static Position centreGravite(HashMap<Float,Place> l){
	double x = 0;
	double y = 0;
	double sum = 0;
	Iterator i = l.entrySet().iterator();
	while(i.hasNext()){
	    Map.Entry m = (Map.Entry)i.next();
	    double d = (double) m.getKey();
      	    sum += d;
	    Position temp = (Position) m.getValue();
	    x += temp.getX() * d;
	    y += temp.getY() * d;
	}
	x = x/sum;
	y = y/sum;
	return new Position(x,y);
    }
    
    public static Hotel hotelProche(ArrayList<Place>l,Position p){
	ArrayList<Hotel> r = new ArrayList<Hotel>();
	Map <Float,Hotel> map = new HashMap<Float,Hotel>();
	
	for(Place it : l ){
	    if( it instanceof Hotel ){
		Place p1 = (Place) it;
		float d =(float) Position.distance( p ,p1.getPlace() );
		map.put( d ,(Hotel) p1 );
	    }
	}
	Map M = new TreeMap(map);
	Set set = M.entrySet();
	Iterator i = set.iterator();
	while(i.hasNext()){
	    Map.Entry m = (Map.Entry)i.next();
	    //   System.out.print(m.getValue() + ": à ");
	    //System.out.println(m.getKey() + "Km ");
	    
	    r.add( (Hotel) m.getValue());
	}
	return r.get(0);
    }
    
    public static Site siteProche(HashMap<Float,Place>l,Position p){
	ArrayList<Site> r = new ArrayList<Site>();
	Map <Float,Site> map = new HashMap<Float,Site>();
	
	for(Map.Entry it : l.entrySet() ){
	    if( it.getValue() instanceof Site ){
		Place p1 = (Place) it.getValue();
		float scor = (float) it.getKey();
		float d =(float) Position.distance( p ,p1.getPlace() )/scor;
		map.put( d ,(Site) p1 );
	    }
	}
	Map M = new TreeMap(map);
	Set set = M.entrySet();
	Iterator i = set.iterator();
	while(i.hasNext()){
	    Map.Entry m = (Map.Entry)i.next();
	    System.out.print(m.getValue() + ": à ");
	    System.out.println(m.getKey() + "Km ");
	
	    r.add((Site) m.getValue());
	}
	return  r.get(0);
    }
    
    
    
    public static /*Voyage*/void  offre(HashMap<Float,Place> l,
					ArrayList<Place> h, double p){
	double prix = 0.;
	
	Excursion es = new Excursion();	

	Map M = new TreeMap(l);
	Set set = M.entrySet();
	Iterator i = set.iterator();
	while(i.hasNext() && prix < p*0.8){
	    Map.Entry m = (Map.Entry)i.next();
	    Position centre = centreGravite(l);
	    Hotel hotel =  hotelProche(h,centre);
	    prix += hotel.getPrice();
	    
	    
	    Place ph = (Place)hotel;
	    Site site = siteProche(l,ph.getPlace());
	    Place ps = (Place) site;
	    
	    Path path = new Path();
	    path.addListe(ph);
	    path.addListe(ps);
	    es.addExcursion(path);

	    //l.remove(ps.getPrice()); pas de prix dans Site
	    
	}
    }
 




    
    
}
