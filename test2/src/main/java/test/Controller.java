package test;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {
	
	private final static Logger logger = LogManager.getLogger(Controller.class);
	HttpServletRequest request;
	
	@RequestMapping("/")
	public String Home() {
		logger.info("Im in Home Page");
		return "Hello, this is the parts DB App!";
	}
	
	@RequestMapping("/PartApp/parts")
	public String getAllParts(HttpServletRequest request) {
		String req = request.getQueryString();
		String pairs[];
		logger.info("Im in getAllParts Method");
		logger.info("Request Args: " + request.getQueryString());
		if (request != null) {
			pairs = req.split("&");
			for(String pair : pairs)
				logger.info("pair: " + pair);
			return "Getting All Parts with Args: " + request.getQueryString();
		}
		return "Getting All Parts!";
	}
	@RequestMapping("/PartApp/parts")
	public String getAllParts() {
		logger.info("Im in getAllParts Method");
		return "Getting All Parts!";
	}
	
	@RequestMapping("/PartApp/parts/{pid}")
	public String getPartById(@PathVariable int pid) {
		logger.info("Im in getPartById Method");
		return "Getting Part By Id: " + pid;
	}
	
}
