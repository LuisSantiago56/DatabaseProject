package main;

import java.io.UnsupportedEncodingException;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;

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
	public String getAllResources(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllResources(request);
	}
	
	@RequestMapping("/appdb/resources/{rid}")
	public String getResourceById(@PathVariable int rid) {
		return handler.getResourceById(rid);
	}
	
	@RequestMapping("/appdb/suppliers/")
	public String getAllSuppliers(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllSuppliers(request);
	}
	
	@RequestMapping("/appdb/suppliers/{sid}")
	public String getSupplierById(@PathVariable int sid) {
		return handler.getSupplierById(sid);
	}
	
	@RequestMapping("appdb/customers")
	public String getAllCustomers(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllCustomers(request);
	}
	
	@RequestMapping("appdb/customer/{cid}")
	public String getCustomerById(@PathVariable int cid) {
		return handler.getCustomerById(cid);
	}
	
	@RequestMapping("appdb/town")
	public String getAllTowns(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllTowns(request);
	}
	
	@RequestMapping("appdb/town/{tid}")
	public String getTownByID(@PathVariable int tid) {
		return handler.getTownByID(tid);
	}
	
	@RequestMapping("appdb/region")
	public String getAllRegions(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllRegions(request);
	}
	
	@RequestMapping("appdb/region/{reg_id}")
	public String getRegionById(@PathVariable int reg_id) {
		return handler.getRegionById(reg_id);
	}
	
	@RequestMapping("appdb/category")
	public String getAllCategories(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllCategories(request);
	}
	
	@RequestMapping("appdb/category/{cat_id}")
	public String getCategoryById(@PathVariable int cat_id) {
		return handler.getCategoryById(cat_id);
	}
	
	@RequestMapping("/Connect")
	public String Connect() {
		JobServerConnection jdbc = new JobServerConnection();
		return jdbc.jobServerConnection();
	}
	
}
