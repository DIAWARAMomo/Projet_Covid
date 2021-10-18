package business;

public class Node  {
	private Station station;
	private double cost;
	public Node(Station station, double cost) {
		super();
		this.station = station;
		this.cost = cost;
	}
	public Node() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Station getStation() {
		return station;
	}
	public void setStation(Station station) {
		this.station = station;
	}
	public double getCost() {
		return cost;
	}
	public void setCost(double cost) {
		this.cost = cost;
	}
	

}
