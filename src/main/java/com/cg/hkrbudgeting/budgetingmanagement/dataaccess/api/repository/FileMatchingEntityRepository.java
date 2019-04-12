package com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.repository;

import com.cg.hkrbudgeting.budgetingmanagement.dataaccess.api.FileMatchingEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FileMatchingEntityRepository extends JpaRepository<FileMatchingEntity, Long> {
    List<FileMatchingEntity> findByIsDeletedFalse();
}
