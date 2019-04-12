package com.cg.mobinv.mobileinventory.dataaccess.api;

import org.hibernate.annotations.Nationalized;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;

@Entity
@Table(name = "\"hkrbudgetingdb.db.dbmodel::hkrbudgeting.File\"")
public class FileEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @SequenceGenerator(name = "S_File", sequenceName = "\"hkrbudgetingdb.db::S_File\"", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "S_File")
    private Long id;

    @Lob
    @Column(name = "\"File\"")
    private Blob file;

    @Nationalized
    @Column(name = "\"Mime\"", length = 32)
    private String mime;

    @Column(name = "\"IsDeleted\"")
    private Boolean isDeleted;

    @OneToMany(mappedBy = "file")
    private List<FileMatchingEntity> fileMatchings;

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
     * @return file
     */
    public Blob getFile() {

        return this.file;
    }

    /**
     * @param file new value of {@link #getfile}.
     */
    public void setFile(Blob file) {

        this.file = file;
    }

    public String getMime() {

        return mime;
    }

    public void setMime(String mime) {

        this.mime = mime;
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

    public List<FileMatchingEntity> getFileMatchings() {

        return this.fileMatchings;
    }

    public void setFileMatchings(List<FileMatchingEntity> fileMatchings) {

        this.fileMatchings = fileMatchings;
    }
}
