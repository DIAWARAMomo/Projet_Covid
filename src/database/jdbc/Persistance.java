package database.jdbc;

import database.DatabaseAPI;
import database.jdbc.*;
import database.operator.LuceneOperator;

import java.sql.*;
import java.util.ArrayList;
import java.util.LinkedList;

import javax.faces.bean.ManagedBean;

import com.mysql.jdbc.Statement;

import business.Hotel;
import business.Site;


@ManagedBean
public class Persistance {
//	private DatabaseAPI dbApi = new DatabaseAPI();
//	private LuceneOperator lo = new LuceneOperator();
	
	public Persistance() {
		
	}
	
public ArrayList<Hotel> getListHotelsByPrice(String price){
		
		ArrayList<Hotel> hotels = new ArrayList<Hotel>();
		try{
		String query = "SELECT * FROM hotel where PRICE_H ='"+price+"'";
		Connection dbConnection = JdbcConnection.getConnection();
		PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()){  
		Hotel hotel = new Hotel();  
		hotel.setId(rs.getInt("H_ID"));  
		hotel.setName(rs.getString("H_NAME"));  
		hotel.setPrice(rs.getDouble("PRICE_H"));  
		hotel.setRange(rs.getInt("RANGE_H"));  
		hotel.setBeach(rs.getString("BEACH_NAME"));
		hotels.add(hotel);
		}  
		preparedStatement.close();          
		}catch(Exception e){  
		System.out.println(e);  
		}  
		
		return hotels;  
		}


public Hotel getHotelByName(String name){
	
	Hotel hotel = new Hotel();
	try{
	String query = "SELECT * FROM hotel where H_NAME='"+name+"'";
	Connection dbConnection = JdbcConnection.getConnection();
	PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
	ResultSet rs = preparedStatement.executeQuery();
	while(rs.next()){    
	hotel.setId(rs.getInt("H_ID"));  
	hotel.setName(rs.getString("H_NAME"));  
	hotel.setPrice(rs.getDouble("PRICE_H"));  
	hotel.setRange(rs.getInt("RANGE_H"));  
	hotel.setBeach(rs.getString("BEACH_NAME"));
	}  
	preparedStatement.close();          
	}catch(Exception e){  
	System.out.println(e);  
	}  
	
	return hotel;  
	}

public ArrayList<Site> getAllSiteByType(String type){
	ArrayList<Site> sites = new ArrayList<Site>();
	System.out.println(type);
	try{
	String query = "SELECT * FROM touristicsite where type='"+type+"'";
	System.out.println(type+"2");
	Connection dbConnection = JdbcConnection.getConnection();
	System.out.println(type+"3");
	PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
	System.out.println(type+"4");
	ResultSet rs = preparedStatement.executeQuery();
	System.out.println(type+"5");

	while(rs.next()){
	Site site = new Site();
	site.setId(rs.getInt("S_ID"));  
	site.setName(rs.getString("S_NAME"));
	site.setType(rs.getString("TYPE")); 
	sites.add(site);
	}  
	preparedStatement.close();          
	}catch(Exception e){  
	System.out.println(e);  
	}  
	
	return sites;  
	}

public ArrayList<Hotel> getListHotelsByRange(String range){
	
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	try{
	String query = "SELECT * FROM hotel where RANGE_H='"+range+"'";
	Connection dbConnection = JdbcConnection.getConnection();
	PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
	ResultSet rs = preparedStatement.executeQuery();
	while(rs.next()){  
	Hotel hotel = new Hotel();  
	hotel.setId(rs.getInt("H_ID"));  
	hotel.setName(rs.getString("H_NAME"));  
	hotel.setPrice(rs.getDouble("PRICE_H"));  
	hotel.setRange(rs.getInt("RANGE_H"));  
	hotel.setBeach(rs.getString("BEACH_NAME"));
	hotels.add(hotel);
	}  
	preparedStatement.close();          
	}catch(Exception e){  
	System.out.println(e);  
	}  
	
	return hotels;  
	}

public ArrayList<Hotel> getListHotelsByDuration(String duration){
	
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	try{
	String query = "SELECT * FROM hotel where DUREE_sejour='"+duration+"'";
	Connection dbConnection = JdbcConnection.getConnection();
	PreparedStatement preparedStatement = dbConnection.prepareStatement(query);
	ResultSet rs = preparedStatement.executeQuery();
	while(rs.next()){  
	Hotel hotel = new Hotel();  
	hotel.setId(rs.getInt("H_ID"));  
	hotel.setName(rs.getString("H_NAME"));  
	hotel.setPrice(rs.getDouble("PRICE_H"));  
	hotel.setRange(rs.getInt("RANGE_H"));  
	hotel.setBeach(rs.getString("BEACH_NAME"));
	hotels.add(hotel);
	}  
	preparedStatement.close();          
	}catch(Exception e){  
	System.out.println(e);  
	}  
	
	return hotels;  
	}

	
