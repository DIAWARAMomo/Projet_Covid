package offers;

import java.util.LinkedList;

public class Offer {
	private LinkedList<Excursion> excursions;
	private LinkedList<Hotel> hotels;
	
	public Offer() {
		excursions = new LinkedList<Excursion>();
		hotels =  new LinkedList<Hotel>();
	}

	public LinkedList<Excursion> getExcursions() {
		return excursions;
	}

	public void setExcursions(LinkedList<Excursion> excursions) {
		this.excursions = excursions;
	}

	public LinkedList<Hotel> getHotels() {
		return hotels;
	}

	public void setHotels(LinkedList<Hotel> hotels) {
		this.hotels = hotels;
	}
	
	public void addExcursion(Excursion excursion) {
		excursions.add(excursion);
	}
	
	public void addHotel(Hotel hotel) {
		hotels.add(hotel);
	}
	
}
