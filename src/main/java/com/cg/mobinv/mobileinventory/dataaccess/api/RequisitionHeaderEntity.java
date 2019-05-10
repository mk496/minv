package com.cg.mobinv.mobileinventory.dataaccess.api;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionHeader\"")
public class RequisitionHeaderEntity {
	
	@javax.persistence.Id
    @SequenceGenerator(name = "S_RequisitionHeader", sequenceName = "\"hkrbudgetingdb.db::S_RequisitionHeader\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_RequisitionHeader")
	private Long id;
	
	@Nationalized
	@Column(name = "\"RequisitionDescription\"")
	private String reqDesc;
	
	@Nationalized
	@Column(name = "\"NewAttribute\"")
	private Integer newAttr;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.RequisitionHeader\"")
	private List<RequisitionItemEntity> items;

	public RequisitionHeaderEntity() {}

	public RequisitionHeaderEntity(Long id, String reqDesc, Integer newAttr, List<RequisitionItemEntity> items) {
		this.id = id;
		this.reqDesc = reqDesc;
		this.newAttr = newAttr;
		this.items = items;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getReqDesc() {
		return reqDesc;
	}

	public void setReqDesc(String reqDesc) {
		this.reqDesc = reqDesc;
	}

	public Integer getNewAttr() {
		return newAttr;
	}

	public void setNewAttr(Integer newAttr) {
		this.newAttr = newAttr;
	}

	public List<RequisitionItemEntity> getItems() {
		return items;
	}

	public void setItems(List<RequisitionItemEntity> items) {
		this.items = items;
	}
	
	
}
