package com.example.rabbit.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class PurchaseOrder {
	
	private String orderid;
	private String company;
	private int qty;
	private double price;
	
	

}
