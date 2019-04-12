package com.cg.mobinv.mobileinventory.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "File")
@EdmEntitySet(name = "Files")
public class FileTo {

    @EdmKey
    @EdmProperty
    private Long id;

    @EdmMediaResourceContent
    private byte[] file;

    @EdmProperty
    private String mime;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public byte[] getFile() {

        return file;
    }

    public void setFile(byte[] file) {

        this.file = file;
    }

    public String getMime() {

        return mime;
    }

    public void setMime(String mime) {

        this.mime = mime;
    }

}
