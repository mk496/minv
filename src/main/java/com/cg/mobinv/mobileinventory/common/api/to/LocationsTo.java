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
	private String floor;
	
	@EdmProperty
	private String room;
	
	public LocationsTo() {}
	
	public LocationsTo(Long id, String locationDescription, String building, String floor, String room) {
		this.id = id;
		this.locationDescription = locationDescription;
		this.building = building;
		this.floor = floor;
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

	public String getFloor() {
		return floor;
	}

	public void setFloor(String floor) {
		this.floor = floor;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}