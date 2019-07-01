package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.Locations\"")
public class LocationsEntity {
	
	@javax.persistence.Id
    @SequenceGenerator(name = "S_Locations", sequenceName = "\"hkrbudgetingdb.db::S_Locations\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Locations")
	private Long id;
	
	@Nationalized
	@Column(name = "\"LocationDescription\"")
	private String locationDescritpion;
	
	@Nationalized
	@Column(name = "\"Building\"")
	private String building;
	
	@Nationalized
	@Column(name = "\"Floor\"")
	private String floor;
	
	@Nationalized
	@Column(name = "\"Room\"")
	private String room;
	
	public LocationsEntity() {}
	
	public LocationsEntity(Long id, String locationDescription, String building, String floor, String room) {
		this.id = id;
		this.locationDescritpion = locationDescription;
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
		return locationDescritpion;
	}

	public void setLocationDescription(String locationDesc) {
		this.locationDescritpion = locationDesc;
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

	public void setFloor(String stock) {
		this.floor = stock;
	}

	public String getRoom() {
		return room;
	}

	public void setRoom(String room) {
		this.room = room;
	}
}
