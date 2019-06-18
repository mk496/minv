package com.cg.mobinv.mobileinventory.dataaccess.api;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

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
	
	@Column(name = "\"RequisitionDate\"")
	@Temporal(TemporalType.TIMESTAMP)
	private Date requisitionDate;

	@Nationalized
	@Column(name = "\"RequisitionStatus\"")
	private String requisitionStatus;
	
	@OneToMany(fetch = FetchType.EAGER, cascade = {CascadeType.ALL},
			mappedBy = "requisitionHeader")
	private List<RequisitionItemEntity> toItems;

	public RequisitionHeaderEntity() {}

	public RequisitionHeaderEntity(Long id, String requisitionDescription, Date requisitionDate,
			String requisitionStatus, List<RequisitionItemEntity> toItems) {
		this.id = id;
		this.requisitionDescription = requisitionDescription;
		this.requisitionDate = requisitionDate;
		this.requisitionStatus = requisitionStatus;
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
	
	public Date getRequisitionDate() {
		return requisitionDate;
	}

	public void setRequisitionDate(Date requisitionDate) {
		this.requisitionDate = requisitionDate;
	}

	public String getRequisitionStatus() {
		return requisitionStatus;
	}

	public void setRequisitionStatus(String requisitionStatus) {
		this.requisitionStatus = requisitionStatus;
	}

	public List<RequisitionItemEntity> getItems() {
		return toItems;
	}

	public void setItems(List<RequisitionItemEntity> toItems) {
		this.toItems = toItems;
	}
	
}
