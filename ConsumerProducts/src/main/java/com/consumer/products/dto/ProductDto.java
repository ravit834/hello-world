package com.consumer.products.dto;

public class ProductDto {
	
	private String productInformation;
	
	

	public ProductDto(String productInformation) {
		super();
		this.productInformation = productInformation;
	}

	public String getProductInformation() {
		return productInformation;
	}

	public void setProductInformation(String productInformation) {
		this.productInformation = productInformation;
	}

	@Override
	public String toString() {
		return "ProductDto [productInformation=" + productInformation + "]";
	}
	
	

}
