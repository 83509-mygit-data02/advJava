package com.sunbeam.entities;
import javax.persistence.*;


@Entity

public class Product {
//   products table - id , category (BAKERY|SHOES|CLOTHES|STATIONAY) ,product name(unique)  , price , available quantity
    @Id 
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
    
    @Enumerated(EnumType.STRING)
    @Column(length=25)
	private Category category;
    
	@Column(length = 25,unique=true)
	private String productName;
	
	private double price;
	
	private int availableQuantity;
	
	public Product() {
		
	}

	

	public Product(int availableQuantity, Category category, double price, String productName ) {
		super();
		this.category = category;
		this.productName = productName;
		this.price = price;
		this.availableQuantity = availableQuantity;
	}



	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getAvailableQuantity() {
		return availableQuantity;
	}

	public void setAvailableQuantity(int availableQuantity) {
		this.availableQuantity = availableQuantity;
	}

	@Override
	public String toString() {
		return "Product [id=" + id + ", category=" + category + ", productName=" + productName + ", price=" + price
				+ ", availableQuantity=" + availableQuantity + "]";
	}
	
	
	
}
