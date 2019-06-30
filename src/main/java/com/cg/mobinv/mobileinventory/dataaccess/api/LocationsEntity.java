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
	@Column(name = "\"Stock\"")
	private String stock;
	
	@Nationalized
	@Column(name = "\"Room\"")
	private String room;
	
	public LocationsEntity() {}
	
	public LocationsEntity(Long id, String locationDescription, String building, String stock, String room) {
		this.id = id;
		this.locationDescritpion = locationDescription;
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

	public String getLocationDesc() {
		return locationDescritpion;
	}

	public void setLocationDesc(String locationDesc) {
		this.locationDescritpion = locationDesc;
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
