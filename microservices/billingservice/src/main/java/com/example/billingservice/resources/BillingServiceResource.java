package com.example.billingservice.resources;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/rest/billservice")
public class BillingServiceResource {

		@GetMapping
		public String Billing() {
			
			return "Programming Billing Microservices ";
			
		}

}
