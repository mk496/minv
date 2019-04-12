package com.cg.mobinv.mobileinventory.dataaccess.api;

import javax.persistence.*;

import org.hibernate.annotations.Nationalized;

import java.io.Serializable;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.FileMatching\"")
public class FileMatchingEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "S_FileMatching", sequenceName = "\"hkrbudgetingdb.db::S_FileMatching\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_FileMatching")
    private Long id;

    @Column(name = "\"Status\"")
    private Integer status;

    @Column(name = "\"IsDeleted\"")
    private Boolean isDeleted;

    @Nationalized
    @Column(name = "\"FileName\"", length = 256)
    private String fileName;

    @Nationalized
    @Column(name = "\"UploadDate\"", length = 256)
    private String uploadDate;

    @Nationalized
    @Column(name = "\"UploadUser\"", length = 256)
    private String uploadUser;

    @ManyToOne
    @JoinColumn(name = "\"AssignedFile.ID\"")
    private FileEntity file;

    public FileMatchingEntity() {

    }

    /**
     * @return id
     */
    public Long getId() {

        return this.id;
    }

    /**
     * @param id new value of {@link #getid}.
     */
    public void setId(Long id) {

        this.id = id;
    }

    /**
     * @return status
     */
    public Integer getStatus() {

        return this.status;
    }

    /**
     * @param status new value of {@link #getstatus}.
     */
    public void setStatus(Integer status) {

        this.status = status;
    }

    /**
     * @return isDeleted
     */
    public Boolean getIsDeleted() {

        return this.isDeleted;
    }

    /**
     * @param isDeleted new value of {@link #getisDeleted}.
     */
    public void setIsDeleted(Boolean isDeleted) {

        this.isDeleted = isDeleted;
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

    /**
     * @return file
     */
    public FileEntity getFile() {

        return this.file;
    }

    /**
     * @param file new value of {@link #getfile}.
     */
    public void setFile(FileEntity file) {

        this.file = file;
    }

}
