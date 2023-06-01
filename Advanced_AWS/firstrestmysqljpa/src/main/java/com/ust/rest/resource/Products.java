package com.ust.rest.resource;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Products {
	
	//Hibernate sql statement
//	select next_val as id_val from hibernate_sequence for update
//	Hibernate: update hibernate_sequence set next_val= ? where next_val=?
//	Hibernate: insert into products (description, name, price, qty, product_id) values (?, ?, ?, ?, ?)
	
	@Id
	//@GeneratedValue(strategy = GenerationType.AUTO)       // Generation type is strategy which jpa should use and follow to generate primary key values.. auto is the default generation type or strategy. i.e wheen strategy is not spedified the jpa uses auto strategy.
	                                                       //When the underline database is mysql the generationType.auto means the jpa will create a hibernate sequence in the database for generation of primary keys.
	
	@GeneratedValue(strategy = GenerationType.AUTO)   //for this strategy to work first we have to create a table in mysql database and explicitly specify the auto-increment(AI) column as checked for the primary key column.
	                                       // and in application.properties file "spring.jpa.hibernate.ddl-auto= update" this should not be set if it is set it should have value as update.
	@Column(name="productid")
	private long productId;
	private String name;
	private String description;
	private BigDecimal price;
	private int qty;
	
	
	public long getProductId() {
		return productId;
	}
	public void setProductId(long productId) {
		this.productId = productId;
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
	public BigDecimal getPrice() {
		return price;
	}
	public void setPrice(BigDecimal price) {
		this.price = price;
	}
	public int getQty() {
		return qty;
	}
	public void setQty(int qty) {
		this.qty = qty;
	}
	
	
	

}
