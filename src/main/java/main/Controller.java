package main;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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
import handler.Handler;

@RestController
public class Controller {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	HttpServletRequest request;
	Handler handler = new Handler();
	
//	@RequestMapping("/")
//	public String Home() {
//		logger.info("Im in Home Page");
//		return "Hello, this is the Disaster Relief DB App!";
//	}
	
	@RequestMapping(value="/appdb/resources", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Resources> getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		return handler.getAllResources(request);
	}
	
	@RequestMapping(value="/appdb/resources/{rid}", method={RequestMethod.GET,RequestMethod.POST})
	public Resources getResourceById(@PathVariable int rid) {
		return handler.getResourceById(rid);
	}
	
	@RequestMapping(value="/appdb/resource-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<ResourceSearch> searchResource(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchResource(request);
	}
	
	@RequestMapping(value="/appdb/suppliers", method={RequestMethod.GET,RequestMethod.POST})
	public 	ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		return handler.getAllSuppliers(request);
	}
	
	@RequestMapping(value="/appdb/suppliers-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SupplierSearch> searchSupplier(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchSupplier(request);
	}
	
	@RequestMapping(value="/appdb/suppliers/{sid}", method={RequestMethod.GET,RequestMethod.POST})
	public Suppliers getSupplierById(@PathVariable int sid) {
		return handler.getSupplierById(sid);
	}
	
	@RequestMapping(value="/appdb/customers", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCustomers(request);
	}
	
	@RequestMapping(value="/appdb/customers-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CustomerSearch> searchCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchCustomer(request);
	}
	
	@RequestMapping(value="/appdb/customer/{cid}", method={RequestMethod.GET,RequestMethod.POST})
	public Customers getCustomerById(@PathVariable int cid) {
		return handler.getCustomerById(cid);
	}
	
	@RequestMapping(value="/appdb/category", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCategories(request);
	}
	
	@RequestMapping(value="/appdb/category/{cat_id}", method={RequestMethod.GET,RequestMethod.POST})
	public Category getCategoryById(@PathVariable int cat_id) {
		return handler.getCategoryById(cat_id);
	}
	
	@RequestMapping(value="/appdb/subcategory", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSubCategories(request);
	}
	
	@RequestMapping(value="/appdb/subcategory/{subcatid}", method={RequestMethod.GET,RequestMethod.POST})
	public SubCategory getSubCategoryById(@PathVariable int subcat_id) {
		return handler.getSubCategoryById(subcat_id);
	}

	@RequestMapping(value="/appdb/supplieraddress", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSupplierAddress(request);
	}
	
	@RequestMapping(value="/appdb/supplieraddress/{supadd_id}", method={RequestMethod.GET,RequestMethod.POST})
	public SupplierAddress getSupplierAddressById(@PathVariable int supadd_id) {
		return handler.getSupplierAddressById(supadd_id);
	}

	@RequestMapping(value="/appdb/customeraddress", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCustomerAddress(request);
	}
	
	@RequestMapping(value="/appdb/customeraddress/{cusadd_id}", method={RequestMethod.GET,RequestMethod.POST})
	public CustomerAddress getCustomerAddressById(@PathVariable int cusadd_id) {
		return handler.getCustomerAddressById(cusadd_id);
	}

	@RequestMapping(value="/appdb/city", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCities(request);
	}
	
	@RequestMapping(value="/appdb/city/{cityid}", method={RequestMethod.GET,RequestMethod.POST})
	public City getCityById(@PathVariable int cityId) {
		return handler.getCityById(cityId);
	}

	@RequestMapping(value="/appdb/announcement", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Announcement> getAllAnnouncements(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllAnnouncements(request);
	}
	
	@RequestMapping(value="/appdb/announcement/{annid}", method={RequestMethod.GET,RequestMethod.POST})
	public Announcement getAnnouncementById(int annid) {
		return handler.getAnnouncementById(annid);
	}
	
	@RequestMapping(value="/appdb/announcement-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchAnnouncement(request);
	}

	@RequestMapping(value="/appdb/request", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllRequests(request);
	}
	
	@RequestMapping(value="/appdb/request-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<RequestSearch> searchRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchRequests(request);
	}
	
	@RequestMapping(value="/appdb/request/{reqid}", method={RequestMethod.GET,RequestMethod.POST})
	public Request getRequestById(int reqid) {
		return handler.getRequestById(reqid);
	}

	@RequestMapping(value="/appdb/location", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllLocations(request);
	}
	
	@RequestMapping(value="/appdb/location/{locid}", method={RequestMethod.GET,RequestMethod.POST})
	public Location getLocationById(int locid) {
		return handler.getLocationById(locid);
	}

	@RequestMapping(value="/appdb/purchase", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllPurchases(request);
	}
	
	@RequestMapping(value="/appdb/purchase-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<PurchaseSearch> searchPurchase(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchPurcahses(request);
	}
	
	@RequestMapping(value="/appdb/purchase/{purid}", method={RequestMethod.GET,RequestMethod.POST})
	public Purchase getPurchaseById(int purid) {
		return handler.getPurchaseById(purid);
	}
	
	@RequestMapping(value="/appdb/creditcard", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCreditCards(request);
	}
	
	@RequestMapping(value="/appdb/creditcard/{credcardnumber}", method={RequestMethod.GET,RequestMethod.POST})
	public CreditCard getCreditCardById(int credcardnumber) {
		return handler.getCreditCardById(credcardnumber);
	}
	
	@RequestMapping(value="/appdb/supplies", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSupplies(request);
	}
	
	@RequestMapping(value="/appdb/supplies/{supid}", method={RequestMethod.GET,RequestMethod.POST})
	public Supplies getSuppliesById(int supid) {
		return handler.getSuppliesById(supid);
	}
	
}
