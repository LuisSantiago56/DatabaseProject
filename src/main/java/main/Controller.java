package main;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
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
	
	@RequestMapping(value="/appdb/resources", method={RequestMethod.GET})
	public ArrayList<Resources> getAllResources(HttpServletRequest request) throws SQLException, IOException {		
		return handler.getAllResources(request);
	}
	
	@RequestMapping(value="/appdb/resources", method={RequestMethod.POST})
	public void postResources(@RequestBody Map<String, Object> payload) throws SQLException, IOException {
		handler.insertResource(payload);
	}
	
	@RequestMapping(value="/appdb/resources/{rid}", method={RequestMethod.GET})
	public Resources getResourceById(@PathVariable int rid,HttpServletRequest request) throws IOException {
		return handler.getResourceById(rid);
	}
	
	@RequestMapping(value="/appdb/resources/{rid}", method={RequestMethod.PUT})
	public Resources updateResourceById( @RequestBody Map<String, Object> payload) throws IOException {
		return handler.updateResource(payload);
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
	
	@RequestMapping(value="/appdb/suppliers", method={RequestMethod.GET})
	public 	ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws SQLException, IOException {		
		return handler.getAllSuppliers(request);
	}
	
	@RequestMapping(value="/appdb/suppliers", method={RequestMethod.POST})
	public void postSuppliers(@RequestBody Map<String, Object> payload) throws SQLException, IOException {
		handler.insertSupplier(payload);		
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
	
	@RequestMapping(value="/appdb/suppliers/{sid}", method={RequestMethod.GET})
	public Suppliers getSupplierById(@PathVariable int sid) throws IOException {
		return handler.getSupplierById(sid);
	}
	
	@RequestMapping(value="/appdb/suppliers/{sid}", method={RequestMethod.PUT})
	public Suppliers postSupplierById(@PathVariable int sid, @RequestBody Map<String, Object> payload) throws IOException {
		return handler.updateSupplier(payload);
	}
	
	@RequestMapping("/appdb/supplier/{sid}/resource")
	public ArrayList<Suppliers> getResourcesBySupplierId(@PathVariable int sid) {
		return null;
	}
	
	@RequestMapping("/appdb/supplier/{sid}/announcement")
	public ArrayList<Announcement> getAnnouncementBySupplierId(@PathVariable int sid){
		return null;
	}
	
	@RequestMapping(value="/appdb/customers", method={RequestMethod.GET})
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws IOException {
		return handler.getAllCustomers(request);
	}
	
	@RequestMapping(value="/appdb/customers", method={RequestMethod.POST})
	public void postCustomers(@RequestBody Map<String, Object> payload) throws IOException {
			handler.insertCustomer(payload);
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
	
	@RequestMapping(value="/appdb/customer/{cid}", method={RequestMethod.GET})
	public Customers getCustomerById(HttpServletRequest request, @PathVariable int cid) throws IOException {
		return handler.getCustomerById(cid);
	}
	
	@RequestMapping(value="/appdb/customer/{cid}", method={RequestMethod.PUT,RequestMethod.POST})
	public Customers updateCustomerById(@PathVariable int cid, @RequestBody Map<String, Object> payload) throws IOException {
		return handler.updateCustomers(payload);
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
	public CreditCard getCreditCardByCustomerId(@PathVariable int cid) {
		return handler.getCreditCardByCustomerId(cid);
	}
	
	@RequestMapping(value="/appdb/category", method={RequestMethod.GET})
	public ArrayList<Category> getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllCategories(request);
	}
	
	@RequestMapping(value="/appdb/category/{cat_id}", method={RequestMethod.GET})
	public Category getCategoryById(@PathVariable int cat_id) {

			return handler.getCategoryById(cat_id);

	}
	
	@RequestMapping(value="/appdb/subcategory", method={RequestMethod.GET})
	public ArrayList<SubCategory> getAllSubCategories(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllSubCategories(request);
	}
	
	@RequestMapping(value="/appdb/subcategory/{subcatid}", method={RequestMethod.GET})
	public SubCategory getSubCategoryById(@PathVariable int subcat_id) {
			return handler.getSubCategoryById(subcat_id);
	}

	@RequestMapping(value="/appdb/supplieraddress", method={RequestMethod.GET})
	public ArrayList<SupplierAddress> getAllSupplierAddress(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllSupplierAddress(request);
	}
	
	@RequestMapping(value="/appdb/supplieraddress/{supadd_id}", method={RequestMethod.GET})
	public SupplierAddress getSupplierAddressById(@PathVariable int supadd_id) {
			return handler.getSupplierAddressById(supadd_id);
	}
	
	@RequestMapping("appdb/supplier/{sid}/supplieraddress")
	public SupplierAddress getSupplierAddressBySupplierId(@PathVariable long sid){
		return handler.getSupplierAddressBySupplierId(sid);
	}

	@RequestMapping(value="/appdb/customeraddress", method={RequestMethod.GET})
	public ArrayList<CustomerAddress> getAllCustomerAddress(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllCustomerAddress(request);
	}
	
	@RequestMapping(value="/appdb/customeraddress/{cusadd_id}", method={RequestMethod.GET})
	public CustomerAddress getCustomerAddressById(@PathVariable int cusadd_id) {

			return handler.getCustomerAddressById(cusadd_id);
	}
	
	@RequestMapping("appdb/customer/{cid}/customeraddress")
	public CustomerAddress getCustomersAddressByCustomerId(@PathVariable long cid){
		return handler.getCustomerAddressByCustomerId(cid);
	}

	@RequestMapping(value="/appdb/city", method={RequestMethod.GET})
	public ArrayList<City> getAllCities(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllCities(request);
	}
	
	@RequestMapping(value="/appdb/city/{cityid}", method={RequestMethod.GET})
	public City getCityById(@PathVariable int cityId) {
			return handler.getCityById(cityId);
	}

	@RequestMapping(value="/appdb/announcement", method={RequestMethod.GET})
	public ArrayList<Announcement> getAllAnnouncements(@RequestBody Map<String, Object> payload) throws IOException {
			return handler.getAllAnnouncements(request);
	}
	
	@RequestMapping(value="/appdb/announcement", method={RequestMethod.POST})
	public void postAnnouncement(@RequestBody Map<String, Object> payload) throws IOException {
			handler.insertAnnouncement(payload);
	}
	
	@RequestMapping(value="/appdb/announcement/{annid}", method={RequestMethod.GET})
	public Announcement getAnnouncementById(int annid) {
			return handler.getAnnouncementById(annid);
	}
	
	@RequestMapping(value="/appdb/announcement-search", method={RequestMethod.GET})
	public ArrayList<AnnouncementSearch> searchAnnouncement(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.searchAnnouncement(request);
	}
	
	@RequestMapping("/appdb/announcement/{annid}/supplier")
	public ArrayList<Suppliers> getSuppliersByAnnouncementId(@PathVariable int annid) {
		return null;
	}
	
	@RequestMapping("/appdb/announcement/{annid}/resource")
	public ArrayList<Resources> getResourceByAnnouncementId(@PathVariable int annid){
		return null;
	}

	@RequestMapping(value="/appdb/request", method={RequestMethod.GET})
	public ArrayList<Request> getAllRequests(HttpServletRequest request) throws IOException {
			return handler.getAllRequests(request);
	}
	
	@RequestMapping(value="/appdb/request", method={RequestMethod.POST})
	public void postRequest(@RequestBody Map<String, Object> payload) throws IOException {
			handler.insertRequest(payload);
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
	
	@RequestMapping(value="/appdb/request/{reqid}", method={RequestMethod.GET})
	public Request getRequestById(int reqid) {
			return handler.getRequestById(reqid);
	}
	
	@RequestMapping("appdb/request/{reqid}/customer")
	public ArrayList<Customers> getCustomersByRequestId(@PathVariable int requid){
		return null;
	}
	
	@RequestMapping("/appdb/request/{reqid}/resource")
	public ArrayList<Resources> getResoucesByRequestId(@PathVariable int reqid) {
		return null;
	}

	@RequestMapping(value="/appdb/location", method={RequestMethod.GET})
	public ArrayList<Location> getAllLocations(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllLocations(request);
	}
	
	@RequestMapping(value="/appdb/location/{locid}", method={RequestMethod.GET})
	public Location getLocationById(int locid) {
			return handler.getLocationById(locid);
	}

	@RequestMapping(value="/appdb/purchase", method={RequestMethod.GET})
	public ArrayList<Purchase> getAllPurchases(HttpServletRequest request) throws IOException {
			return handler.getAllPurchases(request);
	}
	
	@RequestMapping(value="/appdb/purchase", method={RequestMethod.POST})
	public void postPurchase(@RequestBody Map<String, Object> payload) throws IOException {
			handler.insertPurchase(payload);
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
	
	@RequestMapping(value="/appdb/purchase/{purid}", method={RequestMethod.GET})
	public Purchase getPurchaseById(int purid) {
			return handler.getPurchaseById(purid);
	}
	
	@RequestMapping("/appdb/purchase/{purid}/customer")
	public ArrayList<Customers> getCustomersByPurchaseId(@PathVariable int purid) {
		return null;
	}
	
	@RequestMapping("/appdb/purchase/{purid}/creditcard")
	public ArrayList<CreditCard> getCreditCardByPurchaseId(@PathVariable int purid) {
		return null;
	}
	
	@RequestMapping(value="/appdb/creditcard", method={RequestMethod.GET})
	public ArrayList<CreditCard> getAllCreditCards(HttpServletRequest request, @RequestBody Map<String, Object> payload) throws UnsupportedEncodingException {
			return handler.getAllCreditCards(request);
	}
	
	@RequestMapping(value="/appdb/creditcard/{credcardnumber}", method={RequestMethod.GET})
	public CreditCard getCreditCardById(String credcardnumber) {
			return handler.getCreditCardById(credcardnumber);
	}
	
	@RequestMapping("/appdb/creditcard/{credcardnumber}/customer")
	public ArrayList<Customers> getCustomerByCreditCardNumber(@PathVariable int credcardnumber) {
		return null;
	}
	
	@RequestMapping("/appdb/creditcard/{credcardnumber}/purchase")
	public ArrayList<Purchase> getPurchaseByCreditCardNumber(@PathVariable int credcardnumber) {
		return null;
	}
	
	@RequestMapping(value="/appdb/supplies", method={RequestMethod.GET})
	public ArrayList<Supplies> getAllSupplies(HttpServletRequest request) throws UnsupportedEncodingException {
			return handler.getAllSupplies(request);
	}
	
	@RequestMapping(value="/appdb/supplies/{sid}", method={RequestMethod.GET})
	public ArrayList<Supplies> getSuppliesById(@PathVariable int sid) {
			return handler.getSuppliesBySupplierId(sid);
	}
	
}