package io.productstore.spring.login;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

import io.productstore.spring.product.ProductController;


@Service
public class LoginService {
	Logger logger = Logger.getLogger(ProductController.class);	

	// Hard Coded the User credentials 
	Login credentials = new Login("sathish","spring");
	
	public int login(String un,String pw)
	{
		logger.info("In loginService : Username:"+un+" Password:"+pw);
		if((un.equals(credentials.getUsername())) && (pw.equals(credentials.getPassword())))
		{
			logger.info("User Authorisation Pass");
			return 0;
		}
		logger.info("User Authorisation Fail");
		return -1;
	}

}