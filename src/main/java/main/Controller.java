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
	
	@RequestMapping("appdb/customers")
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCustomers(request);
	}
	
	@RequestMapping("/appdb/customers-search")
	public ArrayList<CustomerSearch> searchCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchCustomer(request);
	}
	
	@RequestMapping("appdb/customer/{cid}")
	public Customers getCustomerById(@PathVariable int cid) {
		return handler.getCustomerById(cid);
	}
	
	@RequestMapping("appdb/category")
	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCategories(request);
	}
	
	@RequestMapping("appdb/category/{cat_id}")
	public Category getCategoryById(@PathVariable int cat_id) {
		return handler.getCategoryById(cat_id);
	}
	
	@RequestMapping("appdb/subcategory")
	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSubCategories(request);
	}
	
	@RequestMapping("appdb/subcategory/{subcatid}")
	public SubCategory getSubCategoryById(@PathVariable int subcat_id) {
		return handler.getSubCategoryById(subcat_id);
	}

	@RequestMapping("appdb/supplieraddress")
	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSupplierAddress(request);
	}
	
	@RequestMapping("appdb/supplieraddress/{supadd_id}")
	public SupplierAddress getSupplierAddressById(@PathVariable int supadd_id) {
		return handler.getSupplierAddressById(supadd_id);
	}

	@RequestMapping("appdb/customeraddress")
	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCustomerAddress(request);
	}
	
	@RequestMapping("appdb/customeraddress/{cusadd_id}")
	public CustomerAddress getCustomerAddressById(@PathVariable int cusadd_id) {
		return handler.getCustomerAddressById(cusadd_id);
	}

	@RequestMapping("appdb/city")
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCities(request);
	}
	
	@RequestMapping("appdb/city/{cityid}")
	public City getCityById(@PathVariable int cityId) {
		return handler.getCityById(cityId);
	}

	@RequestMapping("/appdb/announcement")
	public ArrayList<Announcement> getAllAnnouncements(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllAnnouncements(request);
	}
	
	@RequestMapping("/appdb/announcement/{annid}")
	public Announcement getAnnouncementById(int annid) {
		return handler.getAnnouncementById(annid);
	}
	
	@RequestMapping("/appdb/announcement-search")
	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchAnnouncement(request);
	}

	@RequestMapping("/appdb/request")
	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllRequests(request);
	}
	
	@RequestMapping("/appdb/request-search")
	public ArrayList<RequestSearch> searchRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchRequests(request);
	}
	
	@RequestMapping("/appdb/request/{reqid}")
	public Request getRequestById(int reqid) {
		return handler.getRequestById(reqid);
	}

	@RequestMapping("/appdb/location")
	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllLocations(request);
	}
	
	@RequestMapping("/appdb/location/{locid}")
	public Location getLocationById(int locid) {
		return handler.getLocationById(locid);
	}

	@RequestMapping("/appdb/purchase")
	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllPurchases(request);
	}
	
	@RequestMapping("/appdb/purchase-search")
	public ArrayList<PurchaseSearch> searchPurchase(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.searchPurcahses(request);
	}
	
	@RequestMapping("/appdb/purchase/{purid}")
	public Purchase getPurchaseById(int purid) {
		return handler.getPurchaseById(purid);
	}
	
	@RequestMapping("/appdb/creditcard")
	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCreditCards(request);
	}
	
	@RequestMapping("/appdb/creditcard/{credcardnumber}")
	public CreditCard getCreditCardById(int credcardnumber) {
		return handler.getCreditCardById(credcardnumber);
	}
	
	@RequestMapping("/appdb/supplies")
	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllSupplies(request);
	}
	
	@RequestMapping("/appdb/supplies/{supid}")
	public Supplies getSuppliesById(int supid) {
		return handler.getSuppliesById(supid);
	}
	
}
