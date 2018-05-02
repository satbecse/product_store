package io.productstore.spring.login;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;


import io.productstore.spring.product.ProductController;

@RestController
public class LoginController {

	Logger logger = Logger.getLogger(ProductController.class);	

	@Autowired	
	private LoginService loginService;
	
	@RequestMapping(method=RequestMethod.POST, value="/login")
	public int login(@RequestBody String cred)
	{
		Object obj=JSONValue.parse(cred);
		JSONObject jsonObject = (JSONObject) obj;  
		String un = (String) jsonObject.get("username"); 
		String pw = (String) jsonObject.get("password");
        logger.info("In Login Controller Class :: Username :"+un+"Password :"+pw);
		return loginService.login(un,pw);
	}
}
