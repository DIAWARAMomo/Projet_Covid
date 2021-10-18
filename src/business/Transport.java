package business;

import java.util.ArrayList;

public class Transport {
	private ArrayList<Place> array;
	private String type;
	private double priceTransport;
	
	

	public Transport() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Transport(ArrayList<Place> array, String type,double priceTransport) {
		super();
		this.array = array;
		this.type = type;
		this.priceTransport =  priceTransport;
	}
	
	
	

	public ArrayList<Place> getArray() {
		return array;
	}

	public void setArray(ArrayList<Place> array) {
		this.array = array;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	

	public double getPriceTransport() {
		return priceTransport;
	}

	public void setPriceTransport(double priceTransport) {
		this.priceTransport = priceTransport;
	}

	public boolean isBus() {
		if (this.type.equals("bus")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean isBoat() {
		if (this.type.equals("boat")) {
			return true;
		} else {
			return false;
		}
	}
	
	public boolean iswalk() {
		if (this.type.equals("walk")) {
			return true;
		} else {
			return false;
		}
	}

}
