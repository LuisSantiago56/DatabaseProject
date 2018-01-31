package dao;

import java.sql.Connection;
import java.sql.Date;
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
		String sql = "select rid, rname, catname, subcatname, qtyperpk, rprice from resource as res, category as cat, subcategory as subcat"
				+ " where res.catid=cat.catid and res.subcatid=subcat.subcatid and (Lower(rname) LIKE Lower('%"+searchTerm+"%')"
				+ " or Lower(catname) LIKE Lower('%"+searchTerm+"%') or Lower(subcatname) LIKE Lower('%"+searchTerm+"%'))";

		System.out.println(sql);

		ArrayList<ResourceSearch> resourceList = new ArrayList<ResourceSearch>();

		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				ResourceSearch resource = new ResourceSearch();
				resource.setId(rs.getInt("rid"));
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

	public Resources getResourcesById(long rid) {

		Connection conn = jdbc.jobServerInit();
		//String sql = "select * from Resource natural inner join Category natural inner join SubCategory where rid = " + rid;
		
		String sql = "select rid, rname, res.catid, res.subcatid, qtyperpk, rprice from resource as res, category as cat, subcategory as subcat"
				+ " where res.catid=cat.catid and res.subcatid=subcat.subcatid and res.rid =" +rid;
		
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

	public Resources updateResource(Resources resource) {
		
		Connection conn = jdbc.jobServerInit();
		String name = resource.getName();
		int qtyperpk = resource.getQtyPerPk();
		long catid = resource.getCatId();
		long subcatid = resource.getSubCatId();
		float price = resource.getPrice();
		long rid = resource.getId();

		String sql = "Update resource"
				+ " set rname = " + "'"+name+"'" + ", qtyperpk = " + qtyperpk + ", rprice = " + price
				+ ", catid = " + catid + ", subcatid = " + subcatid + " where rid = " + rid;
		System.out.println(sql);
		Statement stm;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public Resources insertResource(Resources resource) {

		Connection conn = jdbc.jobServerInit();
		String name = resource.getName();
		int qtyperpk = resource.getQtyPerPk();
		long catid = resource.getCatId();
		long subcatid = resource.getSubCatId();
		float price = resource.getPrice();

		String sql = "Insert into resource(rname, qtyperpk, rprice, catid, subcatid) values"
				+ " ("+ "'"+name+"'" +","+ qtyperpk +","+ price +","+ catid +","+ subcatid+")";
		System.out.println(sql);
		Statement stm;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
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
		String sql = "select supplier.sid, sname, slastname, sphone, street, city, state, zcode from supplier, supplieraddress as address"
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
				supplier.setSid(rs.getInt("sid"));
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

	public Suppliers getSupplierById(long sid) {

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

	public Suppliers updateSupplier(Suppliers supplier, SupplierAddress supplierAddr) {
		
		Connection conn = jdbc.jobServerInit();
		String firstname = supplier.getFirstName();
		String lastname = supplier.getLastName();
		String phone = supplier.getPhone();
		String street = supplierAddr.getStreet();
		String city = supplierAddr.getCity();
		String state = supplierAddr.getState();
		String zcode = supplierAddr.getZcode();
		long sid = supplier.getId();

		String sql = "Update supplier"
				+ " set sname = " + "'"+firstname+"'" + ", slastname = " + "'"+lastname+"'" + ", sphone = " + "'"+phone+"'"
				+ " where sid = " + sid;
		System.out.println(sql);
		
		String sql2 = "Update supplieraddress"
				+ " set street = " + "'"+street+"'" + ", city = " + "'"+city+"'" + ", state = " + "'"+state+"'" + ", zcode = " + "'"+zcode+"'"
				+ " where sid = " + sid;
		
		Statement stm;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
			stm.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public Suppliers insertSuppliers(Suppliers supplier) {

		Connection conn = jdbc.jobServerInit();
		String firstname = supplier.getFirstName();
		String lastname = supplier.getLastName();
		String phone = supplier.getPhone();

		String sql = "Insert into supplier(sname,slastname,sphone) values"
				+ " ("+ "'"+firstname+"'" +","+ "'"+lastname+"'" +","+ "'"+phone+"'" +")";
		System.out.println(sql);
		Statement stm;
		try {
			stm = conn.createStatement();
			stm.executeQuery(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
				customer.setId(rs.getLong("cid"));
				customer.setFirstName(rs.getString("cname"));
				customer.setLastName(rs.getString("clastname"));
				customer.setPhone(rs.getString("cphone"));
				customer.setPhone(rs.getString("street"));
				customer.setPhone(rs.getString("city"));
				customer.setPhone(rs.getString("state"));
				customer.setPhone(rs.getString("zcode"));

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
		String sql = "select customer.cid, cname, clastname, cphone, street, city, state, zcode from customer, customeraddress as address"
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
				customer.setCid(rs.getInt("cid"));
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

	public Customers getCustomerById(long cid) {

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

	public Customers insertCustomers(Customers customer) {

		Connection conn = jdbc.jobServerInit();
		String firstname = customer.getFirstName();
		String lastname = customer.getLastName();
		String phone = customer.getPhone();

		String sql = "Insert into customer(cname,clastname,cphone) values"
				+ " ("+ "'"+firstname+"'" +","+ "'"+lastname+"'" +","+ "'"+phone+"'" +")";
		System.out.println(sql);
		Statement stm;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Customers updateCustomer(Customers customer, CustomerAddress customerAddr) {
		
		Connection conn = jdbc.jobServerInit();
		String firstname = customer.getFirstName();
		String lastname = customer.getLastName();
		String phone = customer.getPhone();
		String street = customerAddr.getStreet();
		String city = customerAddr.getCity();
		String state = customerAddr.getState();
		String zcode = customerAddr.getZcode();
		long cid = customer.getId();

		String sql = "Update customer"
				+ " set cname = " + "'"+firstname+"'" + ", clastname = " + "'"+lastname+"'" + ", cphone = " + "'"+phone+"'"
				+ " where cid = " + cid;
		System.out.println(sql);
		
		String sql2 = "Update customeraddress"
				+ " set street = " + "'"+street+"'" + ", city = " + "'"+city+"'" + ", state = " + "'"+state+"'" + ", zcode = " + "'"+zcode+"'"
				+ " where cid = " + cid;
		
		Statement stm;
		ResultSet rs = null;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
			stm.execute(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
	
	public SupplierAddress getSupplierAddressBySupplierId(long sid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from SupplierAddress where sid = " + sid;
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

	public SupplierAddress insertSupplierAddress(SupplierAddress SupplierAddress, Suppliers supplier) {

		Connection conn = jdbc.jobServerInit();
		String city = SupplierAddress.getCity();
		String state = SupplierAddress.getState();
		String street = SupplierAddress.getStreet();
		String zcode = SupplierAddress.getZcode();
		long sid = 0;

		String sql1 = "select sid from Supplier where sname = " + "'"+supplier.getFirstName()+"'" 
		+ " and slastname = " + "'"+supplier.getLastName()+"'" + " and sphone = " + "'"+supplier.getPhone()+"'";
		System.out.println(sql1);

		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql1);
			rs.next();
			sid = Integer.parseInt(rs.getString("sid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql2 = "Insert into supplieraddress(street,city,state,zcode,sid) values"
				+ " ("+ "'"+street+ "'" +","+ "'"+city+ "'" +","+ "'"+state+ "'" +","+ "'"+zcode+ "'" +"," +sid +")";
		System.out.println(sql2);
		try {
			stm = conn.createStatement();
			stm.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
	
	public CustomerAddress getCustomerAddressByCustomerId(long cid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from CustomerAddress where cid = " + cid;
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

	public SupplierAddress insertCustomerAddress(CustomerAddress CustomerAddress, Customers customer) {

		Connection conn = jdbc.jobServerInit();
		String city = CustomerAddress.getCity();
		String state = CustomerAddress.getState();
		String street = CustomerAddress.getStreet();
		String zcode = CustomerAddress.getZcode();
		long cid = 0;
		
		String sql1 = "select cid from Customer where cname = " + "'"+customer.getFirstName() +"'"
		+ " and clastname = " + "'"+customer.getLastName()+"'" + " and cphone = " + "'"+customer.getPhone()+"'";
		System.out.println(sql1);

		Statement stm;
		try {
			stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql1);
			rs.next();
			cid = Integer.parseInt(rs.getString("cid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		String sql2 = "Insert into customeraddress(street,city,state,zcode,cid) values"
				+ " ("+ "'"+street+ "'" +","+ "'"+city+ "'" +","+ "'"+state+ "'" +","+ "'"+zcode+ "'" +","+ cid +")";
		System.out.println(sql2);
		try {
			stm = conn.createStatement();
			stm.executeQuery(sql2);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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

	public Announcement insertAnnouncement(Announcement Announcement) {

		Connection conn = jdbc.jobServerInit();
		Date anndate = Announcement.getAnndate();
		float price = Announcement.getPrice();
		int qty = Announcement.getQty();
		long rid = Announcement.getRid();
		long sid = Announcement.getSid();
		Date expdate = Announcement.getExpdate();

		String sql = "Insert into announcement(anndate,sid,rid,annprice,qty, expdate) values"
				+ " (" +" now()" +","+ sid +","+ rid +"," + price +"," + qty + ", '" + expdate + "')";
		System.out.println(sql);
		Statement stm;
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
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
		String sql = "select reqdate, cname, rname, qty, latitude, longitude"
				+ " from request as req, customer as cus, resource as res, locations as loc"
				+ " where req.cid=cus.cid and req.rid=res.rid and req.locid=loc.locid"
				+ " and (Lower(rname) LIKE Lower('%"+searchTerm+"%') or Lower(cname) LIKE Lower('%"+searchTerm+"%'))";

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

	public Request insertRequest(Request request, Location loc) {

		Connection conn = jdbc.jobServerInit();
		Date reqdate = request.getReqdate();
		int qty = request.getQty();
		long rid = request.getRid();
		long cid = request.getCid();
		long locid = request.getLocid();
		String latitude = loc.getLatitude();
		String longitude = loc.getLongitude();
		Statement stm;
		ResultSet rs = null;
		
		String sql = "Insert into locations(latitude, longitude) values" + " ("+ "'"+latitude+ "'" +","+ "'"+longitude+"'" +")";
		System.out.println(sql);
		
		String sql2 = "Select locid from locations where latitude = " + "'"+latitude+"'" + " and longitude = " + "'"+longitude+"'";
		System.out.println(sql2);
		
		try {
			stm = conn.createStatement();
			stm.execute(sql);
			rs = stm.executeQuery(sql2);
			rs.next();
			locid = rs.getLong("locid");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String sql3 = "Insert into request(reqdate, qty, rid, cid, locid) values"
				+ " ( now()" +","+ qty +","+ rid +","+ cid +","+ locid+")";
		System.out.println(sql3);
		try {
			stm = conn.createStatement();
			stm.execute(sql3);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return null;
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
		String sql = "select purdate, purprice, rname, rprice, credcardnumber, cname, cphone, sname, sphone, resource.rid, supplier.sid"
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
				purchase.setSid(rs.getLong("sid"));

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

	public Purchase insertPurchase(Purchase Purchase) {

		Connection conn = jdbc.jobServerInit();
		String credcardnumber = Purchase.getCredcardnumber();
		long cid = Purchase.getCid();
		Date purdate = Purchase.getPurdate();
		double price = Purchase.getPurprice();
		long rid = Purchase.getRid();
		int qty = Purchase.getQty();
		long sid = Purchase.getSid();

		Statement stm;
		ResultSet rs = null;
		
		String sql = "Insert into purchase(credcardnumber, cid, purdate, purprice, rid, qty, sid) values"
				+ " ("+ "'"+credcardnumber+ "'" +","+ cid +", now()" +","+ price +","+ rid +","+ qty + "," + sid +")";
		System.out.println(sql);
		
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
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
				creditcard.setHoldername(rs.getString("holdername"));
				creditcard.setCid(rs.getLong("cid"));

				creditcardList.add(creditcard);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return creditcardList;
	}

	public CreditCard getCreditCardById(String credcardnumber) {
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
				creditcard.setHoldername(rs.getString("holdername"));
				creditcard.setCid(rs.getLong("cid"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return creditcard;
	}
	
	public CreditCard getCreditCardByCustomerId(long cid) {
		Connection conn = jdbc.jobServerInit();
		String sql = "select * from CreditCard natural inner join Customer natural inner join CustomerAddress"
				+ " where cid = " + cid;
		System.out.println(sql);

		CreditCard creditcard = new CreditCard();

		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {

				creditcard.setCredcardnumber(rs.getString("credcardnumber"));
				creditcard.setExpdate(rs.getDate("expdate"));
				creditcard.setCvcnumber(rs.getInt("cvcnumber"));
				creditcard.setHoldername(rs.getString("holdername"));
				creditcard.setCid(rs.getLong("cid"));

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return creditcard;
	}

	public CreditCard insertCreditCard(CreditCard CreditCard, Customers customer) {

		Connection conn = jdbc.jobServerInit();
		String credcardnumber = CreditCard.getCredcardnumber();
		long cid = CreditCard.getCid();
		int cvcnumber = CreditCard.getCvcnumber();
		Date expdate = CreditCard.getExpdate();
		String holdername = CreditCard.getHoldername();

		Statement stm;
		ResultSet rs = null;
		
		String sql1 = "select cid from Customer where cname = " + "'"+customer.getFirstName() +"'"
				+ " and clastname = " + "'"+customer.getLastName()+"'" + " and cphone = " + "'"+customer.getPhone()+"'";
		System.out.println(sql1);

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql1);
			rs.next();
			cid = Integer.parseInt(rs.getString("cid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		
		
		String sql = "Insert into creditcard(credcardnumber, cid, cvcnumber, expdate, holdername) values"
				+ " ("+ "'"+credcardnumber+ "'" +","+ cid +","+ cvcnumber +", '"+ expdate +"' ,"+ "'"+ holdername +"'" +")";
		System.out.println(sql);
		
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return null;
	}
	
	public CreditCard updateCreditCard(CreditCard CreditCard, Customers customer) {

		Connection conn = jdbc.jobServerInit();
		String credcardnumber = CreditCard.getCredcardnumber();
		long cid = CreditCard.getCid();
		int cvcnumber = CreditCard.getCvcnumber();
		Date expdate = CreditCard.getExpdate();
		String holdername = CreditCard.getHoldername();

		Statement stm;
		ResultSet rs = null;
		
		String sql1 = "select cid from Customer where cname = " + "'"+customer.getFirstName() +"'"
				+ " and clastname = " + "'"+customer.getLastName()+"'" + " and cphone = " + "'"+customer.getPhone()+"'";
		System.out.println(sql1);

		try {
			stm = conn.createStatement();
			rs = stm.executeQuery(sql1);
			rs.next();
			cid = Integer.parseInt(rs.getString("cid"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		String sql = "Update creditcard"
				+ " set credcardnumber = " + "'"+credcardnumber+"'" + ", cvcnumber = " + cvcnumber + ", expdate = '" + expdate
				+ "', holdername = " + "'"+holdername+"'" + "where cid = " + cid;
		System.out.println(sql);
		
		
		try {
			stm = conn.createStatement();
			stm.execute(sql);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
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

				suppliesList.add(supplies);

			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


		return suppliesList;
	}

	public ArrayList<Supplies> getSuppliesBySupplierId(int sid) {
		Connection conn = jdbc.jobServerInit();
//		String sql = "select * from Supplies natural inner join Supplier natural inner join SupplierAddress"
//				+ " natural inner join City natural inner join Resource where supid = " + supid;
		String sql = "select rname, qtyperpk, catname, subcatname, stock, res.rid, sup.supid, sup.sid, sup.supprice as rprice from Supplies as sup, Resource as res, Category as cat, Subcategory as subcat where sup.rid = res.rid and res.catid = cat.catid and res.subcatid = subcat.subcatid and sup.sid="+sid;
		System.out.println(sql);

		ArrayList<Supplies> supplies = new ArrayList<Supplies>();

		try {
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);

			while(rs.next()) {
				Supplies supply = new Supplies();
				supply.setRid(rs.getLong("rid"));
				supply.setSid(rs.getLong("sid"));
				supply.setSupid(rs.getLong("supid"));
				supply.setRname(rs.getString("rname"));
				supply.setQtyperpk(rs.getInt("qtyperpk"));
				supply.setCatname(rs.getString("catname"));
				supply.setSubcatname(rs.getString("subcatname"));
				supply.setSupprice(rs.getFloat("rprice"));
				supply.setStock(rs.getInt("stock"));
				
				System.out.println(supply);
				
				supplies.add(supply);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(supplies);
		return supplies;
	}

}
