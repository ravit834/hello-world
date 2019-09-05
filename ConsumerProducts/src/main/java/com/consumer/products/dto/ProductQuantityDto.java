package com.consumer.products.dto;

public class ProductQuantityDto {
	
	private String productType;
	
	private Integer productQuantity;

	public String getProductType() {
		return productType;
	}

	public void setProductType(String productType) {
		this.productType = productType;
	}

	public Integer getProductQuantity() {
		return productQuantity;
	}

	public void setProductQuantity(Integer productQuantity) {
		this.productQuantity = productQuantity;
	}

	@Override
	public String toString() {
		return "ProductQuantityDto [productType=" + productType + ", productQuantity=" + productQuantity + "]";
	}
	

}