public ArrayList<Hotel> getlisthotelbyrange2(String range){
	
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	JdbcAPI jdbcAPI = new JdbcAPI(); 
	Connection connection = jdbcAPI.getConnection();		
	String query = "SELECT * FROM hotel where RANGE_H='"+range+"'";
	
	ResultSet res;
	
	try	{
		res = jdbcAPI.perform(query);
		while(res.next()){
			Hotel hotel = new Hotel();
			hotel.setBeach(res.getString("BEACH_NAME"));
			hotel.setName(res.getString("H_NAME"));
			hotel.setPrice(res.getDouble("PRICE_H"));
			hotel.setRange(res.getInt("RANGE_H"));
			hotel.setId(res.getInt("H_ID"));
			hotels.add(hotel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return hotels;
}


public ArrayList<Hotel> getListHotelsByPrice2(String price){
	System.out.println("pk2");
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	System.out.println("pk2");
	JdbcAPI jdbcAPI = new JdbcAPI(); 
	Connection connection = jdbcAPI.getConnection();
	System.out.println("pk3");
	String query = "SELECT * FROM hotel where PRICE_H <='"+price+"'";
	System.out.println("pk4");
	ResultSet res;
	System.out.println("pk5");
	try	{
		res = jdbcAPI.perform(query);
		while(res.next()){
			Hotel hotel = new Hotel();
			hotel.setBeach(res.getString("BEACH_NAME"));
			hotel.setName(res.getString("H_NAME"));
			hotel.setPrice(res.getDouble("PRICE_H"));
			hotel.setRange(res.getInt("RANGE_H"));
			hotel.setId(res.getInt("H_ID"));
			hotels.add(hotel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return hotels;
}

public ArrayList<Hotel> getListHotelsByDuration2(String duration){
	System.out.println("pk2");
	ArrayList<Hotel> hotels = new ArrayList<Hotel>();
	System.out.println("pk2");
	JdbcAPI jdbcAPI = new JdbcAPI(); 
	Connection connection = jdbcAPI.getConnection();
	System.out.println("pk3");
	String query = "SELECT * FROM hotel where DUREE_sejour='"+duration+"'";
	System.out.println("pk4");
	ResultSet res;
	System.out.println("pk5");
	try	{
		res = jdbcAPI.perform(query);
		while(res.next()){
			Hotel hotel = new Hotel();
			hotel.setBeach(res.getString("BEACH_NAME"));
			hotel.setName(res.getString("H_NAME"));
			hotel.setPrice(res.getDouble("PRICE_H"));
			hotel.setRange(res.getInt("RANGE_H"));
			hotel.setId(res.getInt("H_ID"));
			hotels.add(hotel);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return hotels;
}

public ArrayList<Site> getAllSiteByType2(String type){
	System.out.println("pk2");
	ArrayList<Site> sites = new ArrayList<Site>();
	System.out.println("pk2");
	JdbcAPI jdbcAPI = new JdbcAPI(); 
	Connection connection = jdbcAPI.getConnection();
	System.out.println("pk3");
	String query = "SELECT * FROM touristicsite where type='"+type+"'";
	System.out.println("pk4");
	ResultSet res;
	System.out.println("pk5");
	try	{
		res = jdbcAPI.perform(query);
		while(res.next()){
			Site site = new Site();
			site.setId(res.getInt("S_ID"));  
			site.setName(res.getString("S_NAME"));
			site.setType(res.getString("TYPE")); 
			sites.add(site);
		}
	} catch (SQLException e) {
		e.printStackTrace();
	}
	
	return sites;

}

//public void searchInfileAndBase(String keyWord){
//	
//	String query = 	"select S_NAME "
//					+ "from TouristicSite, Textuel "
//					+ "where TYPE  = 'historic' "
//					+ "and TouristicSite.S_NAME = Textuel.T_NOM"
//					+ " '"+keyWord+"'";
//	
//	LinkedList<String[]> res = dbApi.getMixedRequestResponse(query);
//	 
//	res.toString();
//	dbApi.printResult();
//}

}
