package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import PlainObjects.Announcement;
import PlainObjects.Category;
import PlainObjects.City;
import PlainObjects.CreditCard;
import PlainObjects.CustomerAddress;
import PlainObjects.Customers;
import PlainObjects.Location;
import PlainObjects.Purchase;
import PlainObjects.Request;
import PlainObjects.Resources;
import PlainObjects.SubCategory;
import PlainObjects.SupplierAddress;
import PlainObjects.Suppliers;

public class DAO {

	JobServerConnection jdbc = new JobServerConnection();
	
	public ArrayList<Resources> getAllResources(Map<String, String> query_pairs) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Resource";
		}
		else {
			sql = "select * from Resource where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Resources resource = new Resources();
		ArrayList<Resources> resourcesList = new ArrayList<Resources>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				resource.setId(rs.getLong("rid"));
				resource.setName(rs.getString("rname"));
				resource.setQtyPerPk(rs.getInt("qtyperpk"));
				resource.setPrice(rs.getFloat("rprice"));
				resource.setCatId(rs.getLong("catid"));
				resource.setSubCatId(rs.getLong("subcatid"));
				
				resourcesList.add(resource);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resourcesList;
	}
	
	public Resources getResourcesById(int rid) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Resource where rid = " + rid;
		System.out.println(sql);
		
		Resources resource = new Resources();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				resource.setId(rs.getLong("rid"));
				resource.setName(rs.getString("rname"));
				resource.setQtyPerPk(rs.getInt("qtyperpk"));
				resource.setPrice(rs.getFloat("rprice"));
				resource.setCatId(rs.getLong("catid"));
				resource.setSubCatId(rs.getLong("subcatid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return resource;
	}

	public 	ArrayList<Suppliers> getAllSuppliers(Map<String, String> query_pairs) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Supplier natural inner join supplieraddress";
		}
		else {
			sql = "select * from Supplier natural inner join supplieraddress where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Suppliers supplier = new Suppliers();
		ArrayList<Suppliers> suppliersList = new ArrayList<Suppliers>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				supplier.setId(rs.getLong("sid"));
				supplier.setFirstName(rs.getString("sname"));
				supplier.setLastName(rs.getString("slastname"));
				supplier.setPhone(rs.getString("sphone"));
				
				suppliersList.add(supplier);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return suppliersList;
	}
	
	public Suppliers getSupplierById(int sid) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Supplier  natural inner join supplieraddress where sid = " + sid;
		System.out.println(sql);
		
		Suppliers supplier = new Suppliers();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				supplier.setId(rs.getLong("sid"));
				supplier.setFirstName(rs.getString("sname"));
				supplier.setLastName(rs.getString("slastname"));
				supplier.setPhone(rs.getString("sphone"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return supplier;
	}

	public ArrayList<Customers> getAllCustomers(Map<String, String> query_pairs) {
		
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Customer  natural inner join customeraddress";
		}
		else {
			sql = "select * from Customer  natural inner join customeraddress where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Customers customer = new Customers();
		ArrayList<Customers> customersList = new ArrayList<Customers>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				customer.setId(rs.getLong("sid"));
				customer.setFirstName(rs.getString("sname"));
				customer.setLastName(rs.getString("slastname"));
				customer.setPhone(rs.getString("sphone"));
				
				customersList.add(customer);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customersList;
	}

	public Customers getCustomerById(int cid) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Customer  natural inner join customeraddress where cid = " + cid;
		System.out.println(sql);
		
		Customers customer = new Customers();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				customer.setId(rs.getLong("cid"));
				customer.setFirstName(rs.getString("cname"));
				customer.setLastName(rs.getString("clastname"));
				customer.setPhone(rs.getString("cphone"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customer;
	}

	public ArrayList<Category> getAllCategories(Map<String, String> query_pairs) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Category";
		}
		else {
			sql = "select * from Category where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Category category = new Category();
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				category.setCategoryId(rs.getLong("catid"));
				category.setCategoryName(rs.getString("catname"));
				
				categoryList.add(category);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return categoryList;
	}

	public Category getCategoryById(int cat_id) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Category where catid = " + cat_id;
		System.out.println(sql);
		
		Category category = new Category();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				category.setCategoryId(rs.getLong("catid"));
				category.setCategoryName(rs.getString("catname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return category;
	}

	public ArrayList<SubCategory> getAllSubCategories(Map<String, String> query_pairs) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from SubCategory natural inner join Category";
		}
		else {
			sql = "select * from SubCategory natural inner join Category where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		SubCategory subcategory = new SubCategory();
		ArrayList<SubCategory> subcategoryList = new ArrayList<SubCategory>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				subcategory.setSubCategoryId(rs.getLong("subcatid"));
				subcategory.setSubCategoryName(rs.getString("subcatname"));
				
				subcategoryList.add(subcategory);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return subcategoryList;
	}

	public SubCategory getSubCategoryById(int subcat_id) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from SubCategory natural inner join Category where subcatid = " + subcat_id;
		System.out.println(sql);
		
		SubCategory subcategory = new SubCategory();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				subcategory.setSubCategoryId(rs.getLong("catid"));
				subcategory.setSubCategoryName(rs.getString("catname"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return subcategory;
	}

	public ArrayList<SupplierAddress> getAllSupplierAddress(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from SupplierAddress";
		}
		else {
			sql = "select * from SupplierAddress where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		SupplierAddress supplieraddress = new SupplierAddress();
		ArrayList<SupplierAddress> supplieraddressList = new ArrayList<SupplierAddress>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				supplieraddress.setAid(rs.getLong("aid"));
				supplieraddress.setStreet(rs.getString("street"));
				supplieraddress.setCity(rs.getString("city"));
				supplieraddress.setState(rs.getString("state"));
				supplieraddress.setZcode(rs.getString("zcode"));
				supplieraddress.setSid(rs.getLong("sid"));
				
				supplieraddressList.add(supplieraddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return supplieraddressList;
	}

	public SupplierAddress getSupplierAddressById(int supadd_id) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from SupplierAddress where subcatid = " + supadd_id;
		System.out.println(sql);
		
		SupplierAddress supplieraddress = new SupplierAddress();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				supplieraddress.setAid(rs.getLong("aid"));
				supplieraddress.setStreet(rs.getString("street"));
				supplieraddress.setCity(rs.getString("city"));
				supplieraddress.setState(rs.getString("state"));
				supplieraddress.setZcode(rs.getString("zcode"));
				supplieraddress.setSid(rs.getLong("sid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return supplieraddress;
	}

	public ArrayList<CustomerAddress> getAllCustomerAddress(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from CustomerAddress";
		}
		else {
			sql = "select * from CustomerAddress where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		CustomerAddress customeraddress = new CustomerAddress();
		ArrayList<CustomerAddress> customeraddressList = new ArrayList<CustomerAddress>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				customeraddress.setAid(rs.getLong("aid"));
				customeraddress.setStreet(rs.getString("street"));
				customeraddress.setCity(rs.getString("city"));
				customeraddress.setState(rs.getString("state"));
				customeraddress.setZcode(rs.getString("zcode"));
				customeraddress.setCid(rs.getLong("cid"));
				
				customeraddressList.add(customeraddress);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customeraddressList;
	}
	
	public CustomerAddress getCustomerAddressById(int cusadd_id) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from CustomerAddress where aid = " + cusadd_id;
		System.out.println(sql);
		
		CustomerAddress customeraddress = new CustomerAddress();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				customeraddress.setAid(rs.getLong("aid"));
				customeraddress.setStreet(rs.getString("street"));
				customeraddress.setCity(rs.getString("city"));
				customeraddress.setState(rs.getString("state"));
				customeraddress.setZcode(rs.getString("zcode"));
				customeraddress.setCid(rs.getLong("cid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return customeraddress;
	}

	public ArrayList<City> getAllCities(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from City";
		}
		else {
			sql = "select * from City where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		City city = new City();
		ArrayList<City> cityList = new ArrayList<City>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				city.setCityId(rs.getLong("cityid"));
				city.setCityName(rs.getString("cityName"));
				city.setRegion(rs.getInt("region"));
				
				cityList.add(city);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return cityList;
	}

	public City getCityByID(int cityId) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from City where cityid = " + cityId;
		System.out.println(sql);
		
		City city = new City();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				city.setCityId(rs.getLong("cityid"));
				city.setCityName(rs.getString("cityName"));
				city.setRegion(rs.getInt("region"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return city;
	}

	public ArrayList<Announcement> getAllAnnouncements(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Announcement";
		}
		else {
			sql = "select * from Announcement where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Announcement announcement = new Announcement();
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				announcement.setAnnid(rs.getLong("annid"));
				announcement.setAnndate(rs.getDate("anndate"));
				announcement.setSid(rs.getLong("sid"));
				announcement.setRid(rs.getLong("rid"));
				announcement.setQty(rs.getInt("qty"));
				announcement.setPrice(rs.getFloat("price"));
				
				announcementList.add(announcement);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return announcementList;
	}

	public Announcement getAnnouncementById( int annid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Announcement where annid = " + annid;
		System.out.println(sql);
		
		Announcement announcement = new Announcement();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				announcement.setAnnid(rs.getLong("annid"));
				announcement.setAnndate(rs.getDate("anndate"));
				announcement.setSid(rs.getLong("sid"));
				announcement.setRid(rs.getLong("rid"));
				announcement.setQty(rs.getInt("qty"));
				announcement.setPrice(rs.getFloat("price"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return announcement;
	}

	public ArrayList<Request> getAllRequests(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Request";
		}
		else {
			sql = "select * from Request where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Request request = new Request();
		ArrayList<Request> requestList = new ArrayList<Request>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				request.setReqid(rs.getLong("reqid"));
				request.setReqdate(rs.getDate("reqdate"));
				request.setCid(rs.getLong("cid"));
				request.setRid(rs.getLong("rid"));
				request.setQty(rs.getInt("qty"));
				request.setLocid(rs.getLong("locid"));
				
				requestList.add(request);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return requestList;
	}
	
	public Request getRequestById(int reqid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Request where reqid = " + reqid;
		System.out.println(sql);
		
		Request request = new Request();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				request.setReqid(rs.getLong("reqid"));
				request.setReqdate(rs.getDate("reqdate"));
				request.setCid(rs.getLong("cid"));
				request.setRid(rs.getLong("rid"));
				request.setQty(rs.getInt("qty"));
				request.setLocid(rs.getLong("locid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return request;
	}

	public ArrayList<Location> getAllLocations(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Location";
		}
		else {
			sql = "select * from Location where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Location location = new Location();
		ArrayList<Location> locationList = new ArrayList<Location>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				location.setLocid(rs.getLong("locid"));
				location.setLatitude(rs.getString("latitude"));
				location.setLongitud(rs.getString("longitud"));
				
				locationList.add(location);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return locationList;
	}

	public Location getLocationById(int locid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Location where locid = " + locid;
		System.out.println(sql);
		
		Location location = new Location();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				location.setLocid(rs.getLong("locid"));
				location.setLatitude(rs.getString("latitude"));
				location.setLongitud(rs.getString("longitud"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return location;
	}

	public ArrayList<Purchase> getAllPurchases(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Purchase";
		}
		else {
			sql = "select * from Purchase where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		Purchase purchase = new Purchase();
		ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				purchase.setPurid(rs.getLong("purid"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setPurprice(rs.getFloat("purprice"));
				purchase.setCid(rs.getLong("cid"));
				purchase.setRid(rs.getLong("rid"));
				purchase.setCredcardnumber(rs.getString("credcardnumber"));
				
				purchaseList.add(purchase);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return purchaseList;
	}
	
	public Purchase getPurchaseById(int purid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Purchase where purid = " + purid;
		System.out.println(sql);
		
		Purchase purchase = new Purchase();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				purchase.setPurid(rs.getLong("purid"));
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setPurprice(rs.getFloat("purprice"));
				purchase.setCid(rs.getLong("cid"));
				purchase.setRid(rs.getLong("rid"));
				purchase.setCredcardnumber(rs.getString("credcardnumber"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return purchase;
	}

	public ArrayList<CreditCard> getAllCreditCards(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from CreditCard";
		}
		else {
			sql = "select * from CreditCard where ";
			int count = 1;
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				sql = sql + entry.getKey() + " = \'" + entry.getValue() + "\'";
				if(count<query_pairs.size()) {
					sql = sql + " and ";
				}
				count++;
			}
		}
		System.out.println(sql);
		
		CreditCard creditcard = new CreditCard();
		ArrayList<CreditCard> creditcardList = new ArrayList<CreditCard>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				creditcard.setCredcardnumber(rs.getString("credcardnumber"));
				creditcard.setExpdate(rs.getDate("expdate"));
				creditcard.setCvcnumber(rs.getInt("cvcnumber"));
				creditcard.setHoldername(rs.getInt("holdername"));
				creditcard.setCid(rs.getLong("cid"));
				
				creditcardList.add(creditcard);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return creditcardList;
	}
	
	public CreditCard getCreditCardById(int credcardnumber) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from CreditCard where credcardnumber = " + credcardnumber;
		System.out.println(sql);
		
		CreditCard creditcard = new CreditCard();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				creditcard.setCredcardnumber(rs.getString("credcardnumber"));
				creditcard.setExpdate(rs.getDate("expdate"));
				creditcard.setCvcnumber(rs.getInt("cvcnumber"));
				creditcard.setHoldername(rs.getInt("holdername"));
				creditcard.setCid(rs.getLong("cid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return creditcard;
	}

}
