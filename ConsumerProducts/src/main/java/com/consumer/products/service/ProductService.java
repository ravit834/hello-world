package com.consumer.products.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.stream.Collectors;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.consumer.products.dto.ProductDiscountDto;
import com.consumer.products.dto.ProductDto;
import com.consumer.products.entity.Product;
import com.consumer.products.exception.ProductException;
import com.consumer.products.repository.ProductRepository;

@Service
public class ProductService {
	public static final Logger log = LoggerFactory.getLogger(ProductService.class);
	
	@Autowired
	ProductRepository productRepository;
	
	public List<ProductDto> getAllProducts(){
		List<Product> listOfProducts = productRepository.findAll();
		List<ProductDto> listOfProductDto = new ArrayList<ProductDto>();
		List<Product> listOfProductsOrdered = new ArrayList<>();
		listOfProductsOrdered.addAll(listOfProducts.stream().filter(product -> product.getIsDiscounted()==true).collect(Collectors.toList()));
		listOfProductsOrdered.addAll(listOfProducts.stream().filter(product -> product.getIsDiscounted()==false).collect(Collectors.toList()));
		listOfProductsOrdered.forEach(product ->{
			ProductDto productDto = new ProductDto(product.getProductId() + "|" + "(" + product.getProductPrice() + ")");
			listOfProductDto.add(productDto);
		});
		log.info("Products data retieved "+  listOfProductDto);
		return listOfProductDto;
	}
	
	public ProductDiscountDto checkIsDiscountedProduct(Integer productId) {
		Product product = null;
		try {
			 product = productRepository.findById(productId).get();
		}catch(NoSuchElementException noSuchElementException) {
			throw new ProductException("Product not found", HttpStatus.NOT_FOUND);
		}		
		ProductDiscountDto productDiscount = new ProductDiscountDto();
		productDiscount.setProductId(product.getProductId());
		productDiscount.setDiscounted(product.getIsDiscounted());
		log.info("Discounted product is  "+  productDiscount);
		return productDiscount;
	}
	
	public Map<String,Integer> getQuantityByType() {
		List<Product> listOfProducts = productRepository.findAll();
		Map<String,Integer> resultMap = new HashMap<String, Integer>();
		Set<String> productTypes = new HashSet<>();
		listOfProducts.forEach(product ->  {
			productTypes.add(product.getProductType());
		});		
		productTypes.forEach(productType -> {
			List<Product> items  = listOfProducts.stream().filter(product -> product.getProductType().equals(productType)).collect(Collectors.toList());
			Integer sumOfQuantitiesSold = items.stream().map(x -> x. getQuantitySold()).reduce(0, Integer::sum);
			resultMap.put(productType, sumOfQuantitiesSold);
		});
		log.info("Quantity sold by type  "+  resultMap);
		return resultMap;
	}

}
