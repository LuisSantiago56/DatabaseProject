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

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import PlainObjects.Announcement;
import PlainObjects.Category;
import PlainObjects.City;
import PlainObjects.CustomerAddress;
import PlainObjects.Customers;
import PlainObjects.Resources;
import PlainObjects.SubCategory;
import PlainObjects.SupplierAddress;
import PlainObjects.Suppliers;
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
	
	public Resources getResourceById(@PathVariable int rid) {
		logger.info("Im in getResourcesById Method");
		return dao.getResourcesById(rid);
	}
	
	public ArrayList<Suppliers> getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, SQLException {
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

	public Suppliers getSupplierById(int sid) {
		logger.info("Im in getSupplierById Method");
		return dao.getSupplierById(sid);
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

	public Customers getCustomerById(int cid) {
		logger.info("Im in getCustomerById Method");
		return dao.getCustomerById(cid);
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
		logger.info("Im on getCustomerAddressById Method");
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

	public Announcement getAnnouncementById(int annid) {
		logger.info("Im on getCustomerAddressById Method");
		return dao.getAnnouncementById(annid);
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
