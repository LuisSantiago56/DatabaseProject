package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;

import PlainObjects.Announcement;
import PlainObjects.AnnouncementSearch;
import PlainObjects.Category;
import PlainObjects.City;
import PlainObjects.CreditCard;
import PlainObjects.CustomerAddress;
import PlainObjects.CustomerSearch;
import PlainObjects.Customers;
import PlainObjects.Location;
import PlainObjects.Purchase;
import PlainObjects.PurchaseSearch;
import PlainObjects.Request;
import PlainObjects.RequestSearch;
import PlainObjects.ResourceSearch;
import PlainObjects.Resources;
import PlainObjects.SubCategory;
import PlainObjects.SupplierAddress;
import PlainObjects.SupplierSearch;
import PlainObjects.Suppliers;
import PlainObjects.Supplies;

public class DAO {

	JobServerConnection jdbc = new JobServerConnection();
	
	public ArrayList<Resources> getAllResources(Map<String, String> query_pairs) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Resource";
		}
		else {
			sql = "select * from Resource natural inner join Category natural inner join SubCategory where ";
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
		
		ArrayList<Resources> resourcesList = new ArrayList<Resources>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Resources resource = new Resources();
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

	public ArrayList<ResourceSearch> searchResource(String searchTerm) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select rname, catname, subcatname, qtyperpk, rprice from resource as res, category as cat, subcategory as subcat"
				+ " where res.catid=cat.catid and res.subcatid=subcat.subcatid and (Lower(rname) LIKE Lower('%"+searchTerm+"%')"
				+ " or Lower(catname) LIKE Lower('%"+searchTerm+"%') or Lower(subcatname) LIKE Lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<ResourceSearch> resourceList = new ArrayList<ResourceSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				ResourceSearch resource = new ResourceSearch();
				resource.setRname(rs.getString("rname"));
				resource.setCatname(rs.getString("catname"));
				resource.setSubcatname(rs.getString("subcatname"));
				resource.setQtyperpk(rs.getInt("qtyperpk"));
				resource.setRprice(rs.getFloat("rprice"));				
				
				resourceList.add(resource);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return resourceList;
		
	}
	
	public Resources getResourcesById(int rid) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Resource natural inner join Category natural inner join SubCategory where rid = " + rid;
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
		
		ArrayList<Suppliers> suppliersList = new ArrayList<Suppliers>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Suppliers supplier = new Suppliers();
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
	
	public ArrayList<SupplierSearch> searchSuppliers(String searchTerm) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select sname, slastname, sphone, street, city, state, zcode from supplier, supplieraddress as address"
				+ " where supplier.sid=address.sid and (Lower(sname) LIKE Lower('%"+searchTerm+"%') or Lower(slastname) LIKE"
						+ " Lower('%"+searchTerm+"%') or Lower(city) LIKE Lower('%"+searchTerm+"%') or Lower(state) LIKE "
								+ "Lower('%"+searchTerm+"%') or Lower(zcode) LIKE Lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<SupplierSearch> supplierList = new ArrayList<SupplierSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				SupplierSearch supplier = new SupplierSearch();
				supplier.setSname(rs.getString("sname"));
				supplier.setSlastname(rs.getString("slastname"));
				supplier.setSphone(rs.getString("sphone"));
				supplier.setStreet(rs.getString("street"));
				supplier.setCity(rs.getString("city"));
				supplier.setState(rs.getString("state"));
				supplier.setZcode(rs.getString("zcode"));
				
				supplierList.add(supplier);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return supplierList;
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
		
		
		ArrayList<Customers> customersList = new ArrayList<Customers>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Customers customer = new Customers();
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
	
	public ArrayList<CustomerSearch> searchCustomers(String searchTerm) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select cname, clastname, cphone, street, city, state, zcode from customer, customeraddress as address"
				+ " where customer.cid=address.cid and (Lower(cname) LIKE Lower('%"+searchTerm+"%') or Lower(clastname) LIKE"
						+ " Lower('%"+searchTerm+"%') or Lower(city) LIKE Lower('%"+searchTerm+"%') or Lower(state) LIKE "
								+ "Lower('%"+searchTerm+"%') or Lower(zcode) LIKE Lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<CustomerSearch> customerList = new ArrayList<CustomerSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				CustomerSearch customer = new CustomerSearch();
				customer.setCname(rs.getString("cname"));
				customer.setClastname(rs.getString("clastname"));
				customer.setCphone(rs.getString("cphone"));
				customer.setStreet(rs.getString("street"));
				customer.setCity(rs.getString("city"));
				customer.setState(rs.getString("state"));
				customer.setZcode(rs.getString("zcode"));
				
				customerList.add(customer);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return customerList;
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
		
		
		ArrayList<Category> categoryList = new ArrayList<Category>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Category category = new Category();
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
		
	
		ArrayList<SubCategory> subcategoryList = new ArrayList<SubCategory>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				SubCategory subcategory = new SubCategory();
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
		
		
		ArrayList<SupplierAddress> supplieraddressList = new ArrayList<SupplierAddress>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				SupplierAddress supplieraddress = new SupplierAddress();
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
		
		
		ArrayList<CustomerAddress> customeraddressList = new ArrayList<CustomerAddress>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				CustomerAddress customeraddress = new CustomerAddress();
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
		
		
		ArrayList<City> cityList = new ArrayList<City>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				City city = new City();
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
			sql = "select * from Announcement natural inner join Supplier natural inner join SupplierAddress"
					+ " natural inner join Resource";
		}
		else {
			sql = "select * from Announcement natural inner join Supplier natural inner join SupplierAddress" 
					+ " natural inner join Resource where ";
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
		
	
		ArrayList<Announcement> announcementList = new ArrayList<Announcement>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Announcement announcement = new Announcement();
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

public ArrayList<AnnouncementSearch> searchAnnouncement(String searchTerm) {
		
		Connection conn = jdbc.jobServerInit();
		String sql = "select anndate, sname, rname, qty, annprice, expdate"
				+ " from announcement, resource, supplier"
				+ " where announcement.sid = supplier.sid and announcement.rid = resource.rid"
				+ " and (lower(sname) LIKE lower('%" +searchTerm + "%') or lower(rname) LIKE lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<AnnouncementSearch> announcementList = new ArrayList<AnnouncementSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				AnnouncementSearch announcement = new AnnouncementSearch();
				announcement.setAnndate(rs.getDate("anndate"));
				announcement.setRname(rs.getString("rname"));
				announcement.setSname(rs.getString("sname"));
				announcement.setQty(rs.getInt("qty"));
				announcement.setAnnprice(rs.getFloat("annprice"));		
				announcement.setExpdate(rs.getDate("expdate"));
				
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
		String sql = "select * from Announcement natural inner join Supplier natural inner join SupplierAddress"
				+ " natural inner join Resource where annid = " + annid;
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
			sql = "select * from Request natural inner join Customer natural inner join CustomerAddress"
					+ " natural inner join Resource natural inner join Locations";
		}
		else {
			sql = "select * from Request natural inner join Customer natural inner join CustomerAddress"
					+ " natural inner join Resource natural inner join Locations where ";
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
		

		ArrayList<Request> requestList = new ArrayList<Request>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Request request = new Request();
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
	
	public ArrayList<RequestSearch> searchRequests(String searchTerm) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select reqdate, cname, rname, sname, qty, latitude, longitude"
				+ " from request, customer, resource, supplier, locations"
				+ " where request.cid=customer.cid and request.rid=resource.rid and request.sid=supplier.sid and request.locid=locations.locid"
				+ " and (Lower(rname) LIKE Lower('%"+searchTerm+"%') or Lower(cname) LIKE Lower('%"+searchTerm+"%') or Lower(sname) LIKE Lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<RequestSearch> requestList = new ArrayList<RequestSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				RequestSearch request = new RequestSearch();
				request.setReqdate(rs.getDate("reqdate"));
				request.setCname(rs.getString("cname"));
				request.setRname(rs.getString("rname"));
				request.setSname(rs.getString("sname"));
				request.setQty(rs.getInt("qty"));
				request.setLatitude(rs.getString("latitude"));
				request.setLongitude(rs.getString("longitude"));
				
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
		String sql = "select * from Request natural inner join Customer natural inner join CustomerAddress"
				+ " natural inner join Resource natural inner join Locations where reqid = " + reqid;
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
			sql = "select * from Locations";
		}
		else {
			sql = "select * from Locations where ";
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
		
		
		ArrayList<Location> locationList = new ArrayList<Location>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Location location = new Location();
				location.setLocid(rs.getLong("locid"));
				location.setLatitude(rs.getString("latitude"));
				location.setLongitude(rs.getString("longitude"));
				
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
		String sql = "select * from Locations where locid = " + locid;
		System.out.println(sql);
		
		Location location = new Location();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				location.setLocid(rs.getLong("locid"));
				location.setLatitude(rs.getString("latitude"));
				location.setLongitude(rs.getString("longitude"));
				
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
			sql = "select * from Purchase natural inner join Resource natural inner join CreditCard"
					+ " natural inner join Customer natural inner join CustomerAddress";
		}
		else {
			sql = "select * from Purchase natural inner join Resource natural inner join CreditCard"
					+ " natural inner join Customer natural inner join CustomerAddress where ";
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
		
	
		ArrayList<Purchase> purchaseList = new ArrayList<Purchase>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Purchase purchase = new Purchase();
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
	
	public ArrayList<PurchaseSearch> searchPurchase(String searchTerm) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select purdate, purprice, rname, rprice, credcardnumber, cname, cphone, sname, sphone"
				+ " from purchase, customer, supplier, resource"
				+ " where purchase.cid=customer.cid and purchase.sid=supplier.sid and purchase.rid=resource.rid"
				+ " and (Lower(rname) LIKE Lower('%"+searchTerm+"%')"
				+ " or Lower(cname) LIKE Lower('%"+searchTerm+"%') or Lower(sname) LIKE Lower('%"+searchTerm+"%'))";
		
		System.out.println(sql);

		ArrayList<PurchaseSearch> purchaseList = new ArrayList<PurchaseSearch>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				PurchaseSearch purchase = new PurchaseSearch();
				purchase.setPurdate(rs.getDate("purdate"));
				purchase.setPurprice(rs.getFloat("purprice"));
				purchase.setRname(rs.getString("rname"));
				purchase.setRprice(rs.getFloat("rprice"));
				purchase.setCredcardnumber(rs.getString("credcardnumber"));
				purchase.setCname(rs.getString("cname"));
				purchase.setCphone(rs.getString("cphone"));
				purchase.setSname(rs.getString("sname"));
				purchase.setSphone(rs.getString("sphone"));
				
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
		String sql = "select * from Purchase natural inner join Resource natural inner join CreditCard"
				+ " natural inner join Customer natural inner join CustomerAddress where purid = " + purid;
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
			sql = "select * from CreditCard natural inner join Customer natural inner join CustomerAddress";
		}
		else {
			sql = "select * from CreditCard natural inner join Customer natural inner join CustomerAddress where ";
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
		
		
		ArrayList<CreditCard> creditcardList = new ArrayList<CreditCard>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				CreditCard creditcard = new CreditCard();
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
		String sql = "select * from CreditCard natural inner join Customer natural inner join CustomerAddress"
				+ " where credcardnumber = " + credcardnumber;
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

	public ArrayList<Supplies> getAllSupplies(Map<String, String> query_pairs) {
		Connection conn = jdbc.jobServerInit();
		String sql = "";
		
		if ( query_pairs == null) {
			sql = "select * from Supplies natural inner join Supplier natural inner join SupplierAddress"
					+ " natural inner join City natural inner join Resource";
		}
		else {
			sql = "select * from Supplies natural inner join Supplier natural inner join SupplierAddress"
					+ " natural inner join City natural inner join Resource where ";
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
		
	
		ArrayList<Supplies> suppliesList = new ArrayList<Supplies>();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				Supplies supplies = new Supplies();
				supplies.setSupid(rs.getLong("supid"));
				supplies.setSid(rs.getLong("sid"));
				supplies.setRid(rs.getLong("rid"));
				supplies.setSupprice(rs.getFloat("supprice"));
				supplies.setStock(rs.getInt("stock"));
				supplies.setCityid(rs.getLong("cityid"));
				
				suppliesList.add(supplies);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		return suppliesList;
	}
	
	public Supplies getSuppliesById(int supid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from Supplies natural inner join Supplier natural inner join SupplierAddress"
				+ " natural inner join City natural inner join Resource where supid = " + supid;
		System.out.println(sql);
		
		Supplies supplies = new Supplies();
		
		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()) {
				
				supplies.setSupid(rs.getLong("supid"));
				supplies.setSid(rs.getLong("sid"));
				supplies.setRid(rs.getLong("rid"));
				supplies.setSupprice(rs.getFloat("supprice"));
				supplies.setStock(rs.getInt("stock"));
				supplies.setCityid(rs.getLong("cityid"));
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return supplies;
	}
	
}
