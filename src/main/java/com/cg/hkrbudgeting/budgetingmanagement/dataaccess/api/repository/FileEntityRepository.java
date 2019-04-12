package com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.repository;

import com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.FileEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FileEntityRepository extends JpaRepository<FileEntity, Long> {

	public FileEntity findByFileMatchings_Id(Long id);

}
