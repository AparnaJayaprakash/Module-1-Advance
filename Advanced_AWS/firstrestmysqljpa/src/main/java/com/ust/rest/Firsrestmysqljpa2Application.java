package com.ust.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.context.ConfigurableApplicationContext;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.resource.Products;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication //(exclude= {DataSourceAutoConfiguration.class})
@EnableSwagger2
public class Firsrestmysqljpa2Application implements CommandLineRunner {
	
	@Autowired
	ProductRepository repo;

	public static void main(String[] args) {
		//SpringApplication.run(Firsrestmysqljpa2Application.class, args);
		ConfigurableApplicationContext ctxt = SpringApplication.run(Firsrestmysqljpa2Application.class, args);
		for(String str: args) {
			System.out.print(str);
		}
		boolean found = ctxt.containsBean("productRepository");
		boolean found2 = ctxt.containsBean("repo");
		System.out.println(found);
		System.out.println(found2);
	}
	
	@Override
	public void run(String...args) throws Exception{
		System.out.println("fromCommandLineRunner");
		List<Products> products = repo.findAll();
		System.out.println(products.size());
		
		//15 days 45 days changes passwords
		//starts we want
	}
	

}
