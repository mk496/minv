package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.Inventory\"")
public class InventoryEntity {
	
	@javax.persistence.Id
    @SequenceGenerator(name = "S_Inventory", sequenceName = "\"hkrbudgetingdb.db::S_Inventory\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Inventory")
	private Long id;
	
	@Nationalized
	@Column(name = "\"ProductDescription\"")
	private String productDesc;
	
	@Nationalized
	@Column(name = "\"Price\"")
	private String price;
	
	@Nationalized
	@Column(name = "\"Currency\"")
	private String currency;
	
	@Nationalized
	@Column(name = "\"ShelfStock\"")
	private String shelfStock;
	
	@Nationalized
	@Column(name = "\"Location\"")
	private String location;
	
	@Nationalized
	@Column(name = "\"Image\"")
	private String image;
	
	@Nationalized
	@Column(name = "\"Status\"")
	private String status;
	
	@Nationalized
	@Column(name = "\"StatusColor\"")
	private String statusColor;

	@Nationalized
	@Column(name = "\"StoringInstruction\"")
	private String storingInstruction;
	
	@Nationalized
	@Column(name = "\"InStock\"")
	private String inStock;
	
	@Nationalized
	@Column(name = "\"Unit\"")
	private String unit;
	
	@Nationalized
	@Column(name = "\"LifeRemaining\"")
	private String lifeRemaining;
	
	@Nationalized
	@Column(name = "\"LifeRemainingTreshold\"")
	private String lifeRemainingTreshold;
	
	@Nationalized
	@Column(name = "\"ItemType\"")
	private String itemType;
	
	@Nationalized
	@Column(name = "\"OrderingTreshold\"")
	private String orderingTreshold;
	
	public InventoryEntity() {}
	
	public InventoryEntity(Long id, String productDesc, String price, String currency, String shelfStock,
			String location, String image, String status, String statusColor, String storingInstruction, String inStock,
			String unit, String lifeRemaining, String lifeRemainingTreshold, String itemType, String orderingTreshold) {
		this.id = id;
		this.productDesc = productDesc;
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
		return productDesc;
	}

	public void setProductDescription(String productDescription) {
		this.productDesc = productDescription;
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
