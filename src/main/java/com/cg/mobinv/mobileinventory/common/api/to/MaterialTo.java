package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "Material")
@EdmEntitySet(name = "Materials")
public class MaterialTo {

    @EdmKey
    @EdmProperty
    private Long id;

    @EdmProperty
    private String description;

    @EdmProperty
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
