package io.productstore.spring;

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class ProductApiApp {

	public static void main(String[] args) {
	SpringApplication.run(ProductApiApp.class, args);
	//10 
	//1.Sets up default Configuration
	//2.Starts Spring application context
	//3.Perform class path scan
	//4.Starts Tomcat server
	
	Logger logger = Logger.getLogger(ProductApiApp.class);
	BasicConfigurator.configure();
    logger.info("Spring Application Started !!");
	
	}

}
