package com.ust.rest.services;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import com.ust.rest.repository.ProductRepository;
import com.ust.rest.repository.UserRepository;
import com.ust.rest.resource.Products;
import com.ust.rest.resource.User;

@Service
public class ProductService {
	
	@Autowired
	ProductRepository productRepository;
	
	@Autowired
	UserRepository userRepository;
	
	public Products getProduct(long productId) {
		
		Optional<Products> optional = productRepository.findById(productId);
		if(optional.isPresent()) {
			return optional.get();
		}
		else {
			return null;
		}
		
	}

	public List<Products> getProducts() {
		
		return productRepository.findAll();
		
		
	}
	
	@Transactional(propagation = Propagation.REQUIRED)
	public Products add(Products product) {
		Products productT = productRepository.save(product);
		User user = new User();
		user.setUserId(5L);
		//user.setDateTime(System.currentTimeMillis()+"66867576657689890676454768798089676658708867658798");
		user.setDateTime(System.currentTimeMillis()+"");
		User userT= userRepository.save(user);
		return productT;
		
		
		
	}
	
	
	
	public Products updateProduct(Products product) {
		return productRepository.save(product);
	}
	
	
	public void deleteProduct(long productId) {
		 productRepository.deleteById(productId);
	}
	
	

}
