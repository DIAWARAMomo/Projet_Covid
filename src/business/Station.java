package business;

public class Station {
	private int id;
	private String name;
	private Position place;
	public Station(int id, String name, Position place) {
		
		this.id = id;
		this.name = name;
		this.place = place;
	}
	
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Position getPlace() {
		return place;
	}
	public void setPlace(Position place) {
		this.place = place;
	}
	@Override
	public String toString() {
		return "Station [id=" + id + ", name=" + name + ", place=" + place + "]";
	}
	
	public double distance(Station s) {
		double d ;
		double x1 = place.getX();
		double y1 = place.getY();
		
		double x2 = place.getX();
		double y2 = place.getY();
		
		double xx = x2-x1;
		double yy = y2-y1;
		
		double resultX = Math.pow(2,xx);
		double resultY = Math.pow(2,yy);
		
		d = Math.sqrt(resultX+resultY);

		return d;
	}
	
	
	
	
	
	
}
