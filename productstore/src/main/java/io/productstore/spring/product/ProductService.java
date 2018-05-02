package io.productstore.spring.product;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

	Logger logger = Logger.getLogger(ProductService.class);
	List<Product> products = new ArrayList<>(Arrays.asList(
			new Product("1","Bat","Cricket Bat","Ball,Stumps","https://encrypted-tbn2.gstatic.com/shopping?q=tbn:ANd9GcQ5JvFTdHso7FCEzZJp5yxHYhDj_Ra7VhchKDyuJqevY5KoJRp9bwH1nX7nlVL77O-yb1z0OjLK&usqp=CAc"),
			new Product("2","Ball","Cricket Ball","Bat,Stumps","https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcROJ0hDOrYw1dv0BWTOGEVkggmZneru8-CBHXqs0Ep0RbiNJHDsM8LkXLy2x6j13lwPZRq-0ak&usqp=CAc"),
			new Product("3","Stumps","Cricket Stumps","Bat,Ball","https://encrypted-tbn3.gstatic.com/shopping?q=tbn:ANd9GcSG_rSsQWkNjhzjNXS7qRE81MweYDyVyyC7oFKVWzTHkbp8zW4_zNVaI3JABQFZip0COqw6tys9&usqp=CAc")
			));

	public List<Product> getAllProducts(){
		logger.info("Number of Products in the Store :"+products.size());
		if (products.size() != 0)
		{
			logger.info("Returning all the Products in the store to the Homepage" );	
			return products;
		}
		else
		{
			logger.info("Oops!! There are no products in the Store!!");	
			return null;	
		}
	}

	public Product getProduct(String id) {
		logger.info("Going to return the product with id :"+id);
		if(products.stream().filter(t -> t.getProduct_id().equals(id)).findFirst().isPresent())
		{
			logger.info("Product Exists with product id :"+id);
			return products.stream().filter(t -> t.getProduct_id().equals(id)).findFirst().get();	
		}
		else 
		{
			logger.info("No Product Exists with Product_id :" +id);
			return null;
		}

	}

	public int addProduct(Product prod) {
		// If Product is already present
		//    return -1 
		// Else 
		//    Add the product and return 0 

		/* Method 1 : To check product is present or not (with loop)
		for (int i=0;i<products.size();i++) {
			Product p=products.get(i);
			if(p.getProduct_id().equals(prod.getProduct_id())) {
				System.out.println("I am returning -1");
				return -1;
			}
		}
		  Method 2 : To check product is present or not (without loop)*/
		if(products.stream().filter(t -> t.getProduct_id().equals(prod.getProduct_id())).findFirst().isPresent())
		{
			logger.info("Product is already existing with Product id :"+prod.getProduct_id()+".So,It can not be added and returning -1"); 
			return -1;	
		}
		else 
		{
			logger.info("Adding a new product to the Product Store with id :"+prod.getProduct_id());
			products.add(prod);
			return 0;
		}
	}


	public int updateProduct(String id, Product product) {	
		
		//Loop thru all the products and if product id to be added is present ,update it otherwise return -1;
		
		for (int i=0;i<products.size();i++) {
			Product p=products.get(i);
			if(p.getProduct_id().equals(id)) {
				products.set(i, product);
				logger.info("The Product has been successfully updated for the product id :"+id);
				return 0;
			}
		}
		logger.info("The Product updation failed for the product id :"+id);
		return -1;

	}

	public int deleteProduct(String id) {
		// If the product to be deleted is present for the input id,delete it otherwise return -1;
		if(products.stream().filter(t -> t.getProduct_id().equals(id)).findFirst().isPresent()) {
			products.removeIf(t -> t.getProduct_id().equals(id));	
			logger.info("The Product has been successfully removed for the product id :"+id);
			return 0;
		}
		logger.info("The Product deletion failed for the product id :"+id);
		return -1;
	}
}