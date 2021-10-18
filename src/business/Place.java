package business;

public  class Place {
	private int id;
	private String name;
	private Position place;
	public Place(int id, String name, Position place) {
		
		this.id = id;
		this.name = name;
		this.place = place;
	
	}
	public Place() {
		
		// TODO Auto-generated constructor stub
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
		return "Place [id=" + id + ", name=" + name + ", place=" + place + "]";
	}


	
	
	
	
}
