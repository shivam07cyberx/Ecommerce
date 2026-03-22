package com.ecommerce.web.modal;



public class Product {
private int product_id;
    private String name;
    private int price;
    private String imageUrl;
    private String description;
    private String brand;
    private String category; 
    private int quantity;
    
    
  
    
    
    

   



    public Product(int product_id,String name, int price, String imageUrl, String description, String brand, String category,int quantity) {
		super();
		this.product_id=product_id;
		this.name = name;
		this.price = price;
		this.imageUrl = imageUrl;
		this.description = description;
		this.brand = brand;
		this.category = category;
		this.quantity=quantity;
	}
    public int getQuantity() {
    	return quantity;
    }
    
    public int getPid() {
    	return product_id;
    }

	public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}