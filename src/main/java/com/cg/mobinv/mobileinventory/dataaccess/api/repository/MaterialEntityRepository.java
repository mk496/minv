package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobinv.mobileinventory.dataaccess.api.MaterialEntity;

public interface MaterialEntityRepository extends JpaRepository<MaterialEntity, Long> {
}
