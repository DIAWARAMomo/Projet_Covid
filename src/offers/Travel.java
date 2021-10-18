package offers;

public class Travel {
	private Place place1;
	private Place place2;
	private Float distance;
	
	public Travel(Place place1, Place place2, Float distance) {
		this.place1 = place1;
		this.place2 = place2;
		this.distance = distance;
	}
	public Place getPlace1() {
		return place1;
	}
	public void setPlace1(Place place1) {
		this.place1 = place1;
	}
	public Place getPlace2() {
		return place2;
	}
	public void setPlace2(Place place2) {
		this.place2 = place2;
	}
	public Float getDistance() {
		return distance;
	}
	public void setDistance(Float distance) {
		this.distance = distance;
	}

}
