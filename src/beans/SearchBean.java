package beans;

import javax.faces.bean.ManagedBean;

@ManagedBean
public class SearchBean {

	private String keyWords;
	private String budget;
	private int budget1;
	private int numberDays1;
	private int distance1;
	private int intensity1;
	private String numberDays;
	private String dateEntry;
	private String distance;
	private String siteType;
	private String intensity;
	private String category;
	private ResultBean result;
	
	public SearchBean() {
		super();
	}
	
	public String findSitesNames() {
		return "result";
		  
	}

	
	public String getKeyWords() {
		return keyWords;
	}


	public void setKeyWords(String keyWords) {
		this.keyWords = keyWords;
	}


	public String getBudget() {
		return budget;
	}


	public void setBudget(String budget) {
		try {
			
			budget1 = Math.abs(Integer.parseInt(budget));
			this.budget = budget;
			
			} catch(NumberFormatException|NullPointerException e) {
			
			}
		}
	


	public String getNumberDays() {
		return numberDays;
	}


	public void setNumberDays(String numberDays) {
		try {
			
			numberDays1 = Math.abs(Integer.parseInt(numberDays));
			this.numberDays = numberDays;
			} catch(NumberFormatException|NullPointerException e) {
			
			}
		}


	public String getDateEntry() {
		
			return dateEntry;
	}


	public void setDateEntry(String dateEntry) {
		this.dateEntry = dateEntry;
	}


	public String getDistance() {
		return distance;
	}


	public void setDistance(String distance) {
		
		try {
			
			distance1 = Math.abs(Integer.parseInt(distance));
			this.distance = distance;
			} catch(NumberFormatException|NullPointerException e) {
			
			}
		}


	public String getIntensity() {
		return intensity;
	}


	public void setIntensity(String intensity) {
		
		try {
			
			intensity1 = Math.abs(Integer.parseInt(intensity));
			this.intensity = intensity;
			} catch(NumberFormatException|NullPointerException e) {
			
			}
		}


	public String getCategory() {
		return category;
	}


	public void setCategory(String category) {
		this.category = category;
	}


	public String getSiteType() {
		return siteType;
	}


	public void setSiteType(String siteType) {
		this.siteType = siteType;
	}

	public int getBudget1() {
		return budget1;
	}

	public int getNumberDays1() {
		return numberDays1;
	}

	public int getDistance1() {
		return distance1;
	}

	public int getIntensity1() {
		return intensity1;
	}

	public ResultBean getResult() {
		return result;
	}

	public void setResult(ResultBean result) {
		this.result = result;
	}

	public void setBudget1(int budget1) {
		this.budget1 = budget1;
	}

	public void setNumberDays1(int numberDays1) {
		this.numberDays1 = numberDays1;
	}

	public void setDistance1(int distance1) {
		this.distance1 = distance1;
	}

	public void setIntensity1(int intensity1) {
		this.intensity1 = intensity1;
	}
	
	
	
	
	
	
	
	
	
}
