package test;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

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
	public String getAllParts(HttpServletRequest request) throws UnsupportedEncodingException {
		String req = request.getQueryString();
		logger.info("Im in getAllParts Method");
		logger.info("Request Args: " + request.getQueryString());
		
		if (req != null) {
			Map<String, String> query_pairs = splitQuery(request);
			for(Entry<String, String> entry: query_pairs.entrySet()) {
				logger.info(entry.getKey() + " : " + entry.getValue());
			}

			return "Getting All Parts with Args: " + request.getQueryString();
		}
		return "Getting All Parts!";
	}
	
	@RequestMapping("/PartApp/parts/{pid}")
	public String getPartById(@PathVariable int pid) {
		logger.info("Im in getPartById Method");
		return "Getting Part By Id: " + pid;
	}
	
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
