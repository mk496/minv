package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobinv.mobileinventory.dataaccess.api.FileEntity;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {

	public FileEntity findByFileMatchings_Id(Long id);

}
