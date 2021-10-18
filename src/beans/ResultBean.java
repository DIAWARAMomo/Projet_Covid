package beans;

import java.util.ArrayList;

import javax.faces.bean.ManagedBean;

import business.Hotel;
import business.Site;
import database.jdbc.Persistance;

@ManagedBean
public class ResultBean {
private Persistance p = new Persistance();
	public ResultBean() {
		
	}
	
	public ArrayList<Hotel> hotelsListByRange(String name){
	
		return p.getListHotelsByRange(name);
	}
	
	public ArrayList<Site> SitesByType(String name){
		
		return p.getAllSiteByType2(name);
	}
	
	public ArrayList<Hotel> hotelsListByPrice(String price){
		
		return p.getListHotelsByPrice2(price);
	}

	public Persistance getP() {
		return p; 
	}

	public void setP(Persistance p) {
		this.p = p;
	}
	
	
	
	
}

