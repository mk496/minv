package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "Locations")
@EdmEntitySet(name = "LocationsSet")
public class LocationsTo {
	
	@EdmKey
    @EdmProperty
    private Long id;
	
	@EdmProperty
	private String locationDescription;
	
	@EdmProperty
	private String building;
	
	@EdmProperty
	private String stock;
	
	@EdmProperty
	private String room;
	
	public LocationsTo() {}
	
	public LocationsTo(Long id, String locationDescription, String building, String stock, String room) {
		this.id = id;
		this.locationDescription = locationDescription;
		this.building = building;
		this.stock = stock;
		this.room = room;
	}
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocationDescription() {
		return locationDescription;
	}

	public void setLocationDescription(String locationDescription) {
		this.locationDescription = locationDescription;
	}

	public String getBuilding() {
		return building;
	}

	public void setBuilding(String building) {
		this.building = building;
	}

	public String getStock() {
		return stock;
	}

	public void setStock(String stock) {
		this.stock = stock;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}