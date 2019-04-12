package com.cg.hkrbudgeting.reportengine.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.EdmComplexType;
import org.apache.olingo.odata2.api.annotation.edm.EdmProperty;

@EdmComplexType(namespace = "com.cg.hkrbudgeting.reportengine.common.api.to")
public class MediaResource {

    @EdmProperty
    private String mimeType;

    @EdmProperty
    private byte[] data;

    public MediaResource(String mimeType, byte[] data) {

        this.mimeType = mimeType;
        this.data = data;
    }

    public String getMimeType() {

        return mimeType;
    }

    public void setMimeType(String mimeType) {

        this.mimeType = mimeType;
    }

    public byte[] getData() {

        return data;
    }

    public void setData(byte[] data) {

        this.data = data;
    }

}
