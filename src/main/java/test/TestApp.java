package test;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestApp {

	private final static Logger logger = LogManager.getLogger(TestApp.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(TestApp.class, args);
		logger.info("TestApp Running");
	}

}
