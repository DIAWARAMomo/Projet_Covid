package business;

public class Position {
	
	private Double x;
	private Double y;
	public Position(double x,double y) {
		super();
		this.x = x;
		this.y = y;
	}
	public Position() {
		
		// TODO Auto-generated constructor stub
	}
	public double getX() {
		return x;
	}
	public void setX(double x) {
		this.x = x;
	}
	public double getY() {
		return y;
	}
	public void setY(double y) {
		this.y = y;
	}
	@Override
	public String toString() {
		return "Position [x=" + x + ", y=" + y + "]";
	}
	
    public static double distance(Position p1, Position p2){
	double d ;
	double x1 = p1.getX();
	double y1 = p1.getY();
	
	double x2 = p2.getX();
	double y2 = p2.getY();
	
	double xx = x2-x1;
	double yy = y2-y1;
	
	double resultX = Math.pow(2,xx);
	double resultY = Math.pow(2,yy);
		
	d = Math.sqrt(resultX+resultY);
	return d;
    }
    
	

}
