package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobinv.mobileinventory.dataaccess.api.FileMatchingEntity;

import java.util.List;

public interface FileMatchingEntityRepository extends JpaRepository<FileMatchingEntity, Long> {
    List<FileMatchingEntity> findByIsDeletedFalse();
}
