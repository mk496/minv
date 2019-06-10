package com.cg.mobinv.mobileinventory.dataaccess.api;

import java.io.Serializable;
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
public class RequisitionHeaderEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@javax.persistence.Id
    @SequenceGenerator(name = "S_RequisitionHeader", sequenceName = "\"hkrbudgetingdb.db::S_RequisitionHeader\"", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_RequisitionHeader")
	private Long id;
	
	@Nationalized
	@Column(name = "\"RequisitionDescription\"")
	private String requisitionDescription;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy = "requisitionHeader")
	private List<RequisitionItemEntity> toItems;

	public RequisitionHeaderEntity() {}


	public RequisitionHeaderEntity(Long id, String requisitionDescription,
			List<RequisitionItemEntity> toItems) {
		this.id = id;
		this.requisitionDescription = requisitionDescription;
		this.toItems = toItems;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getRequisitionDescription() {
		return requisitionDescription;
	}

	public void setRequisitionDescription(String requisitionDescription) {
		this.requisitionDescription = requisitionDescription;
	}

	public List<RequisitionItemEntity> getItems() {
		return toItems;
	}

	public void setItems(List<RequisitionItemEntity> toItems) {
		this.toItems = toItems;
	}
	
}
