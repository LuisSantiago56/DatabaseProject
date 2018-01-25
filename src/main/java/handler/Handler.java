package handler;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;

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
import dao.DAO;
import main.Controller;

public class Handler {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	DAO dao = new DAO();
	
	public ArrayList<Resources> getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllResources Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Resources> resourcesList = dao.getAllResources(query_pairs);
		
		return resourcesList;
	}
	
	public ArrayList<ResourceSearch> searchResource(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchResources Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<ResourceSearch> resourceList = dao.searchResource(searchTerm);
		
		return resourceList;
	}
	
	public Resources getResourceById(@PathVariable int rid) {
		logger.info("Im in getResourcesById Method");
		return dao.getResourcesById(rid);
	}
	
	public Resources updateResource(int rid) {
		if (dao.getResourcesById(rid) == null) {
			//jsonify error Response http
			System.out.println("No resource with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Resources resource = new Resources();
				
//				resource.setName("rname");
//				resource.setQtyPerPk("qtyperpk");
//				resource.setPrice("rprice");
//				resource.setCatId("catid");
//				resource.setSubCatId("subcatid");
			}
			
		}
		return null;
	}
	
	public Resources insertResource(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Resources resource = new Resources();
			
//				resource.setName("rname");
//				resource.setQtyPerPk("qtyperpk");
//				resource.setPrice("rprice");
//				resource.setCatId("catid");
//				resource.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSuppliers Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
			ArrayList<Suppliers> supplierList = dao.getAllSuppliers(query_pairs);
			
			return supplierList;
	}
	
	public ArrayList<SupplierSearch> searchSupplier(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchSuppliers Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<SupplierSearch> supplierList = dao.searchSuppliers(searchTerm);
		
		return supplierList;
	}

	public Suppliers getSupplierById(int sid) {
		logger.info("Im in getSupplierById Method");
		return dao.getSupplierById(sid);
	}
	
	public Suppliers updateSupplier(int rid) {
		if (dao.getSupplierById(rid) == null) {
			//jsonify error Response http
			System.out.println("No supplier with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Suppliers supplier = new Suppliers();
				
//				supplier.setName("rname");
			}
			
		}
		return null;
	}
	
	public Suppliers insertSupplier(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Suppliers supplier = new Suppliers();
			
//				supplier.setName("rname");
//				supplier.setQtyPerPk("qtyperpk");
//				supplier.setPrice("rprice");
//				supplier.setCatId("catid");
//				supplier.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCustomers Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Customers> customersList = dao.getAllCustomers(query_pairs);
		
		return customersList;
	}
	
	public ArrayList<CustomerSearch> searchCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchCustomer Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<CustomerSearch> customerList = dao.searchCustomers(searchTerm);
		
		return customerList;
	}

	public Customers getCustomerById(int cid) {
		logger.info("Im in getCustomerById Method");
		return dao.getCustomerById(cid);
	}
	
	public Customers updateCustomers(int rid) {
		if (dao.getCustomerById(rid) == null) {
			//jsonify error Response http
			System.out.println("No customer with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Customers customer = new Customers();
				
//				customer.setName("rname");
			}
			
		}
		return null;
	}
	
	public Customers insertCustomer(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Customers customer = new Customers();
			
//				customer.setName("rname");
//				customer.setQtyPerPk("qtyperpk");
//				customer.setPrice("rprice");
//				customer.setCatId("catid");
//				customer.setSubCatId("subcatid");
		}
			
		return null;
	}

	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCategories Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Category> categoryList = dao.getAllCategories(query_pairs);
		
		return categoryList;
	}

	public Category getCategoryById(int cat_id) {
		logger.info("Im on getCategoryById Method");
		return dao.getCategoryById(cat_id);
	}
	
	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSubCategories Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<SubCategory> subcategoryList = dao.getAllSubCategories(query_pairs);
		
		return subcategoryList;
	}

	public SubCategory getSubCategoryById(int subcat_id) {
		logger.info("Im on getSubCategoryById Method");
		return dao.getSubCategoryById(subcat_id);
	}
	
	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSupplierAddress Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<SupplierAddress> supplieraddressList = dao.getAllSupplierAddress(query_pairs);
		
		return supplieraddressList;
	}
	
	public SupplierAddress getSupplierAddressById(int supadd_id) {
		logger.info("Im on getSupplierAddressById Method");
		return dao.getSupplierAddressById(supadd_id);
	}
	
	public SupplierAddress updateSupplierAddress(int rid) {
		if (dao.getSupplierAddressById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Supplier Address with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				SupplierAddress supplieraddress = new SupplierAddress();
				
//				supplieraddress.setName("rname");
			}
			
		}
		return null;
	}

	public SupplierAddress insertSupplierAddress(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			SupplierAddress SupplierAddress = new SupplierAddress();
			
//				SupplierAddress.setName("rname");
//				SupplierAddress.setQtyPerPk("qtyperpk");
//				SupplierAddress.setPrice("rprice");
//				SupplierAddress.setCatId("catid");
//				SupplierAddress.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCustomerAddress Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<CustomerAddress> customeraddressList = dao.getAllCustomerAddress(query_pairs);
		
		return customeraddressList;
	}
	
	public CustomerAddress getCustomerAddressById(int cusadd_id) {
		logger.info("Im on getCustomerAddressById Method");
		return dao.getCustomerAddressById(cusadd_id);
	}
	
	public CustomerAddress updateCustomerAddress(int rid) {
		if (dao.getCustomerAddressById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Customer Address with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				CustomerAddress customeraddress = new CustomerAddress();
				
//				customeraddress.setName("rname");
			}
			
		}
		return null;
	}

	public CustomerAddress insertCustomerAddress(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			CustomerAddress CustomerAddress = new CustomerAddress();
			
//				CustomerAddress.setName("rname");
//				CustomerAddress.setQtyPerPk("qtyperpk");
//				CustomerAddress.setPrice("rprice");
//				CustomerAddress.setCatId("catid");
//				CustomerAddress.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCities Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<City> cityList = dao.getAllCities(query_pairs);
		
		return cityList;
	}

	public City getCityById(int cityId) {
		logger.info("Im on getCityById Method");
		return dao.getCityByID(cityId);
	}

	public ArrayList<Announcement> getAllAnnouncements(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllAnnouncement Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Announcement> announcementList = dao.getAllAnnouncements(query_pairs);
		
		return announcementList;
	}
	
	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchAnnouncement Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<AnnouncementSearch> annoucementsList = dao.searchAnnouncement(searchTerm);
		
		return annoucementsList;
	}

	public Announcement getAnnouncementById(int annid) {
		logger.info("Im on getAnnouncementById Method");
		return dao.getAnnouncementById(annid);
	}
	
	public Announcement updateAnnouncement(int rid) {
		if (dao.getAnnouncementById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Announcement with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Announcement announcement = new Announcement();
				
//				announcement.setName("rname");
			}
			
		}
		return null;
	}

	public Announcement insertAnnouncement(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Announcement Announcement = new Announcement();
			
//				Announcement.setName("rname");
//				Announcement.setQtyPerPk("qtyperpk");
//				Announcement.setPrice("rprice");
//				Announcement.setCatId("catid");
//				Announcement.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllRequests Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Request> requestList = dao.getAllRequests(query_pairs);
		
		return requestList;
	}
	
	public ArrayList<RequestSearch> searchRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchRequests Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<RequestSearch> requestList = dao.searchRequests(searchTerm);
		
		return requestList;
	}

	public Request getRequestById(int reqid) {
		logger.info("Im on getRequestById Method");
		return dao.getRequestById(reqid);
	}
	
	public Request updateRequest(int rid) {
		if (dao.getRequestById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Request with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Request request = new Request();
				
//				request.setName("rname");
			}
			
		}
		return null;
	}

	public Request insertRequest(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Request Request = new Request();
			
//				Request.setName("rname");
//				Request.setQtyPerPk("qtyperpk");
//				Request.setPrice("rprice");
//				Request.setCatId("catid");
//				Request.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllLocations Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Location> locationList = dao.getAllLocations(query_pairs);
		
		return locationList;
	}

	public Location getLocationById(int locid) {
		logger.info("Im on getLocationsById Method");
		return dao.getLocationById(locid);
	}
	
	public Location updateLocation(int rid) {
		if (dao.getLocationById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Location with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Location location = new Location();
				
//				location.setLatitude("Latitude");
//				location.setLongitude("Longitude");
			}
			
		}
		return null;
	}

	public Location insertLocation(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Location Location = new Location();
			
//				Location.setName("rname");
//				Location.setQtyPerPk("qtyperpk");
//				Location.setPrice("rprice");
//				Location.setCatId("catid");
//				Location.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllPurchases Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Purchase> purchaseList = dao.getAllPurchases(query_pairs);
		
		return purchaseList;
	}
	
	public ArrayList<PurchaseSearch> searchPurcahses(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		String searchTerm = "";
		logger.info("Im in searchPurchases Method");
		Map<String, String> query_pairs = null;
		if (req != null) {
			query_pairs = splitQuery(request);
			if(query_pairs.containsKey("searchterm")) {
				searchTerm = query_pairs.get("searchterm");
			}
		}
		
		ArrayList<PurchaseSearch> purchaseList = dao.searchPurchase(searchTerm);
		
		return purchaseList;
	}
	
	public Purchase getPurchaseById(int purid) {
		logger.info("Im on getPurchaseById Method");
		return dao.getPurchaseById(purid);
	}
	
	public Purchase updatePurchase(int rid) {
		if (dao.getPurchaseById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Purchase with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				Purchase purchase = new Purchase();
				
//				purchase.setName("rname");
			}
			
		}
		return null;
	}

	public Purchase insertPurchase(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			Purchase Purchase = new Purchase();
			
//				Purchase.setName("rname");
//				Purchase.setQtyPerPk("qtyperpk");
//				Purchase.setPrice("rprice");
//				Purchase.setCatId("catid");
//				Purchase.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllCreditCards Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<CreditCard> creditcardList = dao.getAllCreditCards(query_pairs);
		
		return creditcardList;
	}

	public CreditCard getCreditCardById(int credcardnumber) {
		logger.info("Im on getCreditCardById Method");
		return dao.getCreditCardById(credcardnumber);
	}
	
	public CreditCard updateCreditCard(int rid) {
		if (dao.getCreditCardById(rid) == null) {
			//jsonify error Response http
			System.out.println("No Credit Card with that id.");
		}
		else {
			if(true) {
				//length of data inserted is not equal to the number of columns
			}
			else {
				CreditCard creditcard = new CreditCard();
				
//				creditcard.setName("rname");
			}
			
		}
		return null;
	}
	
	public CreditCard insertCreditCard(int rid) {
		if(true) {
			//length of data inserted is not equal to the number of columns
		}
		else {
			CreditCard CreditCard = new CreditCard();
			
//				CreditCard.setName("rname");
//				CreditCard.setQtyPerPk("qtyperpk");
//				CreditCard.setPrice("rprice");
//				CreditCard.setCatId("catid");
//				CreditCard.setSubCatId("subcatid");
		}
			
		return null;
	}
	
	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		Map<String, String> query_pairs = null;
		logger.info("Im in getAllSupplies Method");
		
		if (req != null) {
			query_pairs = splitQuery(request);
			
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				System.out.println(entry.getKey() + " : " + entry.getValue());
			}
		}
		
		ArrayList<Supplies> suppliesList = dao.getAllSupplies(query_pairs);
		
		return suppliesList;
	}
	
	public Supplies getSuppliesById(int supid) {
		logger.info("Im on getCreditCardById Method");
		return dao.getSuppliesById(supid);
	}
	
	//=================================================================
	
	private static Map<String, String> splitQuery(HttpServletRequest request) throws UnsupportedEncodingException {
	    Map<String, String> query_pairs = new HashMap<String, String>();
	    String req = request.getQueryString();
	    String[] pairs = req.split("&");
	    for (String pair : pairs) {
	        int idx = pair.indexOf("=");
	        query_pairs.put(pair.substring(0, idx), pair.substring(idx + 1));
	    }
	    return query_pairs;
	}
	
}
