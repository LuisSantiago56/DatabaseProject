package main;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

import PlainObjects.Announcement;
import PlainObjects.Category;
import PlainObjects.City;
import PlainObjects.CustomerAddress;
import PlainObjects.Customers;
import PlainObjects.Resources;
import PlainObjects.SubCategory;
import PlainObjects.SupplierAddress;
import PlainObjects.Suppliers;
import dao.JobServerConnection;
import handler.Handler;

@RestController
public class Controller {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	HttpServletRequest request;
	Handler handler = new Handler();
	
	@RequestMapping("/")
	public String Home() {
		logger.info("Im in Home Page");
		return "Hello, this is the Disaster Relief DB App!";
	}
	
	@RequestMapping("/appdb/resources")
	public ArrayList<Resources> getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		return handler.getAllResources(request);
	}
	
	@RequestMapping("/appdb/resources/{rid}")
	public Resources getResourceById(@PathVariable int rid) {
		return handler.getResourceById(rid);
	}
	
	@RequestMapping("/appdb/suppliers")
	public 	ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
		return handler.getAllSuppliers(request);
	}
	
	@RequestMapping("/appdb/suppliers/{sid}")
	public Suppliers getSupplierById(@PathVariable int sid) {
		return handler.getSupplierById(sid);
	}
	
	@RequestMapping("appdb/customers")
	public ArrayList<Customers> getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException {
		return handler.getAllCustomers(request);
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


}
