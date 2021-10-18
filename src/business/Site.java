package business;

public class Site extends Place {	
	private String type;

	public Site(int id, String name, Position place, String type) {
		super(id, name, place);
		this.type = type;
	}

	public Site() {
		
		// TODO Auto-generated constructor stub
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}	

	public boolean isActivity() {
		if (type.equals("activity")) {
			return true;
		}
		else {
			return false ;
		}
		
	}
	
	
	public boolean isHistoric() {
		if (type.equals("historic")) {
			return true;
			
		}
		else {
			return false ;
		}
		
		
	}
	
	
	
	
}
