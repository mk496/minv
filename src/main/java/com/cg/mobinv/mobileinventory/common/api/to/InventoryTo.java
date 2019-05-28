package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "Inventory")
@EdmEntitySet(name = "InventorySet")
public class InventoryTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String productDescription;
	
	@EdmProperty
	private String price;
	
	@EdmProperty
	private String currency;
	
	@EdmProperty
	private String shelfStock;
	
	@EdmProperty
	private String location;
	
	@EdmProperty
	private String image;
	
	@EdmProperty
	private String status;
	
	@EdmProperty
	private String statusColor;

	@EdmProperty
	private String storingInstruction;
	
	@EdmProperty
	private String inStock;
	
	@EdmProperty
	private String unit;
	
	@EdmProperty
	private String lifeRemaining;
	
	@EdmProperty
	private String lifeRemainingTreshold;
	
	@EdmProperty
	private String itemType;
	
	@EdmProperty
	private String orderingTreshold;
	
	public InventoryTo() {}
	
	public InventoryTo(Long id, String productDescription, String price, String currency, String shelfStock,
			String location, String image, String status, String statusColor, String storingInstruction, String inStock,
			String unit, String lifeRemaining, String lifeRemainingTreshold, String itemType, String orderingTreshold) {
		this.id = id;
		this.productDescription = productDescription;
		this.price = price;
		this.currency = currency;
		this.shelfStock = shelfStock;
		this.location = location;
		this.image = image;
		this.status = status;
		this.statusColor = statusColor;
		this.storingInstruction = storingInstruction;
		this.inStock = inStock;
		this.unit = unit;
		this.lifeRemaining = lifeRemaining;
		this.lifeRemainingTreshold = lifeRemainingTreshold;
		this.itemType = itemType;
		this.orderingTreshold = orderingTreshold;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getProductDescription() {
		return productDescription;
	}

	public void setProductDescription(String productDescription) {
		this.productDescription = productDescription;
	}

	public String getPrice() {
		return price;
	}

	public void setPrice(String price) {
		this.price = price;
	}

	public String getCurrency() {
		return currency;
	}

	public void setCurrency(String currency) {
		this.currency = currency;
	}

	public String getShelfStock() {
		return shelfStock;
	}

	public void setShelfStock(String shelfStock) {
		this.shelfStock = shelfStock;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getImage() {
		return image;
	}

	public void setImage(String image) {
		this.image = image;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	public String getStoringInstruction() {
		return storingInstruction;
	}

	public void setStoringInstruction(String storingInstruction) {
		this.storingInstruction = storingInstruction;
	}

	public String getInStock() {
		return inStock;
	}

	public void setInStock(String inStock) {
		this.inStock = inStock;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public String getLifeRemaining() {
		return lifeRemaining;
	}

	public void setLifeRemaining(String lifeRemaining) {
		this.lifeRemaining = lifeRemaining;
	}

	public String getLifeRemainingTreshold() {
		return lifeRemainingTreshold;
	}

	public void setLifeRemainingTreshold(String lifeRemainingTreshold) {
		this.lifeRemainingTreshold = lifeRemainingTreshold;
	}

	public String getItemType() {
		return itemType;
	}

	public void setItemType(String itemType) {
		this.itemType = itemType;
	}

	public String getOrderingTreshold() {
		return orderingTreshold;
	}

	public void setOrderingTreshold(String orderingTreshold) {
		this.orderingTreshold = orderingTreshold;
	}
	

}
