package io.productstore.spring.product;

public class Product {

	private String product_id;
	private String name;
	private String description;
	private String related_products;
	private String image_url;


	public Product() {

	}

	/**
	 * @param product_id
	 * @param name
	 * @param description
	 * @param related_products
	 * @param image_url
	 */
	public Product(String product_id, String name, String description, String related_products, String image_url) {
		super();
		this.product_id = product_id;
		this.name = name;
		this.description = description;
		this.related_products = related_products;
		this.image_url = image_url;
	}

	public String getProduct_id() {
		return product_id;
	}
	public void setProduct_id(String product_id) {
		this.product_id = product_id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getRelated_products() {
		return related_products;
	}
	public void setRelated_products(String related_products) {
		this.related_products = related_products;
	}
	public String getImage_url() {
		return image_url;
	}
	public void setImage_url(String image_url) {
		this.image_url = image_url;
	}

}
