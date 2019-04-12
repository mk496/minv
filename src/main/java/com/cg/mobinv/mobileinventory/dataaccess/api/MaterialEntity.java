package com.cg.mobinv.mobileinventory.dataaccess.api;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.AdministrationUnitType\"")
public class MaterialEntity {

    private static final long serialVersionUID = 1L;

    @javax.persistence.Id
    @SequenceGenerator(name = "S_AdministrationUnitType", sequenceName = "\"hkrbudgetingdb.db::S_AdministrationUnitType\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_AdministrationUnitType")
    private Long id;

    @Nationalized
    @Column(name = "\"Description\"", length = 256)
    private String description;

    @Nationalized
    @Column(name = "\"Identifier\"", length = 512)
    private String identifier;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getIdentifier() {

        return identifier;
    }

    public void setIdentifier(String identifier) {

        this.identifier = identifier;
    }
}
