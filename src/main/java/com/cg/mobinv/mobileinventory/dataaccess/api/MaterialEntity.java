package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.Material\"")
public class MaterialEntity {

    @javax.persistence.Id
    @SequenceGenerator(name = "S_Material", sequenceName = "\"hkrbudgetingdb.db::S_Material\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_Material")
    private Long id;

    @Nationalized
    @Column(name = "\"MaterialDescription\"")
    private String materialDescription;
    
    @Column(name = "\"ExpirationDays\"")
    private Integer expirationDays;
    
    @Nationalized
    @Column(name = "\"ExpirationType\"")
	private String expirationType;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getMaterialDesc() {
		return materialDescription;
	}

	public void setMaterialDesc(String materialDescription) {
		this.materialDescription = materialDescription;
	}

	public Integer getExpirationDays() {
		return expirationDays;
	}

	public void setExpirationDays(Integer expirationDays) {
		this.expirationDays = expirationDays;
	}

	public String getExpirationType() {
		return expirationType;
	}

	public void setExpirationType(String expirationType) {
		this.expirationType = expirationType;
	}

  
}
