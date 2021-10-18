package offers;

public class Site extends Place{
	private String description;
	private String type;
	
	public Site(String name, Float price, String type, String description) {
		setName(name);
		setPrice(price);
		setType(type);
		setDescription(description);
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
}
