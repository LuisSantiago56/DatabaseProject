package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {

	private final static Logger logger = LogManager.getLogger(MainApp.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApp.class, args);
		logger.info("TestApp Running");
	}

}
