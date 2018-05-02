package io.productstore.spring.product;

import java.util.List;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {

	Logger logger = Logger.getLogger(ProductController.class);

	@Autowired	
	private ProductService productService;	

	@RequestMapping("/")
	public String index() {
		logger.info("Instructing the User to type URL: localhost:8080/index.html");
		return "Please type this url : localhost:8080/index.html";
	}

	
	@RequestMapping("/products")
	public List<Product> getAllProducts()
	{
		logger.info("In GET All Products Controller");
		return productService.getAllProducts();
	}

	@RequestMapping("/products/{id}")
	public Product getProduct(@PathVariable String id) {
		logger.info("In GET Product Controller for id: "+id);
		return productService.getProduct(id);
	}

	@RequestMapping(method=RequestMethod.POST, value="/products") 
	public int addProduct (@RequestBody Product product) {
		logger.info("In POST method for id:" +product.getProduct_id());
		return productService.addProduct(product);
	}

	@RequestMapping(method=RequestMethod.PUT, value="/products/{id}") 
	public void updateProduct (@RequestBody Product product, @PathVariable String id) {
		logger.info("In PUT Products Controller for id:"+id);
		productService.updateProduct(id,product);
	}

	@RequestMapping(method=RequestMethod.DELETE, value="/products/{id}") 
	public void deleteProduct (@PathVariable String id) {
		System.out.println("In DELETE Controller for id:"+id);
		productService.deleteProduct(id);
	}

}
