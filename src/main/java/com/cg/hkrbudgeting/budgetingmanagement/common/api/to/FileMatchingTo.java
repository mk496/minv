package com.cg.hkrbudgeting.budgetingmanagement.common.api.to;

import org.apache.olingo.odata2.api.annotation.edm.*;

@EdmEntityType(name = "FileMatching")
@EdmEntitySet(name = "FileMatchings")
public class FileMatchingTo {

    @EdmKey
    @EdmProperty
    private Long id;

    @EdmProperty
    private Integer status;

    @EdmNavigationProperty
    private FileTo file;

    @EdmProperty
    private String fileName;

    @EdmProperty
    private String uploadDate;

    @EdmProperty
    private String uploadUser;

    public Long getId() {

        return id;
    }

    public void setId(Long id) {

        this.id = id;
    }

    public Integer getStatus() {

        return status;
    }

    public void setStatus(Integer status) {

        this.status = status;
    }

    public FileTo getFile() {

        return file;
    }

    public void setFile(FileTo file) {

        this.file = file;
    }

    public String getFileName() {

        return fileName;
    }

    public void setFileName(String fileName) {

        this.fileName = fileName;
    }

    public String getUploadDate() {

        return uploadDate;
    }

    public void setUploadDate(String uploadDate) {

        this.uploadDate = uploadDate;
    }

    public String getUploadUser() {

        return uploadUser;
    }

    public void setUploadUser(String uploadUser) {

        this.uploadUser = uploadUser;
    }
}
