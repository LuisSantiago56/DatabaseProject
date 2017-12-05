package handler;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import dao.DAO;
import main.Controller;

public class Handler {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	DAO dao = new DAO();
	static String json;
	
//	public String getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
//		String req = request.getQueryString();
//		logger.info("Im in getAllParts Method");
//		logger.info("Request Args: " + request.getQueryString());
//		
//		if (req != null) {
//			Map<String, String> query_pairs = splitQuery(request);
//			json = new ObjectMapper().writeValueAsString(query_pairs);
//			logger.info("JSON: " + json.toString());
//			for(Entry<String, String> entry: query_pairs.entrySet()) {
//				logger.info(entry.getKey() + " : " + entry.getValue());
//			}
//
//			return "Getting All Parts with Args: " + query_pairs.toString();
//		}
//		return "Getting All Parts!";
//	}
	
	public String getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllResources Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllResources();
		}
		return dao.getAllResources();
	}
	
	public String getResourceById(@PathVariable int rid) {
		logger.info("Im in getResourcesById Method");
		return dao.getResourcesById(rid);
	}
	
	public String getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllSuppliers Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllSuppliers();
		}
		return dao.getAllSuppliers();
	}

	public String getSupplierById(int sid) {
		logger.info("Im in getSupplierById Method");
		return dao.getSupplierById(sid);
	}
	
	public String getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllCustomerss Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllCustomers();
		}
		return dao.getAllCustomers();
	}

	public String getCustomerById(int cid) {
		logger.info("Im in getCustomerById Method");
		return dao.getCustomerById(cid);
	}

	public String getAllTowns(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllTowns Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllTowns();
		}
		return dao.getAllTowns();
	}

	public String getTownByID(int tid) {
		logger.info("Im in getTownById Method");
		return dao.getTownById(tid);
	}

	public String getAllRegions(HttpServletRequest request) throws JsonProcessingException, UnsupportedEncodingException {
		String req = request.getQueryString();
		logger.info("Im in getAllRegions Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllTowns();
		}
		return dao.getAllTowns();
	}

	public String getRegionById(int reg_id) {
		logger.info("Im on getRegionById Method");
		return dao.getRegionById(reg_id);
	}

	public String getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		String req = request.getQueryString();
		logger.info("Im in getAllCategories Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			json = new ObjectMapper().writeValueAsString(query_pairs);
			logger.info("JSON: " + json.toString());
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return dao.getAllCategories();
		}
		return dao.getAllCategories();
	}

	public String getCategoryById(int cat_id) {
		logger.info("Im on getCategoryById Method");
		return dao.getCategoryById(cat_id);
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
