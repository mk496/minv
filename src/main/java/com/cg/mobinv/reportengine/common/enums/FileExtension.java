package com.cg.mobinv.reportengine.common.enums;

public enum FileExtension {

    PDF("application/pdf"),;

    private String type;

    public String getType() {

        return type;
    }

    FileExtension(String type) {

        this.type = type;
    }

    public static boolean isSupported(String fileExtension) {

        return FileExtension.valueOf(fileExtension) != null;
    }
}
