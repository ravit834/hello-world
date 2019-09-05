package com.consumer.products.dto;

public class ProductDiscountDto {
	
	private Integer productId;
	private boolean isDiscounted;
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public boolean isDiscounted() {
		return isDiscounted;
	}
	public void setDiscounted(boolean isDiscounted) {
		this.isDiscounted = isDiscounted;
	}
	@Override
	public String toString() {
		return "ProductDiscountDto [productId=" + productId + ", isDiscounted=" + isDiscounted + "]";
	}
	
	
	
	
}
