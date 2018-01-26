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
		if (request.getMethod().equals("POST")) {
			handler.insertResource(request);
			return null;
		}
		else {
			return handler.getAllResources(request);
		}
	}
	
	@RequestMapping(value="/appdb/resources/{rid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Resources getResourceById(@PathVariable int rid,HttpServletRequest request) {
		if ( request.getMethod().equals("GET")) {
			return handler.getResourceById(rid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return handler.updateResource(rid);
		}
		else if ( request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping(value="/appdb/resource-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<ResourceSearch> searchResource(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchResource(request);
		}
	}
	
	@RequestMapping("/appdb/resource/{rid}/supplier")
	public ArrayList<Resources> getSuppliersByResourceId(@PathVariable int rid) {
		return null;
	}
	
	@RequestMapping("/appdb/resource/{rid}/announcement")
	public ArrayList<Announcement> getAnnouncementByResourceId(@PathVariable int rid) {
		return null;
	}
	
	@RequestMapping("/appdb/resource/{rid}/request")
	public ArrayList<Request> getRequestByResourceId(@PathVariable int rid) {
		return null;
	}
	
	@RequestMapping(value="/appdb/suppliers", method={RequestMethod.GET,RequestMethod.POST})
	public 	ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertSupplier(form);
			return null;
		}
		else {
			return handler.getAllSuppliers(request);
		}
	}
	
	@RequestMapping(value="/appdb/suppliers-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SupplierSearch> searchSupplier(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchSupplier(request);
		}
	}
	
	@RequestMapping(value="/appdb/suppliers/{sid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Suppliers getSupplierById(@PathVariable int sid) {
		if (request.getMethod().equals("GET")) {
			return handler.getSupplierById(sid);
		}
		else if (request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping("/appdb/supplier/{sid}/resource")
	public ArrayList<Suppliers> getResourcesBySupplierId(@PathVariable int sid) {
		return null;
	}
	
	@RequestMapping("/appdb/supplier/{sid}/announcement")
	public ArrayList<Announcement> getAnnouncementBySupplierId(@PathVariable int sid){
		return null;
	}
	
	@RequestMapping(value="/appdb/customers", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertCustomer(form);
			return null;
		}
		else {
			return handler.getAllCustomers(request);
		}
	}
	
	@RequestMapping(value="/appdb/customers-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CustomerSearch> searchCustomer(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchCustomer(request);
		}
	}
	
	@RequestMapping(value="/appdb/customer/{cid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Customers getCustomerById(@PathVariable int cid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getCustomerById(cid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping("/appdb/customer/{cid}/purchase")
	public ArrayList<Purchase> getPurchasesByCustomerId(@PathVariable int cid) {
		return null;
	}
	
	@RequestMapping("/appdb/customer/{cid}/request")
	public ArrayList<Request> getRequestByCustomerId(@PathVariable int cid) {
		return null;
	}
	
	@RequestMapping("/appdb/customer/{cid}/creditcard")
	public ArrayList<CreditCard> getCreditCardByCustomerId(@PathVariable int cid) {
		return null;
	}
	
	@RequestMapping(value="/appdb/category", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.getAllCategories(request);
		}
	}
	
	@RequestMapping(value="/appdb/category/{cat_id}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Category getCategoryById(@PathVariable int cat_id) {
		if ( request.getMethod().equals("GET")) {
			return handler.getCategoryById(cat_id);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping(value="/appdb/subcategory", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.getAllSubCategories(request);
		}
	}
	
	@RequestMapping(value="/appdb/subcategory/{subcatid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public SubCategory getSubCategoryById(@PathVariable int subcat_id) {
		if ( request.getMethod().equals("GET")) {
			return handler.getSubCategoryById(subcat_id);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}

	@RequestMapping(value="/appdb/supplieraddress", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertSupplierAddress(form);
			return null;
		}
		else {
			return handler.getAllSupplierAddress(request);
		}
	}
	
	@RequestMapping(value="/appdb/supplieraddress/{supadd_id}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public SupplierAddress getSupplierAddressById(@PathVariable int supadd_id) {
		if ( request.getMethod().equals("GET")) {
			return handler.getSupplierAddressById(supadd_id);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}

	@RequestMapping(value="/appdb/customeraddress", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertCustomerAddress(form);
			return null;
		}
		else {
			return handler.getAllCustomerAddress(request);
		}
	}
	
	@RequestMapping(value="/appdb/customeraddress/{cusadd_id}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public CustomerAddress getCustomerAddressById(@PathVariable int cusadd_id) {
		if ( request.getMethod().equals("GET")) {
			return handler.getCustomerAddressById(cusadd_id);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}

	@RequestMapping(value="/appdb/city", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.getAllCities(request);
		}
	}
	
	@RequestMapping(value="/appdb/city/{cityid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public City getCityById(@PathVariable int cityId) {
		if ( request.getMethod().equals("GET")) {
			return handler.getCityById(cityId);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}

	@RequestMapping(value="/appdb/announcement", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Announcement> getAllAnnouncements(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertAnnouncement(form);
			return null;
		}
		else {
			return handler.getAllAnnouncements(request);
		}
	}
	
	@RequestMapping(value="/appdb/announcement/{annid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Announcement getAnnouncementById(int annid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getAnnouncementById(annid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping(value="/appdb/announcement-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchAnnouncement(request);
		}
	}
	
	@RequestMapping("/appdb/announcement/{annid}/supplier")
	public ArrayList<Suppliers> getSuppliersByAnnouncementId(@PathVariable int annid) {
		return null;
	}
	
	@RequestMapping("/appdb/announcement/{annid}/resource")
	public ArrayList<Resources> getResourceByAnnouncementId(@PathVariable int annid){
		return null;
	}

	@RequestMapping(value="/appdb/request", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertRequest(form);
			return null;
		}
		else {
			return handler.getAllRequests(request);
		}
	}
	
	@RequestMapping(value="/appdb/request-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<RequestSearch> searchRequests(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchRequests(request);
		}
	}
	
	@RequestMapping(value="/appdb/request/{reqid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Request getRequestById(int reqid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getRequestById(reqid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping("appdb/request/{reqid}/customer")
	public ArrayList<Customers> getCustomersByRequestId(@PathVariable int requid){
		return null;
	}
	
	@RequestMapping("/appdb/request/{reqid}/resource")
	public ArrayList<Resources> getResoucesByRequestId(@PathVariable int reqid) {
		return null;
	}

	@RequestMapping(value="/appdb/location", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertLocation(form);
			return null;
		}
		else {
			return handler.getAllLocations(request);
		}
	}
	
	@RequestMapping(value="/appdb/location/{locid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Location getLocationById(int locid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getLocationById(locid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}

	@RequestMapping(value="/appdb/purchase", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertPurchase(form);
			return null;
		}
		else { 
			return handler.getAllPurchases(request);
		}
	}
	
	@RequestMapping(value="/appdb/purchase-search", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<PurchaseSearch> searchPurchase(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.searchPurcahses(request);
		}
	}
	
	@RequestMapping(value="/appdb/purchase/{purid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Purchase getPurchaseById(int purid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getPurchaseById(purid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping("/appdb/purchase/{purid}/customer")
	public ArrayList<Customers> getCustomersByPurchaseId(@PathVariable int purid) {
		return null;
	}
	
	@RequestMapping("/appdb/purchase/{purid}/creditcard")
	public ArrayList<CreditCard> getCreditCardByPurchaseId(@PathVariable int purid) {
		return null;
	}
	
	@RequestMapping(value="/appdb/creditcard", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			Object form = null;
			handler.insertCreditCard(form);
			return null;
		}
		else {
			return handler.getAllCreditCards(request);
		}
	}
	
	@RequestMapping(value="/appdb/creditcard/{credcardnumber}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public CreditCard getCreditCardById(int credcardnumber) {
		if ( request.getMethod().equals("GET")) {
			return handler.getCreditCardById(credcardnumber);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
	@RequestMapping("/appdb/creditcard/{credcardnumber}/customer")
	public ArrayList<Customers> getCustomerByCreditCardNumber(@PathVariable int credcardnumber) {
		return null;
	}
	
	@RequestMapping("/appdb/creditcard/{credcardnumber}/purchase")
	public ArrayList<Purchase> getPurchaseByCreditCardNumber(@PathVariable int credcardnumber) {
		return null;
	}
	
	@RequestMapping(value="/appdb/supplies", method={RequestMethod.GET,RequestMethod.POST})
	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
		if ( request.getMethod().equals("POST")) {
			return null;
		}
		else {
			return handler.getAllSupplies(request);
		}
	}
	
	@RequestMapping(value="/appdb/supplies/{supid}", method={RequestMethod.GET,RequestMethod.PUT,RequestMethod.DELETE})
	public Supplies getSuppliesById(int supid) {
		if ( request.getMethod().equals("GET")) {
			return handler.getSuppliesById(supid);
		}
		else if ( request.getMethod().equals("PUT")) {
			return null;
		}
		else if (request.getMethod().equals("DELETE")) {
			return null;
		}
		else {
			return null; //jsonify error
		}
	}
	
}
