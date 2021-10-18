package offers;

import java.util.LinkedList;

public class Excursion {
	private LinkedList<Travel> travels;
	
	public Excursion() {
		travels = new LinkedList<Travel>();
	}

	public LinkedList<Travel> getTravels() {
		return travels;
	}

	public void setTravels(LinkedList<Travel> travels) {
		this.travels = travels;
	}
	
	public void addTravel(Travel travel) {
		travels.add(travel);
	}
}
