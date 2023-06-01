package com.ust.rest.resources;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ust.rest.resource.Products;
import com.ust.rest.services.ProductService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping("/product/api.2.0")
@Api(value="Product Service API 2.0",description = "Rest endpoints for Product API")
public class ProductsResource {
	
	@Autowired
	ProductService service;
	
	//CRUD create- POST, retrieve
	
	@GetMapping
	@RequestMapping("/retrieve/{productId}")
	@ApiOperation(value="Accepts PRoduct Id and Returns the Product entity")
	public Products fetchProduct(@PathVariable long productId ) {
		
		return service.getProduct(productId);
	}
	
	@GetMapping
	@RequestMapping("/retrieve/all")
	@ApiOperation(value="Accepts all PRoduct Id and Returns all the Product entity")
	public List<Products> fectchProducts(){
		
		return service.getProducts();
		
	}
	
	@PostMapping
	@RequestMapping(value="/create", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="creates the Product entity")
	public ResponseEntity<?> addProduct(@RequestBody Products product){
		
		Exception exception = null;
		Products tempProduct = null;
		
		try {
			service.add(product);
		
		}catch(Exception e) {
			exception = e;
		}
		
		if(tempProduct != null) {
			return ResponseEntity.status(HttpStatus.CREATED).body(tempProduct);
		}
		else {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(exception);
		}
//		boolean result = service.add(product);
//		if(result) {
//			return ResponseEntity.status(HttpStatus.CREATED).body(true);
//		}
//		else {
//			return ResponseEntity.status(HttpStatus.CREATED).body(false);
//		}
		
	}
	
	@PutMapping
	@RequestMapping(value="/update",  consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
	@ApiOperation(value="Updates the Product entity")
	public Products updateProduct(@RequestBody Products product) {
		
		return service.updateProduct(product);
	}
	
	@DeleteMapping
	@RequestMapping(value="/delete/{productId}")
	@ApiOperation(value="Deletes the Product entity")
	public void deleteProduct(@PathVariable long productId) {
		service.deleteProduct(productId);
	}
	
	@GetMapping
	public String test() {
		
		return "test() called......";
	}
	
	

}

