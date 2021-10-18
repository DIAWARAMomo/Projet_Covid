package business;

public class Hotel extends Place {
	private double price;
	private int range;
	private String beach;
	
	public Hotel(int id, String name, Position place, double price, int range, String beach) {
		super(id, name, place);
		this.price = price;
		this.range = range;
		this.beach = beach;
	}

	public Hotel() {
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getRange() {
		return range;
	}

	public void setRange(int range) {
		this.range = range;
	}

	public String getBeach() {
		return beach;
	}

	public void setBeach(String beach) {
		this.beach = beach;
	}
	
	


	
	
}
