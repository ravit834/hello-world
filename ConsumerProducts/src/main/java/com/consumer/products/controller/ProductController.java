package com.consumer.products.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.consumer.products.dto.ProductDiscountDto;
import com.consumer.products.dto.ProductDto;
import com.consumer.products.entity.Product;
import com.consumer.products.service.ProductService;

@RestController
public class ProductController {
	
	@Autowired
	ProductService productService;
	
	@GetMapping("/getAllProducts")
	public List<ProductDto> getAllProducts() {
		return productService.getAllProducts();	
	}
	
	@GetMapping("/checkIsDiscountedProduct/{productId}")
	public ProductDiscountDto checkIsDiscountedProduct(@PathVariable Integer productId) {
		return productService.checkIsDiscountedProduct(productId);	
	}
	
	@GetMapping("/quantitySoldByProductType")
	public Map<String,Integer> getQuantityByType() {
		return productService.getQuantityByType();
	}
	

}
