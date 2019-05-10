package com.cg.mobinv.mobileinventory.dataaccess.api.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cg.mobinv.mobileinventory.dataaccess.api.InventoryEntity;

public interface InventoryEntityRepository extends JpaRepository<InventoryEntity, Long> {

}
