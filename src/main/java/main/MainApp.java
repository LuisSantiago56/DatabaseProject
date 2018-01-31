package main;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.PathMatchConfigurer;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;



@SpringBootApplication
public class MainApp {

	private final static Logger logger = LogManager.getLogger(MainApp.class);
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		SpringApplication.run(MainApp.class, args);
		logger.info("MainApp Running");
	}

    @Configuration  
    public class MvcConfigurer extends WebMvcConfigurerAdapter {  
      
//        @Override  
//        public void addViewControllers(ViewControllerRegistry registry) {  
//            registry.addViewController("/error").setViewName("error.html");  
//            registry.setOrder(Ordered.HIGHEST_PRECEDENCE);  
//        }  
    	
    	@Override
	    public void addCorsMappings(CorsRegistry registry) {
    		registry.addMapping("/**").allowedOrigins("*")
            .allowedMethods("PUT", "DELETE", "GET", "POST");
	    }
      
        @Override  
        public void configurePathMatch(PathMatchConfigurer configurer) {  
            super.configurePathMatch(configurer);  
            configurer.setUseSuffixPatternMatch(false);  
        }  
      
      
    }  

	

}
