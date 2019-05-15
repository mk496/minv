package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionItem\"")
public class RequisitionItemEntity {
	
	@javax.persistence.Id
    @SequenceGenerator(name = "S_RequisitionItem", sequenceName = "\"hkrbudgetingdb.db::S_RequisitionItem\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_RequisitionItem")
	private Long id;
	
	@Nationalized
	@Column(name = "\"ItemDescription\"")
	private String itemDesc;
	
	@Nationalized
	@Column(name = "\"Quantity\"")
	private int quantity;
	
	@Nationalized
	@Column(name = "\"Unit\"")
	private String unit;
	
	@ManyToOne
	@JoinColumn(name="requisitionHeader_id")
	private RequisitionHeaderEntity requisitionHeader;
	
	public RequisitionItemEntity() {}

	public RequisitionItemEntity(Long id, String itemDesc, int quantity, String unit,
			RequisitionHeaderEntity requisitionHeader) {
		this.id = id;
		this.itemDesc = itemDesc;
		this.quantity = quantity;
		this.unit = unit;
		this.requisitionHeader = requisitionHeader;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getItemDesc() {
		return itemDesc;
	}

	public void setItemDesc(String itemDesc) {
		this.itemDesc = itemDesc;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public String getUnit() {
		return unit;
	}

	public void setUnit(String unit) {
		this.unit = unit;
	}

	public RequisitionHeaderEntity getRequisitionHeader() {
		return requisitionHeader;
	}

	public void setRequisitionHeader(RequisitionHeaderEntity requisitionHeader) {
		this.requisitionHeader = requisitionHeader;
	}
	

}
