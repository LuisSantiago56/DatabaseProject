package test;

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
		return "Hello, this is the parts DB App!";
	}
	
	@RequestMapping("/PartApp/parts")
	public String getAllParts(HttpServletRequest request) throws UnsupportedEncodingException, JsonProcessingException {
		return handler.getAllParts(request);
	}
	
	@RequestMapping("/PartApp/parts/{pid}")
	public String getPartById(@PathVariable int pid) {
		return handler.getPartById(pid);
	}
	
	@RequestMapping("/Connect")
	public String Connect() {
		JobServerConnection jdbc = new JobServerConnection();
		return jdbc.jobServerConnection();
	}
	
}
